package com.courier.security.controller;

import com.courier.security.authservice.AuthenticationRequest;
import com.courier.security.authservice.AuthenticationResponse;
import com.courier.security.authservice.AuthenticationService;
import com.courier.security.authservice.RegisterRequest;
import com.courier.security.exception.EmailAlreadyExistException;
import com.courier.security.exception.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    private AuthenticationResponse authresponse = null;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid
                                                           @RequestBody RegisterRequest request
    ) throws EmailAlreadyExistException {
        return ResponseEntity.ok(service.register(request));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/secret")
    public AuthenticationResponse authresponse() {
        return this.authresponse;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) throws UserNotFoundException {
        this.authresponse = service.authenticate(request);
        return ResponseEntity.ok(authresponse);
    }


}
