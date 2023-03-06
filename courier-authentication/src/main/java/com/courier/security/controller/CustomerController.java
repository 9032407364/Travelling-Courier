package com.courier.security.controller;

import com.courier.security.exception.UserNotFoundException;
import com.courier.security.service.UserService;
import com.courier.security.authservice.RegisterRequest;
import com.courier.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    UserService userService;


    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
    @GetMapping("/uservalid")
    public boolean validate(@RequestHeader("Authorization") String bearerToken) {
        return true;
    }

    @GetMapping("/get")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello customer");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_CUSTOMER')")
    @PutMapping("/updatedetails")
    public ResponseEntity<User> userupdate(@RequestBody RegisterRequest registerRequest) throws UserNotFoundException {
        System.out.println("verify 1");
        User user = userService.Detailsupdate(registerRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
