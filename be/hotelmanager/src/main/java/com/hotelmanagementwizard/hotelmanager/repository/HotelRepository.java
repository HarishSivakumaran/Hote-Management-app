package com.hotelmanagementwizard.hotelmanager.repository;

import com.hotelmanagementwizard.hotelmanager.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<List<Hotel>> findByOwnerId(Long ownerId);
}
