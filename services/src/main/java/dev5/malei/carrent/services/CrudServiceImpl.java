package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.CrudDAO;
import dev5.malei.carrent.entities.BaseEntity;

import java.util.List;

public class CrudServiceImpl<E extends BaseEntity> implements CrudService<E> {

    private CrudDAO<E> crudDAO;
    public CrudServiceImpl(){
        crudDAO = DaoFactory.getDao(this.getClass());
    }
    public E get(int id) {
        return crudDAO.get(id);
    }

    public E add(E entity) {
        return crudDAO.add(entity);
    }

    public E update(E entity) {
        return crudDAO.update(entity);
    }

    public void delete(int id) {
        crudDAO.delete(id);
    }

    public List<E> list() {
        return crudDAO.list();
    }
}
