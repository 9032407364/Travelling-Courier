package com.travelingcourier.repo;



import com.travelingcourier.model.Traveller;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravellerRepository extends JpaRepository<Traveller,Integer> {

    @Query("SELECT t from Traveller t where t.departureSource =:departureSource AND arrivalDestination =:arrivalDestination")
    public List<Traveller> findListOfTraveller(@Param("departureSource") String departureSource,
                                               @Param("arrivalDestination") String arrivalDestination
                                               );
    //@Param("departureTime") String departureTime  AND departureTime =:departureTime
}
