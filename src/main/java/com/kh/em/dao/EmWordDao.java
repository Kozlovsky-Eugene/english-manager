package com.kh.em.dao;

import com.kh.em.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmWordDao implements WordDao {

    private static final String SELECT_BY_VALUE = "select * from Word where id=:id";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Word add(Word word) {
        Assert.notNull(word, "Word can't be null");
        return null;
    }

    @Override
    public Word get(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject(SELECT_BY_VALUE, params, (resultSet, i) -> {
            Word word = new Word();
            word.setValue(resultSet.getString("value"));
            word.setLanguage(String.valueOf(resultSet.getInt("language")));
            return word;
        });
    }

    @Override
    public Word update(Word word) {
        throw new IllegalArgumentException("Word with value ");
    }

    @Override
    public void remove(Integer ID) {

    }
}
