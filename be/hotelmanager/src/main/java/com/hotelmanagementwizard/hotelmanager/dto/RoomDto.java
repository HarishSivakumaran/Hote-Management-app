package com.hotelmanagementwizard.hotelmanager.dto;

import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomDto {
    public Long id;

    public String name;

    public String description;

    public HotelDto hotel;

    public List<String> images = new ArrayList();

    public List<String> facilities = new ArrayList<>();
}
