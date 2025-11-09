package com.example.job_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class JobServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabase() {
		return args -> {
			System.out.println("=== Job Service démarré ===");
		};
	}
}