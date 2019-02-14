package com.saka.demo.eureka.sakaeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SakaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakaEurekaApplication.class, args);
	}

}

