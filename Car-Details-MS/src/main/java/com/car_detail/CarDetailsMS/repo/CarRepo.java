package com.car_detail.CarDetailsMS.repo;

import com.car_detail.CarDetailsMS.enitity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {


}
