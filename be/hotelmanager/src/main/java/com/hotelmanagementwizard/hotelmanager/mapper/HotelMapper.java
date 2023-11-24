package com.hotelmanagementwizard.hotelmanager.mapper;

import com.hotelmanagementwizard.hotelmanager.dto.HotelDto;
import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    HotelDto toDto(Hotel hotel);
}
