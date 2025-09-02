package com.micor_service.Car_Booking_MS.services;

import com.micor_service.Car_Booking_MS.dto.BookingDTO;
import com.micor_service.Car_Booking_MS.dto.SearchDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    public Page<BookingDTO> getBookings(SearchDTO searchDTO,
                                        int pageNumber,
                                        Sort sortBy,
                                        HttpServletRequest httpServletRequest){
        return null;
    }
}
