package com.example.demo;

import com.example.demo.model.Medicament;
import com.example.demo.repository.MedicamentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MedicamentRepository medicamentRepository) {
		List<Medicament> medicamentList = new ArrayList<>();
		return args -> {
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentList.add(new Medicament("ketozol", "1mois", 2));
			medicamentRepository.saveAll(medicamentList);

		};
		}

}
