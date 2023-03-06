package com.travelingcourier.repository;


import com.travelingcourier.model.BookingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingDto, Integer> {
    //Optional<BookingDto> findByEmail(String email);
}