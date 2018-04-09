package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.Car;
import dev5.malei.carrent.entities.RentInfo;
import dev5.malei.carrent.entities.User;

import java.util.Date;
import java.util.List;

public interface RentInfoService extends CrudService<RentInfo>{
    List<RentInfo> getRentInfoByCarId(int id);
    List<RentInfo> getRentInfoByUserId(int id);
    List<RentInfo> getUnconfirmedRentInfo();
    Date getEndRentDate(int carId);
    boolean isRentAvailable(int carId);
}
