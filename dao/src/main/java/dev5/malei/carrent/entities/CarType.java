package dev5.malei.carrent.entities;

public enum CarType {
    PASSENGER("PASSENGER"),
    FREIGHT("FREIGHT");

    private final String name;

    CarType(String s) {
        name = s;
    }

}
