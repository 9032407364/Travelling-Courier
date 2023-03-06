package com.travelingcourier.traveler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllTravelDto {

    private String departureSource;
    private String arrivalDestination;
    private String departureTime;
    private String arrivalTime;
}
