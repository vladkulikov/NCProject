package com.example.demo;

import com.example.demo.data.repositorys.EntityRepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.Assert.*;

@SpringBootTest
class NcProjectApplicationTests {

	@Test
	void contextLoads() {
		EntityRepositoryJDBC entityRepositoryJDBC = new EntityRepositoryJDBC();
		Assertions.assertNull(entityRepositoryJDBC.getEntityById(1));
	}



}
