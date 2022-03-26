package ru.itmo.lessons.lesson6.HomeWork6_3.animals;

public class Mouse {
    private int speed;

    public Mouse(int speed) {
        this.speed = speed;
    }

    public void setSpeed (int speed) {
        if (speed < 0 ) throw new IllegalArgumentException ("Скорость мыши должна быть больше нуля");
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }
}
