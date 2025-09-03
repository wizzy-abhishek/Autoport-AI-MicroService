package com.car_detail.CarDetailsMS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true,
            nullable = false)
    private String modelName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarBrands carBrand;

    private String description;

    private String price;

    @LastModifiedDate
    private LocalDateTime lastModification;

    @OneToMany(mappedBy = "car",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<CarImages> carImages;

    public Car() {
    }

    public Car(String modelName, CarBrands carBrands,
               String description, String price) {
        this.carBrand = carBrands;
        this.modelName = modelName;
        this.description = description;
        this.price = price;
    }
}
