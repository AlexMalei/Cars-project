package dev5.malei.carrent.services.filters;

import dev5.malei.carrent.entities.Car;

import java.util.List;

public interface CarFilter {
    List<Car> filter(List<Car> cars);
}
