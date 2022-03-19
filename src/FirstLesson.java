public class FirstLesson {
    // psvm -метод (точка входа вприложение, обязателен для приложения)
    // односрочный коммент
    /*
    многострочный коммент


   /**
   *  документированный код
   * @param args
   */


    public static void main(String[] args) {
        // sout - инструкция, что нужно сделать
        System.out.println("Информация для вывода на консоль");
        //типДанных имяПеременной;

        int size; // обьявили переменную
        size = 56;
        int count =71899; // обьявили и задали значение
        int lenght = 122, width = 500;

        count = 800000; // большие числа можно разделять нижним подчеркиванием 800_000

        System.out.println(count);

        //byte data =327; выходит за диапазон типа byte

        long veryBig = 67_000_000_000L; // символ L/l говорит о использовании типа long

        // деление целых чисел на 0 - ошибка
        // System.out.println(count / 0);

        double price =56.7; //разделитель "." для большой точности 56.7567676767676 типом double  пользоваться нельзя
        float temp = -78.3f; // F/f явное указание, что работа с float

        // деление чисел с плавающей точкой на 0 - результат бесконечность Infinity
        System.out.println(price / 0);

        // double price = 34; в рамках одной области видимости нельзя несколько раз обьявлять одну переменную

        count = 8700; // int
        price = count; //автоматич приведение типов //double
        System.out.println(price);

        //byte small = count; - автоматич. приведение работать не будет
        byte small = (byte) count; // явное приведение типов данных возможна потеря данных
        System.out.println(small);
        // char в int приобразуется юникод
        // boolean преобразовывать нельзя

        // операторы + (сложение, явное приведение  byte short chart, конкатенация строк) - (вычетание, приобразование типов) * / %  (остаток от деления)
        int a = 9, b = 4;
        int c = a / b;
        System.out.println(c);

        double d = a / b; // получаем 2.0
        System.out.println(d);

        byte x = 6, y = 12;
        //byte z = x + y; ошибка так как сложение преобразует в int
        byte z = (byte) (x + y);
        int r = x + y;
        System.out.println("r = " + r);

        double i = (double) a / b; // получаем 2.0
        System.out.println(i);

        lenght = 9;
        width = 2;
        System.out.println(lenght % width);

        // операторы присваивания = += -= *= /= %=
        int num = 10;
        //num = num + 10;
        num += 10;
        //num = num - 10;
        num -= 10;
        //num = num * 10;
        num *= 10;
        //num = num / 10;
        num /= 10;
        //num = num % 10;
        num %= 10;

        // операторы сравнения > < == >= <= != резултат тип boolean
        System.out.println( lenght == width);
        System.out.println(a > b);

        // тернарный оператор ?
        int start = 3, end = 5000;
        int res = start > end ? end - start : 0;
        System.out.println(res);



    }
}
