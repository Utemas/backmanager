package com.backmanager.backmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("com.backmanager.backmanager.po")
@SpringBootApplication
public class BackmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackmanagerApplication.class, args);
	}
}
