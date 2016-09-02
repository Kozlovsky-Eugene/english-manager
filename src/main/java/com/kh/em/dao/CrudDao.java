package com.kh.em.dao;

public interface CrudDao<ENTITY, ID> {

    ENTITY add(ENTITY entity);

    ENTITY get(ID ID);

    ENTITY update(ENTITY entity);

    void remove(ID ID);

}
