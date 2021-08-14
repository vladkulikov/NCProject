package com.example.demo.repositories;

import com.example.demo.entities.Entity;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository {
    Entity getEntityById(long id);
}
