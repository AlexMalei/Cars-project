package dev5.malei.carrent.entities;

import java.util.Date;

public class Payment extends BaseEntity {
    private int rentInfoId;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentInfoId() {
        return rentInfoId;
    }

    public void setRentInfoId(int rentInfoId) {
        this.rentInfoId = rentInfoId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
