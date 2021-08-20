package com.example.demo.model;

import lombok.Data;

@Data
public class Value {
    private long valueId;
    private Entity entity;
    private Attribute attribute;
    private String value;
    private Entity reference;
}
