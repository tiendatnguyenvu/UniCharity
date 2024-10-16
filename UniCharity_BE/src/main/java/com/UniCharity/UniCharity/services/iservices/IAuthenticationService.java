package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.AuthenticationRequest;
import com.UniCharity.UniCharity.dto.request.IntrospectRequest;
import com.UniCharity.UniCharity.dto.response.AuthenticationResponse;
import com.UniCharity.UniCharity.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface IAuthenticationService {
    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
