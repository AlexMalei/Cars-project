package dev5.malei.carrent.daoImpl;
import dev5.malei.carrent.dao.CrudDAO;
import dev5.malei.carrent.entities.BaseEntity;

import java.io.*;
import java.util.*;

public class CrudDAOImpl<E extends BaseEntity> implements CrudDAO<E> {

    private Class<E> metaclass;

    public CrudDAOImpl(Class<E> metaclass) {
        this.metaclass = metaclass;
        if (classEntityMap.get(metaclass) == null) {
            classEntityMap.put(metaclass, new HashMap<Integer, E>());
        }
    }

    public E get(int id) {
        Map<Integer, E> entityMap = getEntityMap();
        return entityMap.get(id);
    }


    public E add(E entity) {
        Map entityMap = getEntityMap();
        if (!entityMap.isEmpty()) {
            int lastId = getEntitiesLastId(entityMap);
            entity.setId(lastId + 1);
            entityMap.put(lastId + 1, entity);
        } else {
            entity.setId(1);
            entityMap.put(1, entity);
        }
        return entity;
    }

    public E update(E entity) {
        Map entityMap = getEntityMap();
        entityMap.put(entity.getId(), entity);
        return entity;
    }

    public void delete(int id) {
        Map entityMap = getEntityMap();
        entityMap.remove(id);
    }

    public List<E> list() {
        Map entityMap = getEntityMap();
        return new ArrayList(entityMap.values());
    }

    public static void serializeEntities(String pathToFile) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(pathToFile))) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(classEntityMap);
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserializeEntities(String pathToDBFile) {
        Map entityMapDeserialized = null;
        try (FileInputStream fileInputStream = new FileInputStream(new File(pathToDBFile))) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                entityMapDeserialized = (Map)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        putValuesToMap(entityMapDeserialized);
    }

    private static void putValuesToMap(Map entityMapDeserialized) {
        classEntityMap.putAll(entityMapDeserialized);
    }

    private int getEntitiesLastId(Map<Integer, E> entityMap) {
        List<Integer> keys = new ArrayList<Integer>(entityMap.keySet());
        Collections.sort(keys);
        int lastId = keys.get(keys.size() - 1);
        return lastId;
    }

    private Map getEntityMap() {
        Map entityMap = CrudDAO.classEntityMap.get(metaclass);
        return entityMap;
    }



}