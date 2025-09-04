package com.micor_service.Car_Booking_MS.controller;

import com.micor_service.Car_Booking_MS.dto.BookingDTO;
import com.micor_service.Car_Booking_MS.dto.SearchDTO;
import com.micor_service.Car_Booking_MS.services.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car-booking")
public class CarBookingDetailsController {

    private final BookingService bookingService;

    public CarBookingDetailsController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/get-bookings")
    ResponseEntity<Page<BookingDTO>> getBookings(@RequestBody SearchDTO searchDTO,
                                                 @RequestParam(defaultValue = "0") int pageNumber,
                                                 @RequestParam(defaultValue = "purchaseDate") String sortBy,
                                                 @RequestParam(defaultValue = "false") boolean ascending,
                                                 HttpServletRequest httpServletRequest){


        return ResponseEntity.ok()
                .body(bookingService
                        .getBookings(searchDTO,
                                pageNumber,
                                sortBy,
                                ascending,
                                httpServletRequest));

    }
}
