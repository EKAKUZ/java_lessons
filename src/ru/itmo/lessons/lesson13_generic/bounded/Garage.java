package ru.itmo.lessons.lesson13_generic.bounded;

public class Garage <T extends Vehicle & Repair, K extends Vehicle> {
    // тип класса относится и к классу Vehicle
    // и к Интерфейсу Repair
    private  T vehicle;
    private  K vehicle2;

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle() {
        return vehicle;
    }
}