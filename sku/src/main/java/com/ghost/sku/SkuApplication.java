package com.ghost.sku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SkuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkuApplication.class, args);
	}

}
