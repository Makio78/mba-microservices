package br.com.fiap.mba.microservices.trilhas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class TrilhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrilhasApplication.class, args);
	}

}
