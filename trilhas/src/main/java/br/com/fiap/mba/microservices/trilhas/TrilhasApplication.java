package br.com.fiap.mba.microservices.trilhas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
public class TrilhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrilhasApplication.class, args);
	}

}
