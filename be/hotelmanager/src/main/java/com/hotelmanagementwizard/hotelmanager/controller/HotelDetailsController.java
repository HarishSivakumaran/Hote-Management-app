package com.hotelmanagementwizard.hotelmanager.controller;

import com.hotelmanagementwizard.hotelmanager.dto.HotelDto;
import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import com.hotelmanagementwizard.hotelmanager.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelDetailsController {

    private final HotelService hotelService;

    @GetMapping("/hotels/{userId}")
    public ResponseEntity<List<HotelDto>> getHotelsOfAUser(@PathVariable Long userId) {
        List<HotelDto> hotels = hotelService.getHotels(userId);
        return ResponseEntity.ok(hotels);
    }
}
