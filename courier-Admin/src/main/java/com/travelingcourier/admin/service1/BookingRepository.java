package com.travelingcourier.admin.service1;



import com.travelingcourier.admin.model1.BookingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingDto, Integer> {
    //Optional<BookingDto> findByEmail(String email);
}