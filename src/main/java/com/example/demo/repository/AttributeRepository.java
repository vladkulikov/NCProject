package com.example.demo.repository;

import com.example.demo.model.Attribute;

public interface AttributeRepository {
    Attribute getAttributeByName(String name);
}
