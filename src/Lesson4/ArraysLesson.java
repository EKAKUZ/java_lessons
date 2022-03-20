package Lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLesson {

    public static void main(String[] args) {
        // примитивные типы данных - обращаются к разным областям памяти
        int a=100;
        int b;
        b = a;
        a = 200; // b - не изменится
        // ссылочные типы данных - обращаются к одной области памяти

        Scanner scanner = new Scanner(System.in);
        Scanner in = scanner;

        // массив нумеруется с нуля, длина не изменна

        int[] ints1 = new int[7]; // массив на 7 элементов
        //int inst1[] - так тоже правильно
        // System.out.println(ints1); - не корректно
        System.out.println(Arrays.toString(ints1)); // вывод значений массива на консоль

        int[] ints2 = {6, -90, 56, 12, 0, -44}; // создается массив с заданными значениями
        System.out.println(Arrays.toString(ints2));

        ints2 = new int[3]; // обьявляем новый массив, старый массив остался в памяти без ссылок
        // массивы без ссылок удалит сборщик мусора
        System.out.println(Arrays.toString(ints2));

        //ints2 = {34, 78, 12}; - нельзя
        ints2 = new int[]{34, 78, 12, 78};
        System.out.println(Arrays.toString(ints2));

        // длинна массива - положительное значение типа int
        int len =10;
        int[] ints3 = new int[len];
        int[] ints4 = new int[len + 5];

        System.out.println(ints4.length); //узнаем длину массива
        System.out.println(Arrays.toString(ints4));

        // доступ к элементам массива
        System.out.println(ints4[3]);
        int arrElem = ints4[3];
        ints4[2] = 56;
        System.out.println(Arrays.toString(ints4));

        //System.out.println(ints4[100]); // ошибка времени выполнения ArrayIndexOutOfBoundsException

        // многомерный массив - массив массивов
        //[ [0,0,0,0], [0,0,0,0], [0,0,0,0]] - двумерный массив
        int[][] ints5 = new int[3][4];
        System.out.println(Arrays.deepToString(ints5)); // вывод многомерного массива
        int[][] ints6 = new int[3][]; // [null,null,null]
        System.out.println(Arrays.deepToString(ints6));
        ints6[0] = new int[2];
        ints6[1] = new int[3];
        ints6[2] = new int[4]; // [[0, 0], [0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints6));

        ints6[2][1] = 90;
        ints6[1][2] = 36;

        int[] ints7 = {3, -6, 12, 0, 4};
        System.out.println(Arrays.toString(ints7));
        // for - для изменения значения элементов
        for (int i = 0; i < ints7.length; i += 1) {
            ints7[i] *= ints7[i];
        }
        System.out.println(Arrays.toString(ints7));

        int sum = 0;
        for (int i = 0; i < ints7.length; i += 1) {
            sum += ints7[i];
        }
        System.out.println(sum);
        // можно обьединить for

        sum = 0;
        //не предоставляет доступа к индексам
        // не дает возможность изменить значения элементов массива
        // переменная element - значение элемента массива
        for (int element: ints7) {
            sum += element;
        }
        System.out.println(sum);

        double[] ints8 = {3.7, -6.2, 12.9, 0.4, 4.1};
        double peremen= ints8 [0];
        for (double element: ints8) {
            if (peremen > element) peremen = element;
        }
        System.out.println(peremen);

        System.out.println(ints8.length);

        System.out.println(ints8[(int) (Math.random()*(ints8.length -1))]); // ошибка в уроке

        Arrays.sort(ints8);
        System.out.println(Arrays.toString(ints8));

        int index = Arrays.binarySearch(ints8, 3.7);
        System.out.println(index);

        index = Arrays.binarySearch(ints8, 8); // возвращает index < 0? и где элемент мог бы распологаться в отсортированном массиве
        System.out.println(index);

        double[] ints9 = {3.7, -6.2, 12.9, 0.4, 4.1};
        double[] ints10 = ints9; // это не копирование, а новое обращение к области памяти
        double[] cloneInts9 = ints9.clone(); // вариант 1
        double[] copyInts9 = Arrays.copyOf(ints9, 35); // вариант 2
        System.out.println(Arrays.toString(copyInts9));

        double[] newDoubles = new double[10];
        System.arraycopy(ints9, 1, newDoubles, 3, 2);
        System.out.println(Arrays.toString(newDoubles));

    }
}
