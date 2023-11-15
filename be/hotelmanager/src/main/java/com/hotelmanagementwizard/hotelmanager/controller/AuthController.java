package com.hotelmanagementwizard.hotelmanager.controller;

import com.hotelmanagementwizard.hotelmanager.dto.CredentialsDto;
import com.hotelmanagementwizard.hotelmanager.dto.UserDto;
import com.hotelmanagementwizard.hotelmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseEntity<UserDto> login (@RequestBody CredentialsDto credsDto) {
        UserDto user = userService.login(credsDto);
        return ResponseEntity.ok(user);
    }
}
