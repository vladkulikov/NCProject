package com.example.demo;

//import com.example.demo.repositories.EntityRepositoryJDBC;
import com.example.demo.model.Entity;
import com.example.demo.model.EntityType;
import com.example.demo.repository.EntityRepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NcProjectApplicationTests {
	@Autowired
	EntityRepositoryJDBC entityRepository;
	@Test
	void getEntityById() {
	// Используем базу H2
		//EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
		//		.setType()// Используем базу H2
		//		.build();
		// Создадим JdbcTemplate

		//JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);
		EntityType entityType = new EntityType();
		entityType.setId(1);
		entityType.setName("admin");
		Entity entity = new Entity();
		entity.setId(1);
		entity.setName("Vlad");
		entity.setEntityType(entityType);
		Assertions.assertEquals(entity, entityRepository.getEntityById(1));

		//Assertions.assertNull(null);
	}
	@Test
	void getProcessorsConnectWithMotherboard(){
		EntityType entityType = new EntityType();
		entityType.setId(3);
		entityType.setName("Процессор");
		Entity entity = new Entity();
		entity.setId(3);
		entity.setName("Ryzen 7 1700");
		entity.setEntityType(entityType);

		EntityType entityType2 = new EntityType();
		entityType2.setId(3);
		entityType2.setName("Процессор");
		Entity entity2 = new Entity();
		entity2.setId(4);
		entity2.setName("Ryzen 5 3600");
		entity2.setEntityType(entityType2);

		List<Entity> entityList = new ArrayList<>();
		entityList.add(entity);
		entityList.add(entity2);

		EntityType entityType3 = new EntityType();
		entityType3.setId(2);
		entityType3.setName("Материнская плата");
		Entity entity3 = new Entity();
		entity3.setId(2);
		entity3.setName("GIGABYTE X570 GAMING X");
		entity3.setEntityType(entityType3);

		Assertions.assertEquals(entityList, entityRepository.getProcessorsConnectWithMotherboard(entity3));
	}


}
