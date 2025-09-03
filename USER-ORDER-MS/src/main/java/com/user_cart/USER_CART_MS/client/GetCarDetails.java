package com.user_cart.USER_CART_MS.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CAR-DETAILS-MS")
public interface GetCarDetails {


}
