package ru.itmo.lessons.lesson6.HomeWork6_3;

import ru.itmo.lessons.lesson6.HomeWork6_3.animals.Mouse;
import ru.itmo.lessons.lesson6.HomeWork6_3.animals.Cat;

public class Application {
    public static void main(String[] args) {

        Mouse[] mouses = new Mouse[4];
        mouses[0]= new Mouse(10);
        mouses[1]= new Mouse(20);
        mouses[2]= new Mouse(30);
        mouses[3]= new Mouse(40);

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 20, 6);
        cats[1] = new Cat("Рыжик", 30, 5);
        cats[2] = new Cat("Казимир", 40, 3);
        cats[3] = new Cat("Кис-кис", 50, 4);

        for (int i = 0; i < cats.length; i ++ ) {
            for (Mouse mouse: mouses) {
                if (cats[i] == null) {
                    System.out.println("Обьект кот не заполнен");
                    break;
                }
                if (mouse == null) {
                    System.out.println("Обьект мышь не заполнен");
                } else cats[i].catchMouse(mouse, cats);
            }
        }
        System.out.println(".........");
        for (int i = cats.length - 1; i >= 0; i -- ) {
            for (Cat cat: cats) {
                cats[i].attackCat(cat);
            }
        }

        System.out.println(".........");
        for (Cat cat: cats) {
            System.out.println(cat.cetchedMouse());
        }

    }
}
