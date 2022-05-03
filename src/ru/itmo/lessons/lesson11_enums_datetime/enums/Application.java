package ru.itmo.lessons.lesson11_enums_datetime.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article1 = new Article("Путешествие по Австралии");
        Article article2 = new Article("Путешествие по Великобритании");
        Article article3 = new Article("Путешествие по Франции");

        article1.setCountry(Country.AUSTRALIA);
        System.out.println(article1.getCountry());

        article2.setCountry(Country.UK);
        System.out.println(article2.getCountry());

        //Мметоды перечислений
        // олучение массива констант
        Country[] countries = Country.values(); // вернет массив всех элементов перечисления
        System.out.println(Arrays.toString(countries));
        // [AUSTRALIA, UK, FRANCE] - всегда в таком порядке
        // индекс элемента перечисления в массиве
        System.out.println(Country.AUSTRALIA.ordinal()); //0

        for (Country country : countries) {
            System.out.println("country " + country.name()); // name это тип String
        }

        //IllegalArgumentException - если элемент не будет найден
        Country country = Country.valueOf("UK"); // ссылка на элемент перечисления
        System.out.println(country);

        Priority low1 = Priority.LOW;
        System.out.println(low1.getCode());

        low1.setCode(2);
        System.out.println(low1.getCode());



        for (Priority value : Priority.values()) {
            System.out.println("priority " + value.getCode()); // name это тип String
        }

        int sumRes = Operation.SUM.action(2,3);
        System.out.println(sumRes);

        int multiRes = Operation.MULTI.action(2,3);
        System.out.println(multiRes); // возможности полиморфизма

        for (Planet planet : Planet.values()) {
            System.out.println(planet.name() + ": " + planet.getName() + " радиус " + planet.getRadius() + " вес " + planet.getWeight()); // name это тип String
        }


        //по умолчанию name() и toString() возвращают одно значение, но
        // name переопределить нельзя (он final)
        // toString() переопределить можно

    }
}
