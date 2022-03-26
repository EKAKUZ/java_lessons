package ru.itmo.lessons.lesson7.HomeWork7_1.base;

public abstract class Unit {
    protected String name;
    protected int age;

    public Unit(String name, int age) {
        if (name == null || name.length() < 2) throw new IllegalArgumentException("Введено некорректное имя");
        if (age < 1) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
        this.name = name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2) throw new IllegalArgumentException("Введено некорректное имя");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
    }

}
