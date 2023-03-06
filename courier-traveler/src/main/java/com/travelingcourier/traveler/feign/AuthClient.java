package com.travelingcourier.traveler.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthClient {

    @GetMapping("/api/v1/admin/get")
    public ResponseEntity<String> sayHello();

    @GetMapping("/api/v1/traveller/uservalid")
    public boolean valid(@RequestHeader("Authorization") String bearerToken);
}

