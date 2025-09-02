package com.micor_service.Car_Booking_MS.dto;


import java.time.LocalDateTime;

public record SearchDTO(String email,
                        String modelName,
                        LocalDateTime dateRangeStart,
                        LocalDateTime dateRangeEnd,
                        String buyerName) {

}
