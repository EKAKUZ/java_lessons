package ru.itmo.lessons.lesson11_enums_datetime;

public class App {
    public static void main(String[] args) {
        //Util util1 = new Util();
        //Util util2= new Util(); - бессмысленное создание обьектов, ничего не делают в программе,
        // после создания приватного конструктора не доступны

        //util1.max = 1200 - некорректное обращение
        //System.out.println(util2.max); - некорректное обращение

        Util.min = 100;
        System.out.println(Util.min);
    }
}
