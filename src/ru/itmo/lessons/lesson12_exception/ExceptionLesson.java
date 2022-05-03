package ru.itmo.lessons.lesson12_exception;


import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {
        //Error - ошибки, связанные с проблемами уровня JVM
        //например ошибка памяти
        // Ошибки (все Error) обрабатывать нет смысла

        //Exception - исключения
        //1. Исключения времени выполнения - наследники RunTimeException - unchecked, необрабатываемый, неотслеживаемые,некотролируемые
        // разработчики могут (по своему успотрению) обработать данный тип исключения
        //2. Исключения времени компиляции (все остальные наследники Exception) checked, обрабатываемый, отслеживаемые,котролируемые
        // разработчики обязаны обработать данный тип исключения

        //RunTimeException
        // деление целого числа на 0 - java.lang.ArithmeticException
        // выход за пределы массива  - java.lang.ArrayIndexOutOfBoundsException
        // strings s = null; s.equals("data"); - java.lang.NullPointerException
        // Object obj = '123'; Integer intager = (Intager) obj; java.lang.ClassCastException
        int a = 5;
        int b = 3;
        int res;
        // обработка исключений (unchecked / checked) -обрабатывются одинаково
        try { //потенциально опасный код помещается в try, блоков catch может быть несколько
            res = a/b; //ArithmetivException
        } catch (ArithmeticException e) { // обрабатываем предсказуемые исключения
            System.out.println(e.getMessage());
            res = a;
        }
        System.out.println(res);

        Object obj = "123";
        int[] ints = new int[3];
        Integer integer;
        // несколько блоков catch поволяют обрабатывать разные исключения разными способами
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) (obj);
            else ints[90] = 100;
        } catch (ClassCastException e) {
            System.out.println("Проблемы с преведением типов " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива " + e.getMessage());
        }
        // несколько исключений обрабатываются одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) (obj);
            else ints[90] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) { // | - побитовое или
            System.out.println("Проблемы с преведением типов " +
                    "или выходом за пределы массива " + e.getMessage());
        }

        // через общего родителя несколько исключений обрабатываются одинаково
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) (obj);
            else ints[90] = 100;
        } catch (RuntimeException e) {
            System.out.println("Какое-то исключение времени выполнения " + e.getMessage());
        }

        // через общего родителя, но часть исключений обрабатывается индивидуально
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) (obj);
            else ints[90] = 100;
        } catch  (ClassCastException e) {
            System.out.println("Проблемы с преведением типов " + e.getMessage());
        } catch  (RuntimeException e) {
            System.out.println("Какое-то исключение времени выполнения " + e.getMessage());
        } // сначала дочернии перехватываем, потом родительские

        // необязательный блок finally
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) (obj);
            else ints[90] = 100;
        } catch (ClassCastException e) {
            System.out.println("Проблемы с преведением типов " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива " + e.getMessage());
        } finally {
            // инструкция выполняется в случае любого исключения в блоке try
            // инструкции связанные с закрытием инструкций
        }

        try {
            readFromJsonFile("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        int rand;
       int min=3, max=15;

        try {
            rand = Calculates.random( min, max);
        } catch (CalcException e) {
            System.out.println(e.getMessage());
        }




    }

    public static void readFromJsonFile(String filename) throws IOException {
        if (!filename.endsWith(".json")) {
            // исключения времени компиляции
            throw new IOException("Проблема с файлом");
        }
        System.out.println("Чтение из файла .json");
    }
}
