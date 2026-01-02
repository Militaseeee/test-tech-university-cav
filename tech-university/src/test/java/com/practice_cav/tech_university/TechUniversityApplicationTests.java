package com.practice_cav.tech_university;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TechUniversityApplicationTests {

	@Test
	void contextLoads() {
	}

}
