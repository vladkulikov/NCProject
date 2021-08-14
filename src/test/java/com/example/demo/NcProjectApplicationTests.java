package com.example.demo;

import com.example.demo.repositories.EntityRepository;
import com.example.demo.repositories.EntityRepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class NcProjectApplicationTests {

	@Test
	void getEntityById() {
		EntityRepository entityRepository = new EntityRepositoryJDBC();
		Assertions.assertNull(entityRepository.getEntityById(1));
	}

}
