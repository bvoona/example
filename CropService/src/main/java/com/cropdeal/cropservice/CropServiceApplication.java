package com.cropdeal.cropservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient

public class CropServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropServiceApplication.class, args);
	}

}
