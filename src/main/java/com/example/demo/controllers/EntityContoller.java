package com.example.demo.controllers;

import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/entity")
public class EntityContoller {
    @Autowired
    EntityRepositoryJDBC entityRepository;

    @GetMapping("/getEntityById/{id}")
    public Entity getEntityById(@PathVariable(value = "id") long entityId) {
        return entityRepository.getEntityById(entityId);
    }
}
