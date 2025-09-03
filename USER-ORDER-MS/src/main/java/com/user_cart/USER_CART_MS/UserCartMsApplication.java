package com.user_cart.USER_CART_MS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserCartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCartMsApplication.class, args);
	}

}
