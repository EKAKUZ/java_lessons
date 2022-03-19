package Lesson3;

import java.util.Scanner; // !!!пакет со Scanner

public class ThirdLesson {

    public static void main(String[] args) {

        // Пользовательский ввод
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число и нажмите Enter");
        int userNum = in.nextInt();
        System.out.println(userNum * userNum);

        while (true){
            System.out.println("WHILE: Введите целое положительное число и нажмите Enter " +
                    "или 0 для выхода из программы");
            userNum = in.nextInt();
            if (userNum == 0) break; //завершение текущего цикла
            if (userNum > 0) continue; //переход на след. итерацию
            System.out.println(userNum * userNum);
        }

        do {
            System.out.println("DOWHILE: Введите целое положительное число и нажмите Enter " +
                    "или 0 для выхода из программы");
            userNum = in.nextInt();
            if (userNum > 0) continue;
            System.out.println(userNum * userNum);
        } while(userNum != 0);

        int start = 1, end = 12;
        // вывести все четные числа от start до end
        while (start <= end) {
            if (start % 2 ==0) System.out.println(start);
            start += 1;
        }

        // for (;;) - безконечный цикл
        for (start = 1, end = 12; //инициализация переменных
             start <= end; //условие
             start +=1) {   //обновление значений переменных
            if (start % 2 ==0) System.out.println(start);
        }

        for (int num = 90; num >= 0; num -= 5) {
            System.out.println(num);
        }

        for(int i = 1, num = 2; i <= 10; i += 1, num += 2) {
            System.out.println(num);
        }

        int userTare;
        double userWash;
        int i = 1;
        System.out.println("Введите количество грязных тарелок");
        userTare = in.nextInt();
        System.out.println("Введите количество моющего средства");
        userWash= in.nextDouble();

        while (userWash > 0 && userTare > 0) {
            userTare -= 1;
            userWash -= 0.5;
            System.out.println("После мытья "+ i + " тарелок сталось " + userWash + "средства");
            i += 1;
        }
        System.out.println("Осталось средства: " + userWash + " Осталось тарелок: " + userTare);
    }
}
