package com.micor_service.Car_Booking_MS.controller;

import com.micor_service.Car_Booking_MS.dto.BookingDTO;
import com.micor_service.Car_Booking_MS.dto.SearchDTO;
import com.micor_service.Car_Booking_MS.services.BookingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/car-booking")
public class CarBookingDetailsController {

    private final BookingService bookingService;

    public CarBookingDetailsController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/get-bookings")
    ResponseEntity<Page<BookingDTO>> getBookings(@RequestBody SearchDTO searchDTO,
                                                 @RequestParam(defaultValue = "0") int pageNumber,
                                                 @RequestParam(defaultValue = "purchaseDate") String sortBy,
                                                 @RequestParam(defaultValue = "true") boolean ascending,
                                                 HttpServletRequest httpServletRequest){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        return ResponseEntity.ok().body(bookingService.getBookings(searchDTO, pageNumber, sort, httpServletRequest));
    }
}
