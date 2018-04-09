package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.BaseEntity;

import java.util.List;


public interface CrudService<E extends BaseEntity> {
    E get(int id);
    E add(E entity);
    E update(E entity);
    void delete(int id);
    List<E> list();


}
