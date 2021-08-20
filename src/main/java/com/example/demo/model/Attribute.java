package com.example.demo.model;

import lombok.Data;

@Data
public class Attribute {
    private long attributeId;
    private String name;
    private int type;
    private boolean multiply;
}
