package com.hotelmanagementwizard.hotelmanager.mapper;

import com.hotelmanagementwizard.hotelmanager.dto.UserDto;
import com.hotelmanagementwizard.hotelmanager.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
