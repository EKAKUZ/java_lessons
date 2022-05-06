package ru.itmo.lessons.lesson21_oop_patterns.patterns.decorator;

public abstract class BaseDecorator implements ILog {
    private ILog logger;

    public BaseDecorator(ILog logger) {
        this.logger = logger;
    }

    @Override
    public void log(String data) {
        logger.log(data);
    }
}