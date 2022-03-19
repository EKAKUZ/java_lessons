package Lesson2;

public class SecondHomeWork {

    public static void main(String[] args) {

        System.out.println ("Домашнее задание №2");

        System.out.println ("Пример 1. Задача на if");
        int count = 55;
        if (count >= 0 && count < 40) System.out.println("Попробуйте в следующий раз");
        else if (count > 39 && count < 60 ) System.out.println("Удовлетворительно");
        else if (count > 59 && count < 90 ) System.out.println("Хорошо");
        else if (count > 89 && count <= 100 ) System.out.println("Отлично");
        else System.out.println("Ошибка");

        System.out.println ("Пример 2. Задача на switch");
        int oper1 = 77, oper2 = 0, oper = 9;
        switch (oper) {
            case 3:
                System.out.println("Сумма: " + (oper1 + oper2));
                break;
            case 5:
                System.out.println("Разность: " + (oper1 - oper2));
                break;
            case 7:
                System.out.println("Умножение: " + oper1 * oper2);
                break;
            case 9:
                if (oper2 != 0) {
                    System.out.println("Деление: " + (double) oper1 / oper2);
                } else  System.out.println("Ошибка деления на 0");
                break;
            default:
                System.out.println("Операций не производилось");
                break;
        }

        System.out.println ("Пример 3.");
        int rand1;
        rand1 = (int) (Math.random() * 476 + 25);
        if (rand1 >= 25 && rand1 <= 200) System.out.println("Число " + rand1 + " содержится в интервале (25;200)");
        else System.out.println("Число " + rand1 + " не содержится в интервале (25;200)");

        int age = 20, exp = 5;
        if (age > 100 ) System.out.println("Мы Вам перезвоним");
        else if (exp < 5) System.out.println("Вы подходите на должность стажера");
        else  System.out.println("Вы подходите на должность разработчика");


    }



}
