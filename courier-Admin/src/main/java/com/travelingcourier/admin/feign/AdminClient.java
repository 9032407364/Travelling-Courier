package com.travelingcourier.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTH-SERVICE")
public interface AdminClient {

    @GetMapping("/api/v1/admin/get")
    public ResponseEntity<String> sayHello();

    @GetMapping("/api/v1/auth/secret")
    public AuthenticationResponse getAuthResponse();

    @GetMapping("/api/v1/admin/uservalid")
    public boolean valid(@RequestHeader("Authorization") String bearerToken);
}

