package com.car_detail.CarDetailsMS.criteria_builder;

import com.car_detail.CarDetailsMS.dto.SearchDTO;
import com.car_detail.CarDetailsMS.enitity.Car;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetCarFilteredRepo {

    private final EntityManager entityManager;

    public GetCarFilteredRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> getCarsAccordingToFilter(SearchDTO searchDTO){

        return null;
    }
}
