package ru.itmo.lessons.lesson6.HomeWork6_2;

import ru.itmo.lessons.lesson6.HomeWork6_2.Foods.Food;
import ru.itmo.lessons.lesson6.HomeWork6_2.Foods.MyFoods;

public class Application {
    public static void main(String[] args) {
        Food[] prods = new Food[4];

        prods[0] = new Food();
        prods[0].setName("Мясо");
        prods[0].setProtein(50);
        prods[0].setKal(40);

        prods[1] = new Food("Хлеб");
        prods[1].setCarb(10);
        prods[1].setKal(90);

        prods[2]= new Food("Молоко", 130);
        prods[2].setCarb(10);
        prods[2].setFats(10);

        prods[3]= new Food("Конфеты", 10, 20, 30, 400);


        MyFoods myfoods = new MyFoods();
        myfoods.countFood(4);

        for (int i = 0; i < prods.length; i++) {
            myfoods.addFood(prods[i]);
        }
        System.out.println(myfoods.printallFoodName());

    }
}
