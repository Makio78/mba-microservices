package br.com.fiap.mba.microservices.colaboradores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ColaboradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColaboradorApplication.class, args);
	}

}
