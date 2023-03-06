package com.travelingcourier.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthService {
    @Autowired
    private AuthClient authClient;

    public AuthenticationResponse getAuthResponse(){
        return authClient.getAuthResponse();
    }
}

