package com.kh.em.entity;

import java.util.List;

public class Word {

    private Long id;
    private String value;
    private String language;
    private List<Word> translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Word> getTranslation() {
        return translation;
    }

    public void setTranslation(List<Word> translation) {
        this.translation = translation;
    }
}
