package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.CarDAO;
import dev5.malei.carrent.daoImpl.CarDAOImpl;
import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.services.filters.CarFilter;

import java.util.List;

public class CarServiceImpl extends CrudServiceImpl<Car> implements CarService {
    private CarDAO carDAO = (CarDAOImpl) DaoFactory.getDao(getClass());

    public List<Car> getUnrentedCars() {

        return carDAO.getUnrentedCars();
    }

    public List<Car> filter(List<CarFilter> filters) {
        List<Car> cars = list();
        for (CarFilter carFilter : filters) {
            cars = carFilter.filter(cars);
        }
        return cars;
    }

}
