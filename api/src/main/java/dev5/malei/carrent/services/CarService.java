package dev5.malei.carrent.services;


import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.services.filters.CarFilter;

import java.util.List;

public interface CarService extends CrudService<Car>{
    List<Car> getUnrentedCars();

    List<Car> filter(List<CarFilter> carFilters);
}
