package dev5.malei.carrent.entities;

public enum BodyType {
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK"),
    CROSSOVER("CROSSOVER"),
    TRUCK("TRUCK");

    private final String name;

    BodyType(String s) {
        name = s;
    }


}
