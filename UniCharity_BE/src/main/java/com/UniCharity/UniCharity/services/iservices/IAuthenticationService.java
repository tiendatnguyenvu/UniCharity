package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.AuthenticationRequest;

public interface IAuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
