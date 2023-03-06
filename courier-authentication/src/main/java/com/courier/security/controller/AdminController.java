package com.courier.security.controller;

import com.courier.security.authservice.AuthenticationResponse;
import com.courier.security.authservice.RegisterRequest;
import com.courier.security.exception.UserNotFoundException;
import com.courier.security.model.User;
import com.courier.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {


    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/uservalid")
    public boolean validate(@RequestHeader("Authorization") String bearerToken) {
        return true;
    }

    @GetMapping("/get")
    //@Secured("ROLE_CUSTOMER")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello admin");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<User> userDeactive(@RequestBody RegisterRequest registerRequest) throws UserNotFoundException {
        System.out.println("verify 1");
        User user = userService.updateDetails(registerRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PutMapping("/updatedetails")
    public ResponseEntity<User> userDetatils(@RequestBody RegisterRequest registerRequest) throws UserNotFoundException {
        System.out.println("verify 1");
        User user = userService.Detailsupdate(registerRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
