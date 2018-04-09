package dev5.malei.carrent.dao;

import dev5.malei.carrent.entities.Rating;

import java.util.List;

public interface RatingDAO extends CrudDAO<Rating> {
    List<Rating> getRatingByUser(int userId);

    List<Rating> getRatingByCar(int carId);
}
