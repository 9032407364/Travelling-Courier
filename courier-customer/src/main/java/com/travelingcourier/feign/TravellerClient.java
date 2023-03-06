package com.travelingcourier.feign;

import com.travelingcourier.dto.Traveller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "ADMIN-SERVICE")
public interface TravellerClient {

@GetMapping("/api/v3/search/{departureSource}/{arrivalDestination}/{departureTime}")
List<Traveller> searchForTravellers(@PathVariable String departureSource,
                                    @PathVariable String arrivalDestination,
                                    @PathVariable String departureTime, @RequestHeader("Authorization") String bearerToken);}
