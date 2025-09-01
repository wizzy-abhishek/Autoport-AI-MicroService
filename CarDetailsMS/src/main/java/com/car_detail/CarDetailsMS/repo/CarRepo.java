package com.car_detail.CarDetailsMS.repo;

import com.car_detail.CarDetailsMS.enitity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Car WHERE id > :id")
    List<Car> getAllCarAfterId(@Param("id") Long id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM Car c WHERE c.id NOT IN (SELECT id FROM vector_store)")
    List<Car> findCarsNotInVectorStore();

}
