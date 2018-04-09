package dev5.malei.carrent.daoImpl;

import dev5.malei.carrent.dao.CarDAO;

import dev5.malei.carrent.dao.RentInfoDAO;
import dev5.malei.carrent.entities.*;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CarDAOImpl extends CrudDAOImpl<Car> implements CarDAO {
    public CarDAOImpl() {
        super(Car.class);
    }

    @Override
    public List<Car> getUnrentedCars() {
        RentInfoDAO rentInfoDAO = new RentInfoDAOImpl();
        List<RentInfo> rentInfoList = rentInfoDAO.list();
        Set<Integer> rentedCarsIdSet = rentInfoList.
                stream().
                filter(rentInfo -> rentInfo.getDateTo().after(new Date())).
                map(RentInfo::getCarId).
                collect(Collectors.toSet());

        List<Car> allCars = list();
        List<Car> unrentedCars = allCars.
                stream().
                filter((car -> !rentedCarsIdSet.contains(car.getId()))).
                collect(Collectors.toList());
        return unrentedCars;
    }
}
