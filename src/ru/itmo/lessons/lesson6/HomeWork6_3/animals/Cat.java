package ru.itmo.lessons.lesson6.HomeWork6_3.animals;

import ru.itmo.lessons.lesson6.HomeWork6_1.climbing.Climber;

public class Cat {
    private String name;
    private int speed;
    private int weight;
    private Mouse[] mouses = new Mouse[100];

    public Cat (String name, int speed, int weight) {
        setName(name);
        setSpeed (speed);
        setWeight (weight);
    }
    public void setName (String name) {
        if (name == null || name == "" ) throw new IllegalArgumentException ("Некорректное имя кота null или пустое");
        this.name = name;
    }
    public void setSpeed (int speed) {
        if (speed < 0 ) throw new IllegalArgumentException ("Скорость кота должна быть больше нуля");
        this.speed = speed;
    }
    public void setWeight (int weight) {
        if (weight< 0 ) throw new IllegalArgumentException ("Вес кота должен быть больше нуля");
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }

    public void catchMouse (Mouse mouse, Cat cats[]) {
        for(Cat cat:  cats) {
            if (cat != null) {
                for (Mouse ms: cat.mouses) {
                    if (mouse == null) throw new IllegalArgumentException("Обьект мышь не заполнен");
                    if (ms == mouse) {
                        System.out.println("Мышь уже поймана котом " + cat.getName());
                        return;
                    }
                }
            }
        }

        if (mouse.getSpeed() < speed) {
            for (int i = 0; i < mouses.length; i += 1 ) {
                if (mouses[i] == null ) {
                    mouses[i] = mouse;
                    System.out.println("Кот " + name + " поймал мышь со скоростью " + mouses[i].getSpeed());
                    return;
                }
            }
            System.out.println("Кот уже поймал максимально возможное колличество мышей " + mouses.length);
        } else System.out.println("Кот " + name + " не смог поймать мышь со скоростью " + mouse.getSpeed() + " так как ее скрость больше скорости кота " + speed);
    }

    public void catchMouse (Mouse mouse) {
        if (mouse == null) throw new IllegalArgumentException("Обьект мышь не заполнен");

        if (mouse.getSpeed() < speed) {
            for (int i = 0; i < mouses.length; i += 1 ) {
                if (mouses[i] == null ) {
                    mouses[i] = mouse;
                    System.out.println("Кот " + name + " поймал мышь со скоростью " + mouses[i].getSpeed());
                    return;
                }
            }
            System.out.println("Кот уже поймал максимально возможное колличество мышей " + mouses.length);
        } else System.out.println("Кот " + name + " не смог поймать мышь со скоростью " + mouse.getSpeed() + " так как ее скрость больше скорости кота " + speed);
    }

    public void attackCat (Cat cat) {
        if (cat == null) throw new IllegalArgumentException("Обьект кот не заполнен");
        if (this == cat) {
            System.out.println("Кот " + name + " не может атаковать сам себя");
            return;
        }
        if ( weight > cat.weight) {
            System.out.println("Кот " + name + " с весом "+ weight + " атаковал кота " + cat.getName() + " с весом " + cat.getWeight());
            for (int i = 0; i < cat.mouses.length; i ++) {
                if (cat.mouses[i] != null) {
                    catchMouse (cat.mouses[i]);
                    cat.mouses[i] = null;
                }
            }
        } else System.out.println("Кот " + name + " с весом "+ weight + " не может забрать мышей у кота " + cat.getName() + " с весом " + cat.getWeight());
    }

    public String cetchedMouse() {
        StringBuilder sb = new StringBuilder("Кот ");
        sb = sb.append(name).append(" поймал мышей со скоростью: ");
        for (Mouse ms: mouses) {
            if (ms != null) sb = sb.append(ms.getSpeed()).append(" ");
        }
        return sb.toString();
    }




}
