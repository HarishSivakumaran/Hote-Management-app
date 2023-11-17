package com.hotelmanagementwizard.hotelmanager.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    public Long id;
    public String firstName;
    public String lastName;
    public String login;
    @JsonIgnore
    private String password;
    public String token;
}
