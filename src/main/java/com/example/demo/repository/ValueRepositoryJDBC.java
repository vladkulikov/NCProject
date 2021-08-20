package com.example.demo.repository;

import com.example.demo.mapper.EntityRowMapper;
import com.example.demo.mapper.ValueRowMapper;
import com.example.demo.model.Entity;
import com.example.demo.model.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ValueRepositoryJDBC implements ValueRepository{
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Value> getValueByEntity(Entity entity) {

        String query = "select * from value where entity_id = ?";
        return jdbcTemplate.query(
                query, new Object[] { entity.getId() }, new ValueRowMapper());
    }
}
