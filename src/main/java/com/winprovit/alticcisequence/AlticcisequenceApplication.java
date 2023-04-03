package com.winprovit.alticcisequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AlticcisequenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticcisequenceApplication.class, args);
	}

}
