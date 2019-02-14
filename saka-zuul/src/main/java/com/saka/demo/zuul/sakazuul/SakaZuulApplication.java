package com.saka.demo.zuul.sakazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class SakaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakaZuulApplication.class, args);
	}

}

