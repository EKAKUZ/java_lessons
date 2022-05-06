package ru.itmo.lessons.lesson21_oop_patterns.patterns.singleton;

public class Application {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();
        // ссылки на один и тот же обьект
    }

}