package dev5.malei.carrent.filters;

import dev5.malei.carrent.entities.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RentCostFilter extends IntegerCarFilter {

    public RentCostFilter(Integer from, Integer to) {
        super(from, to);
    }

    public List<Car> filter(List<Car> cars) {
        return cars.
                stream().
                filter((car) -> from == null || car.getRentCost() >= from).
                filter((car) -> to == null || car.getRentCost() <= to).
                collect(Collectors.toList());
    }
}
