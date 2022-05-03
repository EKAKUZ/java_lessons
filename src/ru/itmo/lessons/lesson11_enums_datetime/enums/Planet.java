package ru.itmo.lessons.lesson11_enums_datetime.enums;

public enum Planet {
    ZEMLYA("Земля", 6371.0,  5972.0), MARS("Марс", 3376.0, 641.0), VENERA("Венера", 6051.8, 4870.0);

    private double radius;
    private double weight;
    private String name;

    Planet (String name, double radius, double weight) {
        this.name = name;
        setRadius(radius);
        setWeight(weight);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
