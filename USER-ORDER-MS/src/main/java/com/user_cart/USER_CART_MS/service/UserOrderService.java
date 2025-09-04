package com.user_cart.USER_CART_MS.service;

import com.user_cart.USER_CART_MS.dto.UserOrderResponseDTO;
import com.user_cart.USER_CART_MS.entity.Booking;
import com.user_cart.USER_CART_MS.repo.UserOrderBookingRepo;
import com.user_cart.USER_CART_MS.util.GetEmailFromToken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderService {

    private static final int PAGE_SIZE_5 = 5;

    private final UserOrderBookingRepo cartBookingRepo;
    private final GetEmailFromToken getEmailFromToken;

    public UserOrderService(UserOrderBookingRepo cartBookingRepo, GetEmailFromToken getEmailFromToken) {
        this.cartBookingRepo = cartBookingRepo;
        this.getEmailFromToken = getEmailFromToken;
    }

    public Page<UserOrderResponseDTO> userOrderItems(HttpServletRequest httpServletRequest,
                                                     int pageNumber,
                                                     String sortBy,
                                                     boolean ascending){

        final String email = getEmailFromToken.fetchAppUserEmail(httpServletRequest);

        Sort sort = ascending ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        List<Booking> usersBooking = cartBookingRepo
                .findAllByBuyerEmailIgnoreCase(email, sort);

        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE_5, sort);

        List<UserOrderResponseDTO> responseDTOS = usersBooking
                .stream()
                .map(UserOrderService::getCartResponseDTO)
                .toList();

        return new PageImpl<>(responseDTOS, pageRequest, responseDTOS.size());
    }

    public static UserOrderResponseDTO getCartResponseDTO(Booking booking){
        return new UserOrderResponseDTO(booking.getBrand_name()+ " " + booking.getModelName(),
                booking.getPurchaseDate(),
                booking.getCurrencySymbol() + "" + booking.getPrice(),
                booking.getUserDescription());
    }
}
