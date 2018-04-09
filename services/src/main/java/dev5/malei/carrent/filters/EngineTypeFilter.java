package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.entities.EngineType;

import java.util.List;
import java.util.stream.Collectors;

public class EngineTypeFilter extends EnumFilter {
    public EngineTypeFilter(Enum enumeration) {
        super( enumeration );
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        return cars.
                stream().
                filter((car -> car.getEngineType().equals(enumeration))).
                collect(Collectors.toList());
    }
}
