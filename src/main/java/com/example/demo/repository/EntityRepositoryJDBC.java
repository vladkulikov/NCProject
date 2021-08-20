package com.example.demo.repository;

import com.example.demo.mapper.AttributeRowMapper;
import com.example.demo.mapper.EntityRowMapper;
import com.example.demo.mapper.ValueRowMapper;
import com.example.demo.model.Attribute;
import com.example.demo.model.Entity;
import com.example.demo.model.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityRepositoryJDBC  implements EntityRepository{

    private final JdbcTemplate jdbcTemplate;

    public EntityRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Entity getEntityById(long id) {
        String query = "select entity.entity_id,entity.entity_name,entity.entity_type_id,entity_type.entity_type_name from entity inner JOIN entity_type ON entity.entity_type_id = entity_type.entity_type_id and entity.entity_type_id = ? ";
        return jdbcTemplate.queryForObject(
                query, new Object[] { id }, new EntityRowMapper());
    }

    @Override
    public List<Entity> getProcessorsConnectWithMotherboard(Entity entity) {

        String s = """
                select t1.entity_id, t1.entity_name, t1.entity_type_id, t3.entity_type_name from entity as t1 inner JOIN value as t2  on (t1.entity_id = t2.entity_id and  t2.value = ?)
                inner JOIN entity_type as t3 on (t3.entity_type_name = 'Процессор' And t1.entity_type_id = t3.entity_type_id)
                """;


        String query = "select * from attribute where attribute_name = 'Сокет материнской платы'"; //ищем аттрибут материнки сокет
        Attribute attribute = jdbcTemplate.queryForObject(
                query, new AttributeRowMapper());

        String query2 = "select * from value where entity_id = ? and attribute_id = ?"; //получаем сокет материнки
        assert attribute != null;
        Value value = jdbcTemplate.queryForObject(
                query2, new Object[] { entity.getId(), attribute.getAttributeId() }, new ValueRowMapper());

        assert value != null;
        return jdbcTemplate.query(
                s, new Object[] { value.getValue() }, new EntityRowMapper());
    }


}
