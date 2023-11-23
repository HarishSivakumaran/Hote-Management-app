package com.hotelmanagementwizard.hotelmanager.service;

import com.hotelmanagementwizard.hotelmanager.dto.HotelDto;
import com.hotelmanagementwizard.hotelmanager.mapper.HotelMapper;
import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import com.hotelmanagementwizard.hotelmanager.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelMapper hotelMapper;

    public List<HotelDto> getHotels(Long userId) {
        List<Hotel> hotelEntities = hotelRepository.findByOwnerId(userId);
        return hotelMapper.toDto(hotelEntities);
    }
}
