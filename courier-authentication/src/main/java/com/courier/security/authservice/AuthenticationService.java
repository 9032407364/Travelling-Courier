package com.courier.security.authservice;

import com.courier.security.authconfig.JwtService;

import com.courier.security.exception.EmailAlreadyExistException;
import com.courier.security.exception.UserNotFoundException;
import com.courier.security.repository.AdminRepository;
import com.courier.security.repository.CustomerRepository;
import com.courier.security.repository.TravellerRepository;
import com.courier.security.repository.UserRepository;
import com.courier.security.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AdminRepository adminRepository;
    private final TravellerRepository travellerRepository;
    private final CustomerRepository customerRepository;

    public AuthenticationResponse register(RegisterRequest request) throws EmailAlreadyExistException {
        Optional<User> existingUser = repository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistException("Email already in use");
        }

        Set<Role> roles = request.getRoles();
        for (Role role : roles) {
            if (role.equals(Role.ROLE_ADMIN)) {
                Admin admin = new Admin();
                admin.setFirstname(request.getFirstname());
                admin.setLastname(request.getLastname());
                admin.setEmail(request.getEmail());
                admin.setActive(true);
                admin.setPhone(request.getPhone());
                admin.setAddress(request.getAddress());
                admin.setPassword(passwordEncoder.encode(request.getPassword()));
                admin.setRole(role);
                admin.setAdharCard(request.getAdharCard());
                admin.setPanCard(request.getPanCard());
                adminRepository.save(admin);
            } else if (role.equals(Role.ROLE_TRAVELLER)) {
                Traveller traveller = new Traveller();
                traveller.setFirstname(request.getFirstname());
                traveller.setLastname(request.getLastname());
                traveller.setEmail(request.getEmail());
                traveller.setActive(true);
                traveller.setAddress(request.getAddress());
                traveller.setPhone(request.getPhone());
                traveller.setPassword(passwordEncoder.encode(request.getPassword()));
                traveller.setRole(role);
                traveller.setAdharCard(request.getAdharCard());
                traveller.setPanCard(request.getPanCard());
                travellerRepository.save(traveller);
            } else if (role.equals(Role.ROLE_CUSTOMER)) {
                Customer customer = new Customer();
                customer.setFirstname(request.getFirstname());
                customer.setLastname(request.getLastname());
                customer.setEmail(request.getEmail());
                customer.setActive(true);
                customer.setAddress(request.getAddress());
                customer.setPhone(request.getPhone());
                customer.setPassword(passwordEncoder.encode(request.getPassword()));
                customer.setRole(role);
                customer.setAdharCard(request.getAdharCard());
                customer.setPanCard(request.getPanCard());
                customerRepository.save(customer);

            }
        }


        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail()).panCard(request.getPanCard()).adharCard(request.getAdharCard())
                .password(passwordEncoder.encode(request.getPassword())).phone(request.getPhone()).address(request.getAddress())
                .role(roles).isActive(true)
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).user(user)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) throws UserNotFoundException {
        Optional<User> existingUser = repository.findByEmail(request.getEmail());
        boolean isActive = existingUser.get().isActive();

        if (isActive) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } else {
            throw new UserNotFoundException("User not authorized");
        }
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var user1 = User.builder().email(user.getEmail()).role(user.getRole()).firstname(user.getFirstname()).lastname(user.getLastname()).build();
        return AuthenticationResponse.builder()
                .token(jwtToken).user(user1)
                .build();
    }
}
