package com.user_cart.USER_CART_MS.controller;

import com.user_cart.USER_CART_MS.dto.UserOrderResponseDTO;
import com.user_cart.USER_CART_MS.service.UserOrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class MyOrderController {

    private final UserOrderService cartService;

    public MyOrderController(UserOrderService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/my-orders")
    ResponseEntity<Page<UserOrderResponseDTO>> userOrders(HttpServletRequest httpServletRequest,
                                                        @RequestParam(defaultValue = "1") int pageNumber,
                                                        @RequestParam(defaultValue = "purchaseDate") String sortBy,
                                                        @RequestParam(defaultValue = "false") boolean ascending){
        return ResponseEntity.ok()
                .body(cartService
                .userOrderItems(httpServletRequest,
                        pageNumber,
                        sortBy,
                        ascending));
    }
}
