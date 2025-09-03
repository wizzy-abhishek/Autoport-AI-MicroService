package com.user_cart.USER_CART_MS.repo;

import com.user_cart.USER_CART_MS.entity.Booking;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderBookingRepo extends JpaRepository<Booking, String> {

    List<Booking> findAllByBuyerEmailIgnoreCase(String email, Sort sort);
}
