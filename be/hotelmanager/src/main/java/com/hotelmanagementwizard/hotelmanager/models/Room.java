package com.hotelmanagementwizard.hotelmanager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String description;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    public Hotel hotel;

    public List<String> images = new ArrayList();

    public List<String> facilities = new ArrayList<>();
}
