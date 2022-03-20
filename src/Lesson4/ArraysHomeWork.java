package Lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysHomeWork {
    public static void main(String[] args) {

        System.out.println ("Домашнее задание №4");

        System.out.println ("Пример 1");
        int N = 0, max = 0, min = 0;
        double average = 0.0;
        Scanner scanner = new Scanner(System.in);

        while (N <= 0 ) {
            System.out.println("Введите целое число положительное - размер массива");
            N = scanner.nextInt();
        }

        int[] ints1 = new int [N];

        // Вариант 1
        for (int i = 0; i < ints1.length; i += 1) {
            ints1[i] = (int) (Math.random()*2000 - 1000);
            if (i == 0) {
                max = ints1[i];
                min = ints1[i];
                average =ints1[i];
            } else {
                if (max < ints1[i]) max = ints1[i];
                if (min > ints1[i]) min = ints1[i];
                average += ints1[i];
            }
        }
        average =average / ints1.length;
        System.out.println(Arrays.toString(ints1));
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднее значение: " + average);

        // Вариант 2
        for (int i = 0; i < ints1.length; i += 1) {
            ints1[i] = (int) (Math.random()*2000 - 1000);
            average += ints1[i];
        }
        Arrays.sort (ints1);
        System.out.println(Arrays.toString(ints1));
        System.out.println("Максимальное значение: " + ints1[ints1.length - 1]);
        System.out.println("Минимальное значение: " + ints1[0]);
        System.out.println("Среднее значение: " + average);


        System.out.println ("Пример 2");
        int start = 2, stop =20;

        int[] ints2 = new int[(stop - start) / 2 + 1];

        for (int i = 0, j = start; i < ints2.length; i += 1, j += 2) {
            ints2[i] = j;
        }
        System.out.println(Arrays.toString(ints2));

        for (int i = ints2.length - 1; i >= 0 ; i -= 1) {
            System.out.print(ints2[i] + " ");
        }

        System.out.println ("\nПример 3");
        int[] ints3 = {-1, 1, 0, 0, 1, 1, -1, 0, 1, 1, -1};
        System.out.println(Arrays.toString(ints3));

        int a=0, b=0, c=0;
        for (int element : ints3) {
            if (element == 0) a += 1;
            else if (element == 1) b += 1;
            else c +=1;
        }
        if (a > b && a > c ) System.out.println("В массиве чаще встречается 0. " + a + " раз");
        if (b > a && b > c) System.out.println("В массиве чаще встречается 1. " + b + " раз");
        if (c > a && c > b) System.out.println("В массиве чаще встречается -1. " + c + " раз");

        System.out.println ("Пример 4");
        int[] ints4 = {78, 97, 45, 67, 80, 68};
        int i = 0, j = 0;
        a = 0;
        b = 0;

        for (int element : ints4) {
            if (element % 2 == 0) a += 1;
            else b += 1;
        }
        int[] intChet = new int[a];
        int[] intNeChet = new int[b];


        for (int element : ints4) {

            if (element % 2 == 0) {
                intChet[i] = element;
                i += 1;
            } else {
                intNeChet[j] = element;
                j += 1;
            }
        }
        Arrays.sort(intChet);
        Arrays.sort(intNeChet);

        System.out.println(Arrays.toString(ints4));
        System.out.println(Arrays.toString(intChet));
        System.out.println(Arrays.toString(intNeChet));

        System.out.println ("Пример 5");
        double[] doubles5 = {78.0, -97.6, -45.4, 67.3, -80.5, 68.2};
        i = 0;
        a = 0;

        for (double element : doubles5) {
            if (element < 0) a += 1;
        }
        double[] doubleOtr = new double[a];

        for (double element : doubles5) {
            if (element < 0) {
                doubleOtr[i] = element;
                i += 1;
            }
        }
        System.out.println(Arrays.toString(doubles5));
        System.out.println(Arrays.toString(doubleOtr));
    }



}
