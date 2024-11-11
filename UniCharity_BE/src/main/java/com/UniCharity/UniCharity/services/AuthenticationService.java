package com.UniCharity.UniCharity.services;

import com.UniCharity.UniCharity.dto.request.AuthenticationRequest;
import com.UniCharity.UniCharity.dto.request.IntrospectRequest;
import com.UniCharity.UniCharity.dto.response.authentication.AuthenticationResponse;
import com.UniCharity.UniCharity.dto.response.authentication.IntrospectResponse;
import com.UniCharity.UniCharity.exception.AppException;
import com.UniCharity.UniCharity.exception.ErrorCode;
import com.UniCharity.UniCharity.entities.User;
import com.UniCharity.UniCharity.repositories.UserRepository;
import com.UniCharity.UniCharity.services.iservices.IAuthenticationService;
import com.UniCharity.UniCharity.utils.JwtUtils;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService implements IAuthenticationService {
    UserRepository userRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verifierd = signedJWT.verify(verifier);
        return IntrospectResponse.builder().valid(verifierd && expityTime.after(new Date())).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        boolean authentication = passwordEncoder.matches(request.getPassword(), user.getPassword());
        if(!authentication) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        var token = JwtUtils.generateToken(user);
        JwtUtils.addTokenToCookie(response, token);
        return AuthenticationResponse.builder().token(token).authenticated(true).build();
    }
}
