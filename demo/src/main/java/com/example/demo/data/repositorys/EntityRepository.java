package com.example.demo.data.repositorys;


import com.example.demo.data.entitys.Entity;

public interface EntityRepository {
    Entity getEntityById(long id);
}
