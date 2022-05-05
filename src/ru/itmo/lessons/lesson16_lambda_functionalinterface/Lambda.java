package ru.itmo.lessons.lesson16_lambda_functionalinterface;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    private static void run(Operation operation, double x, double y) {
        double res = operation.execute(x,y);
        System.out.println("Результат: " + res);
    }
    public static void main(String[] args) {
        // описание реализаций интерфейсного метода
        Operation plus = (first, second) -> /* return - поумолчанию, так как одна инструкция*/first + second;
        Operation div = (first, second) -> {
            if (second==0) return 0;
            return first/second;
        };
        // Operation -  имя интерфейса (plus, div - обьекты класса)
        // (first, second) - аргументы метода
        // после -> инструкции внутри функционального метода

        //круглые скобки можно не ставить если у метода интерфейса один аргумент
        //тип данных и возвращаемого значения не указываем,так функциональный абстрактный
        // метод содержит только 1 метод, и может определить тип переменных
        // если тело метода состоит из одной инструкции {} можно не ставить,
        // иначе они обязательны
        // TODO: ,,
        //  FFF
        // FIXME: ,,,,
        //  FFFF


        System.out.println(plus.execute(34,78));
        System.out.println(div.execute(34,3));
        run(plus, 45,56);
        run(div, 45,56);

        // функциональный интерфейс джейнерик определенный в языке
        //Predicate

        Predicate<Integer> isPos = one -> one > 0;
        Predicate<Integer> isNeg =  one -> one < 0;
        Predicate<Integer> isEven = one -> (one % 2) == 0;

        System.out.println(isPos.test(-78));
        System.out.println(isNeg.test(-78));
        System.out.println(isEven.test(-78));
        System.out.println(isPos.and(isNeg).and(isEven).test(68));
        System.out.println(isPos.or(isNeg).or(isEven).test(68));
        // .and .or .negate - дефолтные методы Predicate .test - функциональный метод Predicate

        Function<Integer,Double> minus20 = one -> one * 0.8;
        Function<Integer,Integer> doubled = one -> one * 2;
        Function<Integer,String> toStr = one -> {
            if (one < 0) one *= (-1);
            return one + "p.";
        };
        System.out.println(doubled.andThen(toStr).apply(45));



    }
}
