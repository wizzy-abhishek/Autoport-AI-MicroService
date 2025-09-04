package com.car_detail.CarDetailsMS.criteria_builder;

import com.car_detail.CarDetailsMS.dto.SearchDTO;
import com.car_detail.CarDetailsMS.enitity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GetCarFilteredRepo {

    private final EntityManager entityManager;

    public GetCarFilteredRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Car> getCarsAccordingToFilter(SearchDTO searchDTO, String sorting, boolean ascending){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);

        Root<Car> root = criteriaQuery.from(Car.class);
        List<Predicate> orPredicates = new ArrayList<>();

        if (searchDTO.modelName() != null && !searchDTO.modelName().isBlank()) {
            orPredicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("modelName")),
                    "%" + searchDTO.modelName().toLowerCase() + "%"
            ));
        }

        if (searchDTO.brand() != null && !searchDTO.brand().isBlank()) {
            orPredicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("carBrand")),
                    "%" + searchDTO.brand().toLowerCase() + "%"
            ));
        }

        if (searchDTO.description() != null && !searchDTO.description().isBlank()) {
            orPredicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("description")),
                    "%" + searchDTO.description().toLowerCase() + "%"
            ));
        }

        criteriaQuery.where(criteriaBuilder.or(orPredicates.toArray(new Predicate[0])));

        if(ascending){
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sorting)));
        }else{
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sorting)));
        }

        return entityManager
                .createQuery(criteriaQuery)
                .getResultList();
    }
}
