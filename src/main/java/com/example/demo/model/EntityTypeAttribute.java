package com.example.demo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EntityTypeAttribute {
    private EntityType entityType;
    private List<Attribute> attributeList = new ArrayList<>();
}
