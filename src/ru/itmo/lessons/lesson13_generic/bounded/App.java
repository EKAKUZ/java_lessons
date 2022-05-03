package ru.itmo.lessons.lesson13_generic.bounded;

public class App {
    public static void main(String[] args) {
        Train train = (Train) Vehicle.getVehicle("train");
        System.out.println(train.getCarCount());

        Car car = (Car) Vehicle.getVehicle("car");
        System.out.println(car.getNum());

        Bicycle bike = (Bicycle) Vehicle.getVehicle("bike");
        System.out.println(bike.getType());

        Garage<Car, Vehicle> garage1 = new Garage<>();
        //Garage<Vehicle> garage2 = new Garage<>();
    }
}