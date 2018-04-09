package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.BodyType;
import dev5.malei.carrent.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class BodyTypeFilter extends EnumFilter {
    public BodyTypeFilter(Enum enumeration) {
        super(enumeration);
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        return cars.
                stream().
                filter((car -> car.getBodyType().equals(enumeration))).
                collect(Collectors.toList());
    }
}
