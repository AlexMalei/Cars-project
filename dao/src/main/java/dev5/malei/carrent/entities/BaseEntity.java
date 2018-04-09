package dev5.malei.carrent.entities;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable{
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
