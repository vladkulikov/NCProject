package com.example.demo.mapper;

import com.example.demo.model.Attribute;
import com.example.demo.model.Entity;
import com.example.demo.repository.AttributeRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttributeRowMapper implements RowMapper<Attribute> {
    @Override
    public Attribute mapRow(ResultSet resultSet, int i) throws SQLException {
        Attribute attribute = new Attribute();
        attribute.setAttributeId(resultSet.getLong("attribute_id"));
        attribute.setName(resultSet.getString("attribute_name"));
        attribute.setType(resultSet.getInt("attribute_type"));
        attribute.setMultiply(resultSet.getBoolean("attribute_multiply"));
        return attribute;
    }
}
