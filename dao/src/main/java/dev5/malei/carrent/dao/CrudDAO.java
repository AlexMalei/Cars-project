package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CrudDAO<E extends BaseEntity> {
    Map<Class< ? extends BaseEntity >, Map<Integer, ? extends BaseEntity>> classEntityMap = new HashMap<>();
    E get(int id);
    E add(E entity);
    E update(E entity);
    void delete(int id);
    List<E> list();


}
