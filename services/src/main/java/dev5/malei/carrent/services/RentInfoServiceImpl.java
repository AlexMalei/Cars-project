package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.RentInfoDAO;
import dev5.malei.carrent.daoImpl.RentInfoDAOImpl;
import dev5.malei.carrent.entities.RentInfo;

import java.util.Date;
import java.util.List;

public class RentInfoServiceImpl extends CrudServiceImpl<RentInfo> implements RentInfoService {
    private RentInfoDAO rentInfoDAO = (RentInfoDAOImpl) DaoFactory.getDao(RentInfoServiceImpl.class);

    public List<RentInfo> getRentInfoByCarId(int carId) {
        return rentInfoDAO.getRentInfoByCarId(carId);
    }

    public List<RentInfo> getRentInfoByUserId(int userId) {
        return rentInfoDAO.getRentInfoByUserId(userId);
    }

    public List<RentInfo> getUnconfirmedRentInfo() {
        return rentInfoDAO.getUnconfirmedRentInfo();
    }

    public Date getEndRentDate(int carId) {
        return rentInfoDAO.getEndRentDate(carId);
    }

    @Override
    public boolean isRentAvailable(int carId) {
        return getEndRentDate(carId) != null;
    }
}
