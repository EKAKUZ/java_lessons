package ru.itmo.lessons.lesson6.HomeWork6_2.Foods;

import java.util.Arrays;

public class MyFoods {
    private Food[] foods;
    private double maxProtein = 40;
    private double maxCarb = 40;
    private double maxFats = 40;
    private double maxKal = 500;

    public MyFoods(){}

    public void countFood (int count) {
        foods = new Food[count];
    }

    public void addFood(Food food) {
        if (food == null) throw new IllegalArgumentException ("Невозможно добавить обьект null");
        if (food.getCarb() > maxCarb) {
            System.out.println("Невозможно добавить продукт в список, количество углеводов выше " + getMaxCarb());
            return;
        }
        if (food.getFats() > maxFats) {
            System.out.println("Невозможно добавить продукт в список, количество жиров выше " + getMaxFats());
            return;
        }
        if (food.getProtein() > maxProtein) {
            System.out.println("Невозможно добавить продукт в список, количество жиров выше " + getMaxProtein());
            return;
        }
        if (food.getKal() > maxKal) {
            System.out.println("Невозможно добавить продукт в список, количество ккал выше " + getMaxKal());
            return;
        }

        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null) {
                foods[i] = new Food(food.getName(), food.getProtein(), food.getCarb(), food.getFats(), food.getKal());
                return;
            }
        }
        System.out.println("Список продуктов заполнен");

    }
    public String printallFoodName() {
        StringBuilder sb = new StringBuilder();
        for (Food food: foods)
        if ( food != null ) sb = sb.append(" ").append(food.getName());
        return sb.toString();
    }

    public void setMaxProtein(double maxProtein) {
        if (maxProtein <= 0) throw new IllegalArgumentException ("Количество белка в продукте  не может быть меньше  0");
        this.maxProtein = maxProtein;
    }

    public void setMaxCarb(double maxCarb) {
        if (maxCarb <= 0) throw new IllegalArgumentException ("Количество углеводов в продукте  не может быть меньше  0");
        this.maxCarb = maxCarb;
    }

    public void setMaxFats(double maxFats) {
        if (maxFats <= 0) throw new IllegalArgumentException ("Количество жиров в продукте  не может быть меньше  0");
        this.maxFats = maxFats;
    }

    public void setMaxKal(double maxKal) {
        if (maxKal <= 0) throw new IllegalArgumentException ("Количество ккал в продукте  не может быть меньше  0");
        this.maxKal = maxKal;
    }

    public double getMaxProtein() {
        return maxProtein;
    }

    public double getMaxCarb() {
        return maxCarb;
    }

    public double getMaxFats() {
        return maxFats;
    }

    public double getMaxKal() {
        return maxKal;
    }
}
