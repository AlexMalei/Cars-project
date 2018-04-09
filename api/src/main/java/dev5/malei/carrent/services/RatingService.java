package dev5.malei.carrent.services;

import dev5.malei.carrent.entities.Rating;
import java.util.List;

public interface RatingService extends CrudService<Rating> {
    List<Rating> getRatingByUser(int userId);
    List<Rating> getRatingByCar(int carId);
}
