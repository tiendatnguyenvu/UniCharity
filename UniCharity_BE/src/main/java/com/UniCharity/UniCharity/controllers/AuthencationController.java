package com.UniCharity.UniCharity.controllers;

import com.UniCharity.UniCharity.dto.request.AuthenticationRequest;
import com.UniCharity.UniCharity.dto.response.ApiResponse;
import com.UniCharity.UniCharity.dto.response.AuthenticationResponse;
import com.UniCharity.UniCharity.services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthencationController {
    AuthenticationService service;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        boolean result = service.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().result(AuthenticationResponse.builder().authenticated(result).build()).build();
    }
}
