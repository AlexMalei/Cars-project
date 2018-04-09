package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ReleaseYearFilter extends IntegerCarFilter {

    public ReleaseYearFilter(Integer from, Integer to) {
        super(from, to);
    }

    @Override
    public List<Car> filter(List<Car> cars) {
        return cars.
                stream().
                filter((car) -> from == null || car.getReleaseYear() >= from).
                filter((car) -> to == null || car.getReleaseYear() <= to).
                collect(Collectors.toList());
    }
}
