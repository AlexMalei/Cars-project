package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.entities.CarType;

import java.util.List;
import java.util.stream.Collectors;

public class CarTypeFilter extends EnumFilter {

    public CarTypeFilter(Enum enumeration) {
        super(enumeration);
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        return cars.
                stream().
                filter((car -> car.getCarType().equals(enumeration))).
                collect(Collectors.toList());

    }
}
