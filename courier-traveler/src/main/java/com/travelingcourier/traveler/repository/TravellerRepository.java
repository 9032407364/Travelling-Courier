package com.travelingcourier.traveler.repository;

import com.travelingcourier.traveler.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TravellerRepository extends JpaRepository<Traveller,Integer> {

    @Query("SELECT t from Traveller t where t.departureSource =:departureSource AND arrivalDestination =:arrivalDestination AND departureTime =:departureTime")
    public List<Traveller> findListOfTraveller(@Param("departureSource") String departureSource,
                                               @Param("arrivalDestination") String arrivalDestination,
                                               @Param("departureTime") String departureTime);
}
