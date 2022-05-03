package ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1;

import ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1.base.Unit;

public class Director extends Unit{
    public Director (String name, int age) {
        super(name, age);
        if (age < 35) throw new IllegalArgumentException("Не подходит в директора по возрасту");
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void lessonStart() {
        System.out.println("Начался учебный день");
    }
    public void lessonStop() {
        System.out.println("Учебный день закончился");
    }

}
