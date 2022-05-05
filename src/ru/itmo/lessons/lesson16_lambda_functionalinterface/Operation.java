package ru.itmo.lessons.lesson16_lambda_functionalinterface;


// если интерфейс содержит один абстрактный метод он назвается функциональным
@FunctionalInterface
public interface Operation {
    double execute(double a, double b);
}
// интерфейс маркер без методов
//public interface Operation2 {
//}
