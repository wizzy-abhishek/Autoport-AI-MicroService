package com.car_detail.CarDetailsMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class CarDetailsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDetailsMsApplication.class, args);
	}

}
