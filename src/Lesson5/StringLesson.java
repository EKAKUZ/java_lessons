package Lesson5;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        //char - примитивный тип даннх 16 бит - 1 символ
        // от 0 до 65536 '\u0000' до '\uffff'

        char char1 = 'J'; // символ
        char char2 = 74;  // номер символа
        char char3 = '\u0044';  // 16 ричное представление символа в escape

        // последовательности

        System.out.print(char1+ " ");
        System.out.print(char2 + " ");
        System.out.print(char3 + " ");

        System.out.println("\nСтроки");

        // строка - упорядочная последовательность символов, ссылочный тип, экземпляр класса String
        // new String() - если способ создания новой строки через кавычки не возможен
        // сроку изменить нельзя - можно только создать новую
        System.out.println("Строковый литерал - это текст тоже строка");
        char[] chars = {'\u004A', '\u004A', '\u0044'};
        String  jjdString = new String(chars);
        System.out.println(jjdString);
        System.out.println(jjdString.length());

        char[] chars1 = {'\uD83D', '\uDC38'};
        String  frogString = new String(chars1);
        System.out.println(frogString); //🐸
        System.out.println(frogString.length()); // количество char
        System.out.println(frogString.codePoints().count()); // количество символов

        // Хранение строк до JAVA 9, строки ранились массив char[] в кодировке UTF - 16
        // каждый символ 2 байта

        // Начиная с 9  версии как массив byte[] + указание на кодировку
        // LATIN1 или UTF - 16

        //Пул строк
        // Набор уникальных строк - хранит только одну копию строкового литерала
        // new String() - не помещает в пулл строк

        String string1 = "Строка";
        String string2 = "Строка"; // ссылаются на одно место в пуле строк        String string3 = new String("Строка"); //heap -память
        String string3 = new String("Строка");
        String internString  = string3.intern(); // internString - строка из пула
        string3 = null;

        string1 = "Строка";
        string2 = "Строка";

        System.out.println(string1.equals(string2));
        System.out.println("строка".equals(string2));
        System.out.println("строка".equalsIgnoreCase(string2));

        //string2 = null;

        System.out.println("строка".equals(string2));
        System.out.println(string2.equals("строка")); //верхний способ лучше, для ситуации когда string2 = null ошибка - NullPointerException

        // проверка на null - обычное стравнение string2 == null

        string1 = "Java";
        string2 = "Python";

        // конкатенация строка
        String concatString =  string1 + " :: " + string2;
        System.out.println(concatString);

        concatString = string1.concat(" :: ").concat(string2);

        concatString = String.join(" :: ", string1, string2); // обьединение через разделитель

        concatString = "";
        for (int i = 0; i < 10; i+=1 ) {
            concatString = i + "";
        }

        //так нельзя создается слишком много строк, может не хватить памяти

        //StringBuilder - работает быстрее
        //StringBuffer - потокобезопасный, можно использовать в многопоточных программах

        concatString = "Начало строки ";
        StringBuilder sb = new StringBuilder(concatString); //StringBuilder sb = new StringBuilder(); - можно так
        sb.append(string1).append(" :: ").append(string2);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i+=1 ) {
            sb2.append(i).append(" ");
        }
        System.out.println(sb2); // в println уже реализован метод .toString

        String sbString = sb2.toString();
        System.out.println(sbString);

        // split()

        String langs = "Java, Python, JavaScript";
        String[] langArr = langs.split(", "); // делит строку на массив по разделителю
        System.out.println(Arrays.toString(langArr));

        // методы замены
        String newString = langs.replaceAll(", ", " - "); //работает с регуляр выражениями
        System.out.println(newString);

        newString = langs.replace(", ", " - "); // не работает с регулярными выражениями
        System.out.println(newString);

        System.out.println(langs.contains("th")); // содержит ли послед символов true/false
        System.out.println(langs.startsWith("th")); // начинается ли с послед символов true/false
        System.out.println(langs.endsWith("th")); // заканчивается ли послед символов true/false
        System.out.println(langs.startsWith("a", 1)); // содержит ли  послед символов начиная с элемента true/false



    }
}
