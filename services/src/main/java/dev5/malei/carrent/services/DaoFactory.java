package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.CrudDAO;
import dev5.malei.carrent.daoImpl.*;
import java.util.HashMap;
import java.util.Map;


public class DaoFactory {
    private static Map<Class, CrudDAO> daoMap;

    static {
        daoMap = new HashMap<Class, CrudDAO>();
        daoMap.put(CarServiceImpl.class, new CarDAOImpl());
        daoMap.put(CommentServiceImpl.class, new CommentDAOImpl());
        daoMap.put(RatingServiceImpl.class, new RatingDAOImpl());
        daoMap.put(RentInfoServiceImpl.class, new RentInfoDAOImpl());
        daoMap.put(UserServiceImpl.class, new UserDAOImpl());
        daoMap.put(AuthServiceImpl.class, new UserDAOImpl());
        daoMap.put(PaymentServiceImpl.class, new PaymentDAOImpl());
        daoMap.put(BlockDetailsServiceImpl.class, new BlockDetailsDAOImpl());
    }

    public static CrudDAO getDao(Class serviceClass){
        return daoMap.get(serviceClass);
    }
}
