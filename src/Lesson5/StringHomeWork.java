package Lesson5;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class StringHomeWork {
    public static void main(String[] args) {

        System.out.println ("Домашнее задание №5");

        System.out.println ("Пример 1");

        String[] strArr = new String[(int)(Math.random()*7 + 3)];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Заполните массив из " + strArr.length + " слов");
        for (int i = 0; i < strArr.length; i += 1) {
            System.out.println("Введите слово");
            String str1 = scanner.nextLine();

            if ("exit".equalsIgnoreCase(str1)) break;

            for (String seahstr: strArr) {
                if (str1.equalsIgnoreCase(seahstr)) {
                    System.out.println("Такое слово уже есть");
                    i -= 1;
                    break;
                }
                if (seahstr == null) strArr[i] = str1;
            }
        }

        System.out.println (Arrays.toString(strArr));

        System.out.println ("Пример 2");
        System.out.println("Введите слово");
        String str2 = scanner.nextLine();

        String outStr = str2.substring(0,1).toUpperCase(Locale.ROOT) + str2.substring(1, str2.length()).toLowerCase(Locale.ROOT);
        System.out.println (outStr);

        System.out.println ("Пример 3");
        String str3 = "в предложении все слова разной длины";
        outStr = "";
        String[] words = str3.split(" ");
        for (String elem : words) {
            if (outStr.length()<elem.length()) outStr = elem;
        } // ??? память
        System.out.println ("Самое длинное слово :" + outStr);

        System.out.println ("Пример 4");
        System.out.println("Введите полиндром");
        StringBuilder str4 = new StringBuilder();
        str4.append(scanner.nextLine());
        StringBuilder invertStr = str4.reverse();
         if (str4.toString().equalsIgnoreCase(invertStr.toString()))  System.out.println("Вы ввели полиндром");
         else System.out.println("Вы ввели не полиндром");

    }
}
