package Lesson3;

import java.util.Scanner;

public class ThirdHomeWork {
    public static void main(String[] args) {

        System.out.println ("Домашнее задание №3");

        System.out.println ("Пример 1. Задача на for");
        for (int i = 1, num = 1; i <= 55; i += 1, num +=2) {
            System.out.println("Число " + i + " : " + num);
        }

        System.out.println ("Пример 2. Задача на while");
        int userNum, sum;
        Scanner in = new Scanner(System.in);
        System.out.println ("Введите целое положительное число");
        userNum = in.nextInt();
        while (userNum <= 0) {
            System.out.println ("Вы ввели отрицательное число или 0, повторите ввод");
            userNum = in.nextInt();
        }
        sum = userNum % 10;
        while (userNum / 10 > 0) {
            userNum = userNum /10;
            sum += userNum % 10;
        }
        System.out.println ("Сумма цифр введеного числа = " + sum);

        System.out.println ("Пример 3");
        int programNum;
        programNum = 1+  (int) (Math.random() * 8);
        do {
            System.out.println("Угадайте число в диапазоне >= 1 и < 9 или введите 0 для выхода из программы");
            userNum = in.nextInt();
            if (userNum == 0) break;
            // думаю нет смысл проверять входит ли введеное число в диапазон,
            // оно все равно больше или меньше загаданного
            if (programNum > userNum) System.out.println("Загаданное число больше");
            else if (programNum < userNum) System.out.println("Загаданное число меньше");
            else System.out.println("Вы угадали");
        } while (userNum != programNum);

        System.out.println ("Пример 4");
        System.out.println("Загадайте число от 2 до 100 включительно");
        userNum = in.nextInt();
        while (userNum < 2 || userNum > 100) {
            System.out.println("Загаданное число вне диапазонп от 2 до 100 включительно");
            System.out.println("Загадайте число от 2 до 100 включительно");
            userNum = in.nextInt();
        }

        int answer, start = 2, stop =100;
        while (true) {
            if (programNum == 99) programNum=100;
            else programNum = (start + stop) / 2;

            System.out.println("Вы загадали " + programNum + " ? ДА -1, НЕТ - 0");
            answer = in.nextInt();

            if (answer == 1) {
                System.out.println("Вы загадали " + programNum + " !!!");
                break;
            }
            else if (answer == 0) {
                System.out.println("Число больше " + programNum + " ? ДА -1, НЕТ - 0");
                answer = in.nextInt();

                if (answer == 1) start = programNum;
                else if (answer == 0) stop = programNum;
                else System.out.println("Пожалуйста, отвечайте только: ДА -1, НЕТ - 0");
                continue;
            }
            else {
                System.out.println("Пожалуйста, отвечайте только: ДА -1, НЕТ - 0");
                continue;
            }
        }

    }
}