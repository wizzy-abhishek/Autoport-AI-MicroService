package com.service_registry.sr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrApplication.class, args);
	}

}
