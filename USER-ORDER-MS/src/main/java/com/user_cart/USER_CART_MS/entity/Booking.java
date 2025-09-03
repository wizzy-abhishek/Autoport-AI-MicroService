package com.user_cart.USER_CART_MS.entity;

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
    @Enumerated(EnumType.STRING)
    private CarBrands brand_name;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime purchaseDate;

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

}
