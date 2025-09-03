package com.user_cart.USER_CART_MS.dto;

import com.user_cart.USER_CART_MS.entity.CarBrands;

import java.time.LocalDateTime;

public record UserOrderResponseDTO(String modelName,
                                   LocalDateTime purchaseDate,
                                   String price,
                                   String userDescription) {
}
