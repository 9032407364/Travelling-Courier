package com.travelingcourier.feign;

import com.travelingcourier.dto.Traveller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {

    @GetMapping("/api/v1/admin/get")
    public ResponseEntity<String> sayHello();

    @GetMapping("/api/v1/auth/secret")
    public AuthenticationResponse getAuthResponse();

    @GetMapping("/api/v1/customer/uservalid")
    public boolean valid(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v4/travel/{id}")
    public Optional<Traveller> getById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id);
}

