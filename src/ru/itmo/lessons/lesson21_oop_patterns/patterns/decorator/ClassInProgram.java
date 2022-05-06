package ru.itmo.lessons.lesson21_oop_patterns.patterns.decorator;

public class ClassInProgram {
    private ILog strategy;

    public ClassInProgram(ILog strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ILog strategy) {
        this.strategy = strategy;
    }

    public void action(){
        strategy.log("Логирование действия");
    }
}