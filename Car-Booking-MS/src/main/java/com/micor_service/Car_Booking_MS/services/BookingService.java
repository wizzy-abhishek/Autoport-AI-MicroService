package com.micor_service.Car_Booking_MS.services;

import com.micor_service.Car_Booking_MS.creteria_builder.BookingCriteriaBuilder;
import com.micor_service.Car_Booking_MS.dto.BookingDTO;
import com.micor_service.Car_Booking_MS.dto.SearchDTO;
import com.micor_service.Car_Booking_MS.entity.Booking;
import com.micor_service.Car_Booking_MS.repo.BookingRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final static int PAGE_SIZE = 10 ;

    private final BookingRepo bookingRepo;
    private final BookingCriteriaBuilder bookingCriteriaBuilder;

    public BookingService(BookingRepo bookingRepo, BookingCriteriaBuilder bookingCriteriaBuilder) {
        this.bookingRepo = bookingRepo;
        this.bookingCriteriaBuilder = bookingCriteriaBuilder;
    }

    public Page<BookingDTO> getBookings(SearchDTO searchDTO,
                                        int pageNumber,
                                        Sort sortBy,
                                        HttpServletRequest httpServletRequest){

        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, sortBy);

        List<Booking> bookings = bookingCriteriaBuilder.bookingsFiltering(searchDTO);

        List<BookingDTO> collect = bookings
                .stream()
                .map(BookingService::getBookingDTO)
                .toList();
        
        return new PageImpl<>(collect, pageRequest, collect.size());
    }

    private static BookingDTO getBookingDTO(Booking booking){
        return new BookingDTO(booking.getModelName(),
                booking.getBuyerName(),
                booking.getBuyerEmail(),
                String.valueOf(booking.getCurrencySymbol() + "" + booking.getPrice()),
                String.valueOf(booking.getPurchaseDate())
                );
    }
}
