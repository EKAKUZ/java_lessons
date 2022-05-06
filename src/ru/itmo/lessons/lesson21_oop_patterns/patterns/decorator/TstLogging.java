package ru.itmo.lessons.lesson21_oop_patterns.patterns.decorator;

public class TstLogging {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogging());
        inProgram.action();

        inProgram.setStrategy(new FileLogging());
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new CodeDecorator(new ConsoleLogging())));
        inProgram.action();



        ILog logger = new FileLogging();
        ILog dateDecorator = new DateDecorator(logger);

        dateDecorator.log("данные");


    }
}