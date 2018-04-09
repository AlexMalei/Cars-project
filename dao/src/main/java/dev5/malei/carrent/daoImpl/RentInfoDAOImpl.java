package dev5.malei.carrent.daoImpl;


import dev5.malei.carrent.dao.RentInfoDAO;
import dev5.malei.carrent.entities.RentInfo;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RentInfoDAOImpl extends CrudDAOImpl<RentInfo> implements RentInfoDAO {
    public RentInfoDAOImpl() {
        super(RentInfo.class);
    }

    @Override
    public List<RentInfo> getRentInfoByCarId(int carId) {
        List<RentInfo> rentInfoList = list();
        return rentInfoList.
                stream().
                filter((element) -> element.getCarId() == carId).
                collect(Collectors.toList());
    }

    @Override
    public List<RentInfo> getRentInfoByUserId(int userId) {
        List<RentInfo> rentInfoList = list();
        return rentInfoList.
                stream().
                filter((element) -> element.getUserId() == userId).
                collect(Collectors.toList());
    }

    @Override
    public List<RentInfo> getUnconfirmedRentInfo() {
        List<RentInfo> rentInfoList = list();
        return rentInfoList.
                stream().
                filter((element) -> !element.isConfirmed()).
                collect(Collectors.toList());
    }

    @Override
    public Date getEndRentDate(int carId) {
        List<RentInfo> carRentInfoList = getRentInfoByCarId(carId);
        if (!carRentInfoList.isEmpty()){
            carRentInfoList.sort((rentInfo1, rentInfo2) -> rentInfo1.getDateTo().after(rentInfo2.getDateTo()) ? 1 : -1 );
            return carRentInfoList.get(carRentInfoList.size() - 1).getDateTo();
        } else {
            return null;
        }
    }

}
