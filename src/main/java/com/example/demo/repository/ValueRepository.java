package com.example.demo.repository;

import com.example.demo.model.Entity;
import com.example.demo.model.Value;

import java.util.List;


public interface ValueRepository{
    List<Value> getValueByEntity(Entity entity);
}
