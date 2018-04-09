package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.Car;

import java.util.List;

public interface CarDAO extends CrudDAO<Car> {
    List<Car> getUnrentedCars();
}
