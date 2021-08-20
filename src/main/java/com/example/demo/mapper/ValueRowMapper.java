package com.example.demo.mapper;

import com.example.demo.model.Attribute;
import com.example.demo.model.Entity;
import com.example.demo.model.EntityType;
import com.example.demo.model.Value;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValueRowMapper implements RowMapper<Value> {
    @Override
    public Value mapRow(ResultSet resultSet, int i) throws SQLException {
        Value value = new Value();
/*        Entity entity = new Entity();
        EntityType entityType = new EntityType();
        Attribute attribute = new Attribute();
        entityType.setId(resultSet.getLong("entity_type_id"));
        entityType.setName(resultSet.getString("entity_type_name"));
        entity.setName(resultSet.getString("entity_name"));
        entity.setId(resultSet.getLong("entity_id"));
        entity.setEntityType(entityType);
        value.setValueId(resultSet.getLong("value_id"));
        value.setEntity(entity);
        value.setAttribute(attribute);*/

        value.setValue(resultSet.getString("value"));
        return value;
    }
}
