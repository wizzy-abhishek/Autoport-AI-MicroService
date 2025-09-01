package com.car_detail.CarDetailsMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarDetailsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDetailsMsApplication.class, args);
	}

}
