package com.micor_service.Car_Booking_MS.repo;

import com.micor_service.Car_Booking_MS.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String> {

}
