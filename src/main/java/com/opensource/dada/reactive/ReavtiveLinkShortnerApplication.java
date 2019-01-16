package com.opensource.dada.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ReavtiveLinkShortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReavtiveLinkShortnerApplication.class, args);
	}

}

