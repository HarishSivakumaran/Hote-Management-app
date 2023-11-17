package com.hotelmanagementwizard.hotelmanager.mapper;

import com.hotelmanagementwizard.hotelmanager.dto.CredentialsDto;
import com.hotelmanagementwizard.hotelmanager.dto.UserDto;
import com.hotelmanagementwizard.hotelmanager.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);

    @Mapping(target = "password", ignore = true)
    User toEntity(CredentialsDto creds);
}
