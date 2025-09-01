package com.car_detail.CarDetailsMS.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Car {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String modelName;

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

    public Car(String modelName, String description, String price) {
        this.modelName = modelName;
        this.description = description;
        this.price = price;
    }
}
