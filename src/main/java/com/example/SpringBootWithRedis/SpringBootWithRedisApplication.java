package com.example.SpringBootWithRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.SpringBootWithRedis")
public class SpringBootWithRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithRedisApplication.class, args);
	}

}
