package com.hotelmanagementwizard.hotelmanager.controller;

import com.hotelmanagementwizard.hotelmanager.config.UserAuthProvider;
import com.hotelmanagementwizard.hotelmanager.dto.CredentialsDto;
import com.hotelmanagementwizard.hotelmanager.dto.UserDto;
import com.hotelmanagementwizard.hotelmanager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;


    @PostMapping("/login")
    public ResponseEntity<UserDto> login (@RequestBody CredentialsDto credsDto) {
        UserDto user = userService.login(credsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register (@RequestBody CredentialsDto credsDto) {
        UserDto user = userService.register(credsDto);
        user.setToken(userAuthProvider.createToken(user));
        return ResponseEntity.created(URI.create("/users/"+user.getId())).body(user);
    }
}
