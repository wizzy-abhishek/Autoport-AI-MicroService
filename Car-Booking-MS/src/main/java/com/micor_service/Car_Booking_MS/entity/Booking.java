package com.micor_service.Car_Booking_MS.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String modelName;

    @Column(nullable = false)
    private String buyerName;

    @Column(nullable = false)
    private String buyerEmail;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private char currencySymbol;

    @Column
    private String userDescription;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime purchaseDate;

    public Booking(String modelName,
                   String buyerName,
                   String buyerEmail,
                   BigDecimal price,
                   char currencySymbol,
                   String userDescription) {

        this.modelName = modelName;
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.price = price;
        this.currencySymbol = currencySymbol;
        this.purchaseDate = LocalDateTime.now();
        this.userDescription = userDescription;
    }
}
