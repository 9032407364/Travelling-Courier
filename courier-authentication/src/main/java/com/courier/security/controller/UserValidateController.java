package com.courier.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserValidateController {
    @PreAuthorize("hasAnyAuthority('ROLE_TRAVELLER','ROLE_CUSTOMER')")
    @GetMapping("/uservalid")
    public boolean validate(@RequestHeader("Authorization") String bearerToken) {
        return true;
    }

}
