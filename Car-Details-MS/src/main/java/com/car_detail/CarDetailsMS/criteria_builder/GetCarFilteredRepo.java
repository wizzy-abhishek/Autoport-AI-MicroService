package com.car_detail.CarDetailsMS.criteria_builder;

import com.car_detail.CarDetailsMS.dto.SearchDTO;
import com.car_detail.CarDetailsMS.enitity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GetCarFilteredRepo {

    private final EntityManager entityManager;

    public GetCarFilteredRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> getCarsAccordingToFilter(SearchDTO searchDTO){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);

        Root<Car> root = criteriaQuery.from(Car.class);
        List<Predicate> predicates = new ArrayList<>();

        if (searchDTO.modelName() != null && !searchDTO.modelName().isBlank()){
            predicates
                    .add(criteriaBuilder
                            .like(criteriaBuilder
                                            .lower(root.get("modelName")),
                                    "%" + searchDTO.modelName().toLowerCase() + "%"));
        }

        if (searchDTO.brand() != null && !searchDTO.brand().isBlank()){
            predicates
                    .add(criteriaBuilder
                            .like(criteriaBuilder
                                            .lower(root.get("carBrand")),
                                    "%" + searchDTO.brand().toLowerCase() + "%"));
        }

        if (searchDTO.description() != null && !searchDTO.description().isBlank()){
            predicates
                    .add(criteriaBuilder
                            .like(criteriaBuilder
                                            .lower(root.get("description")),
                                    "%" + searchDTO.description().toLowerCase() + "%"));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager
                .createQuery(criteriaQuery)
                .getResultList();
    }
}
