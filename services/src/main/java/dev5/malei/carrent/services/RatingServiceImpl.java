package dev5.malei.carrent.services;

import dev5.malei.carrent.dao.RatingDAO;
import dev5.malei.carrent.daoImpl.RatingDAOImpl;
import dev5.malei.carrent.entities.Rating;

import java.util.List;

public class RatingServiceImpl extends CrudServiceImpl<Rating> implements RatingService {
    private RatingDAO ratingDAO = (RatingDAOImpl) DaoFactory.getDao(RatingServiceImpl.class);

    public List<Rating> getRatingByUser(int userId) {
        return ratingDAO.getRatingByUser(userId);
    }

    public List<Rating> getRatingByCar(int carId) {
        return ratingDAO.getRatingByCar(carId);
    }
}
