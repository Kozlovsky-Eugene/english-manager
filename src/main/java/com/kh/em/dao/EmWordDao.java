package com.kh.em.dao;

import com.kh.em.entity.Word;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class EmWordDao implements WordDao {

    private Map<String, Word> values;

    public EmWordDao() {
        values = new HashMap<>();
    }

    @Override
    public Word add(Word word) {
        Assert.notNull(word, "Word can't be null");
        return values.put(word.getValue(), word);
    }

    @Override
    public Word get(String id) {
        return values.get(id);
    }

    @Override
    public Word update(Word word) {
        if (values.containsKey(word.getValue())) {
            values.remove(word.getValue());
            values.put(word.getValue(), word);
        }//todo something
        throw new IllegalArgumentException("Word with value ");
    }

    @Override
    public void remove(String ID) {

    }
}
