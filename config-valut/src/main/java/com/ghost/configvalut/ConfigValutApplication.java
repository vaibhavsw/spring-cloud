package com.ghost.configvalut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;

//@RefreshScope
@SpringBootApplication
@EnableConfigServer
public class ConfigValutApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigValutApplication.class, args);
	}

}
