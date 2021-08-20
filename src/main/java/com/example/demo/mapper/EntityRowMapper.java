package com.example.demo.mapper;

import com.example.demo.model.Entity;
import com.example.demo.model.EntityType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityRowMapper implements RowMapper<Entity> {
    @Override
    public Entity mapRow(ResultSet resultSet, int i) throws SQLException {
        Entity entity = new Entity();
        EntityType entityType = new EntityType();
        entityType.setId(resultSet.getLong("entity_type_id"));
        entityType.setName(resultSet.getString("entity_type_name"));
        entity.setName(resultSet.getString("entity_name"));
        entity.setId(resultSet.getLong("entity_id"));
        entity.setEntityType(entityType);
        return entity;
    }
}
