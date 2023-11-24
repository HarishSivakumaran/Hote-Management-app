package com.hotelmanagementwizard.hotelmanager.dto;

import com.hotelmanagementwizard.hotelmanager.models.Room;
import com.hotelmanagementwizard.hotelmanager.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {
    public Long id;

    public String name;

    public String description;

    public UserDto owner;

    public String profileImage;

    public List<String> facilities = new ArrayList<>();

    public List<RoomDto> rooms = new ArrayList<>();
}
