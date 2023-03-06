package com.travelingcourier.admin.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthService {
    @Autowired
    private AdminClient adminClient;

    public AuthenticationResponse getAuthResponse() {
        return adminClient.getAuthResponse();
    }
}

