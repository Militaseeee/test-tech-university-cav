package com.practice_cav.tech_university;

import org.springframework.boot.SpringApplication;

public class TestTechUniversityApplication {

	public static void main(String[] args) {
		SpringApplication.from(TechUniversityApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
