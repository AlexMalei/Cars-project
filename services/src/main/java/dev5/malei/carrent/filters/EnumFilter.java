package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.services.filters.CarFilter;

import java.util.List;

public abstract class EnumFilter implements CarFilter {

    protected Enum enumeration;

    public EnumFilter(Enum enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public abstract List<Car> filter(List<Car> cars);
}
