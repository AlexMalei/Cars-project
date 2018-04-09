package dev5.malei.carrent.entities;

public class Rating extends BaseEntity {
    private int countStars;
    private int userId;
    private int carId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountStars() {
        return countStars;
    }

    public void setCountStars(int countStars) {
        this.countStars = countStars;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
