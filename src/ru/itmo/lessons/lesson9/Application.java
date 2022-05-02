package ru.itmo.lessons.lesson9;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(23, -12);
        Point b = new Point(23, -12);

        System.out.println(a); //println сам вызывает .toString
        System.out.println(b);

        // сравнение ссылок
        System.out.println(a == b); //false

        System.out.println(a.equals(b)); //наследуется из класса Object, по умолчанию сравнивает ссылки, получим false
        // переопределили, теперь сравниваем именно значение - возвращает true

        //клонирование метода clone
        //у метода модификатор protected - метод нужно переопределить
        Point aClone = a.clone();
        System.out.println(aClone == a); //false
        System.out.println(a.equals(aClone)); //true

        Point c = new Point(12, 33);
        Point d = new Point(45, 11);
        Point f = new Point(-8, -9);

        Figure fig1 = new Figure(3);
        fig1.addPoint(a);
        fig1.addPoint(b);
        fig1.addPoint(c);
        fig1.addPoint(d);
        fig1.addPoint(f);

        Figure fig2 = fig1.clone();

        System.out.println(fig1);
        System.out.println(fig2);
        System.out.println(Arrays.equals(fig1.getPoints(),fig2.getPoints()));
    }
}
