package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.services.filters.CarFilter;

import java.util.List;

public abstract class IntegerCarFilter implements CarFilter {
    protected Integer from ;
    protected Integer to;

    public IntegerCarFilter(Integer from, Integer to) {
        this.from = from;
        this.to = to;
    }

    public abstract List<Car> filter(List<Car> cars);
}
