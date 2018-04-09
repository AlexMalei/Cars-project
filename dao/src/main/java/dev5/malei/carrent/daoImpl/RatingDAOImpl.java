package dev5.malei.carrent.daoImpl;

import dev5.malei.carrent.dao.RatingDAO;
import dev5.malei.carrent.entities.Rating;


import java.util.List;
import java.util.stream.Collectors;

public class RatingDAOImpl extends CrudDAOImpl<Rating> implements RatingDAO {
    public RatingDAOImpl() {
        super(Rating.class);
    }

    @Override
    public List<Rating> getRatingByUser(int userId) {
        List<Rating> ratings = list();
        List<Rating> userRatings = ratings.
                stream().
                filter((rating -> rating.getUserId() == userId)).
                collect(Collectors.toList());
        return userRatings;
    }

    @Override
    public List<Rating> getRatingByCar(int carId) {
        List<Rating> ratings = list();
        List<Rating> carRatings = ratings.
                stream().
                filter((rating -> rating.getUserId() == carId)).
                collect(Collectors.toList());
        return carRatings;
    }


}
