package ru.itmo.lessons.lesson9_objectmetods;

import java.util.Objects;

// все классы в языке наследуются от класса Object, а значит получают его методы
// implements Cloneable, необходим, если происходит вызов метода
// clone родителя - Object, super.clone()
public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }
    // в дочерний класс наследуются геттеры и сеттеры,
    // если дочерних классов нет и нет проверки, то стоит свойства сделать public
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false; //возвращает true если объект относится к данному типу данных
        Point point = (Point) o; // преведение типов
        return x == point.x && y == point.y;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //возвращает true если объект относится к данному классу
        Point point = (Point) o; // преведение типов
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    } // используется в мапах

    @Override
    public Point clone() {
        try {
            return (Point) super.clone(); // можно если в свойствах нет ссылочных типов
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


