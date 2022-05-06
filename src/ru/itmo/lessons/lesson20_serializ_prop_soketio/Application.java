package ru.itmo.lessons.lesson20_serializ_prop_soketio;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45,67);
        Point b = new Point(67,12);
        Point c = new Point(89,-8);

        BinHandler binHandler = new BinHandler();
        binHandler.writeToFile(a);

        Point aFromFile = binHandler.readFromFile();

        System.out.println(aFromFile);

        Figure fig1 = new Figure( 3);
        fig1.addPoint(a);
        fig1.addPoint(b);
        fig1.addPoint(c);

        File file = new File("lesson20_figure.bin");
        BinHandler binHandler1= new BinHandler(file);
        binHandler1.writeToFile(fig1);

        Figure fig2 = binHandler1.readFromFile();

        System.out.println(fig2);

    }
}
