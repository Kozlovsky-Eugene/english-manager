package com.kh.em.dao;

import com.kh.em.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class EmWordDao implements WordDao {

    private static final String INSERT_WORD = "insert into Word (value, language) values(:value, :language)";
    private static final String UPDATE_WORD = "update Word set value=:value, language=:language where id=:id";
    private static final String REMOVE_WORD = "delete from Word where id=:id";
    private static final String SELECT_BY_VALUE = "select * from Word where id=:id";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Word add(Word word) {
        Assert.notNull(word, "Word can't be null");
        SqlParameterSource params = new BeanPropertySqlParameterSource(word);
        return Optional
                .ofNullable(jdbcTemplate.queryForObject(INSERT_WORD, params, Word.class))
                .get();
    }

    @Override
    public Word get(Integer id) {
        SqlParameterSource params = new MapSqlParameterSource("id", id);
        return Optional
                .ofNullable(jdbcTemplate.queryForObject(SELECT_BY_VALUE, params, Word.class))
                .get();
    }

    @Override
    public Word update(Word word) {
        Assert.notNull(word, "Word can't be null");
        SqlParameterSource params = new BeanPropertySqlParameterSource(word);
        return Optional
                .ofNullable(jdbcTemplate.queryForObject(UPDATE_WORD, params, Word.class))
                .get();
    }

    @Override
    public void remove(Integer id) {
        SqlParameterSource params = new MapSqlParameterSource("id", id);
        Optional
                .ofNullable(jdbcTemplate.update(REMOVE_WORD, params))
                .ifPresent((value) -> {
                    if (value == 0) {
                        throw new NoSuchElementException("Word wasn't find with id \'" + id + "\'");
                    }
                });

    }
}
