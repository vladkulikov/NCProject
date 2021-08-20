package com.example.demo.repository;

import com.example.demo.model.Entity;

import java.util.List;


public interface EntityRepository{
    Entity getEntityById(long id);
    List<Entity>  getProcessorsConnectWithMotherboard(Entity entity);
}