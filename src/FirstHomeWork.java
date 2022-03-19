public class FirstHomeWork {
    public static void main (String[] args) {

        System.out.println ("Домашнее задание №1");

        double sum = 250_000.0;
        System.out.println("Пример 1. Сумма покупки: " + (sum > 100_000 ? sum - 0.1 * sum : sum));

        int number = 32;
        System.out.println("Пример 2. Сумма чисел 2х значного числа: " + (number / 10 + number % 10));

        double lenght = 10.0, width = 5.0, hight = 3.0;
        System.out.println("Пример 3. Площадь параллелепипеда: " + 2 * (lenght * width + width * hight + hight * lenght) );

        System.out.println("Пример 4. После 45.6 нужно поставить F");
        System.out.println("Пример 4. При делении числа с плавающей точкой, получается результат с плавающей точкой");
        float a = 45.6F; // float a = 45.6;
        long b = 60000;
        float c = a / b; // long c = a / b;

        System.out.println("Пример 4. Так одно из чисел при делении типа long, результат должен быть хотя бы типа long");
        int x = 34;
        long y = 78;
        long z = x / y; // int z = x / y;

        System.out.println("Пример 4. Результат  получается типа double");
        double n = 90.8;
        double m = -100.1;
        double max = n > m ? n : m; // int max = n > m ? n : m;

        System.out.println("Пример 4. Приобразовать к типу boolean нельзя");
        byte code = 1;
        byte isActive = code; // boolean isActive = (boolean) code;

    }
}
