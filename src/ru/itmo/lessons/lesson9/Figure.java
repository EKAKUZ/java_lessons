package ru.itmo.lessons.lesson9;

import java.util.Arrays;

// в одном файле мб только один public класс, но несколько private
public final class Figure {
    private final Point[] points; // final нельзя переопределить ссылку,
    // устанавливается или при определении или в конструкторе

    public Figure (int pointCount) {
        if (pointCount < 3) {
            throw new IllegalArgumentException("Фигура должна состоять минимум из 3 точек");
        }
        this.points = new Point[pointCount];
    }

    public Point[] getPoints() {
        return points;
    } // опасен

    public void addPoint (Point point) {
        if (point == null) {
            System.out.println("Точка не была добавлена. Так как null" );
            return;
        }
        for (int i = 0; i < points.length; i++) {
                if (points[i] != null && point.equals(points[i])) {
                    System.out.println("Точка " + point + " не была добавлена");
                    return;
                }
                if (points[i] == null) {
                    points[i] = point;
                    System.out.println("Точка " + point + " была добавлена");
                    return;
                }
        }
        System.out.println("Точка " + point + "не была добавлена. " +
                "У фигуры достаточное количество точек.");
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public Figure clone() {
        Figure copy = new Figure(points.length);
        for (int i = 0; i < points.length; i ++) {
            copy.points[i] = points[i].clone();
        }
        return copy;
    }


}
