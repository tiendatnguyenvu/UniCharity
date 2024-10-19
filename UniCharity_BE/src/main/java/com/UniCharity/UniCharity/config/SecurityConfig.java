package com.UniCharity.UniCharity.config;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig {
    private final String[] PUBLIC_ENDPOINT = {
            "/users",
            "/auth/token",
            "/auth/introspect"
    };
    @Value("${jwt.signerKey}")
    private String signerKey;
// JWT
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(request ->
//                request.requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINT).permitAll()
//                .anyRequest().authenticated());
//        httpSecurity.oauth2ResourceServer(oauth2 ->
//                oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder()))
//        );
//        httpSecurity.csrf(AbstractHttpConfigurer::disable);
//        return httpSecurity.build();
//    }
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
//        return NimbusJwtDecoder
//                .withSecretKey(secretKeySpec)
//                .macAlgorithm(MacAlgorithm.HS512)
//                .build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Cho phép tất cả các request
        httpSecurity.authorizeHttpRequests(request ->
                request.anyRequest().permitAll()); // Cho phép tất cả mọi request mà không cần xác thực
        httpSecurity.oauth2ResourceServer(AbstractHttpConfigurer::disable); // Vô hiệu hóa OAuth2 Resource Server
        httpSecurity.csrf(AbstractHttpConfigurer::disable); // Vô hiệu hóa CSRF cho API
        return httpSecurity.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
