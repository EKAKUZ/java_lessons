package ru.itmo.lessons.lesson21_oop_patterns.patterns.decorator;

public class ConsoleLogging implements ILog {
    @Override
    public void log(String data) {
        System.out.println(data);
    }
}