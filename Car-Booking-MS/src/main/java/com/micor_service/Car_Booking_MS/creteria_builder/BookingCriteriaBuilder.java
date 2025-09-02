package com.micor_service.Car_Booking_MS.creteria_builder;

import com.micor_service.Car_Booking_MS.dto.SearchDTO;
import com.micor_service.Car_Booking_MS.entity.Booking;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookingCriteriaBuilder {

    private final EntityManager entityManager;

    public BookingCriteriaBuilder(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Booking> bookingsFiltering(SearchDTO searchDTO) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Booking> query = cb.createQuery(Booking.class);
        Root<Booking> root = query.from(Booking.class);

        List<Predicate> predicates = new ArrayList<>();

        if (searchDTO.buyerName() != null && !searchDTO.buyerName().isBlank()) {
            predicates.add(cb.like(cb.lower(root.get("buyerName")),
                    "%" + searchDTO.buyerName().toLowerCase() + "%"));
        }

        if (searchDTO.email() != null && !searchDTO.email().isBlank()) {
            predicates.add(cb.like(cb.lower(root.get("buyerEmail")),
                    "%" + searchDTO.email().toLowerCase() + "%"));
        }

        if (searchDTO.modelName() != null && !searchDTO.modelName().isBlank()) {
            predicates.add(cb.like(cb.lower(root.get("modelName")),
                    "%" + searchDTO.modelName().toLowerCase() + "%"));
        }

        if (searchDTO.dateRangeStart() != null && searchDTO.dateRangeEnd() != null) {
            predicates.add(cb.between(root.get("purchaseDate"),
                    searchDTO.dateRangeStart(),
                    searchDTO.dateRangeEnd()));
        } else if (searchDTO.dateRangeStart() != null) {
            predicates.add(cb.between(root.get("purchaseDate"),
                    searchDTO.dateRangeStart(),
                    LocalDateTime.now()));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
