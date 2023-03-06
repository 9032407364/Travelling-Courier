package com.travelingcourier.admin.exception;

public class TravellerNotFoundException extends RuntimeException {
    public TravellerNotFoundException(Integer id) {
        super("Could not find traveller with id: " + id);
    }
}

