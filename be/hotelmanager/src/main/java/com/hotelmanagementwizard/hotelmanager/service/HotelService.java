package com.hotelmanagementwizard.hotelmanager.service;

import com.hotelmanagementwizard.hotelmanager.dto.HotelDto;
import com.hotelmanagementwizard.hotelmanager.exception.AppException;
import com.hotelmanagementwizard.hotelmanager.mapper.HotelMapper;
import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import com.hotelmanagementwizard.hotelmanager.repository.HotelRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    private final HotelMapper hotelMapper;

    public List<HotelDto> getHotels(Long userId) {
        Optional<List<Hotel>> hotelEntities = hotelRepository.findByOwnerId(userId);
        return hotelEntities.stream().flatMap(List::stream).map(hotelMapper::toDto).toList();
    }
}
