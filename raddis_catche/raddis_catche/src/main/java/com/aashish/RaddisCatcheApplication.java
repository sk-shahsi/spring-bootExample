package com.aashish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RaddisCatcheApplication {


	public static void main(String[] args) {
		SpringApplication.run(RaddisCatcheApplication.class, args);
	}

}
