package com.hotelmanagementwizard.hotelmanager.service;

import com.hotelmanagementwizard.hotelmanager.config.PasswordConfig;
import com.hotelmanagementwizard.hotelmanager.dto.CredentialsDto;
import com.hotelmanagementwizard.hotelmanager.dto.UserDto;
import com.hotelmanagementwizard.hotelmanager.exception.AppException;
import com.hotelmanagementwizard.hotelmanager.mapper.UserMapper;
import com.hotelmanagementwizard.hotelmanager.models.User;
import com.hotelmanagementwizard.hotelmanager.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login()).orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
       if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
           return userMapper.toDto(user);
       }

       throw new AppException("Invalid username or password", HttpStatus.BAD_REQUEST);
    }
}
