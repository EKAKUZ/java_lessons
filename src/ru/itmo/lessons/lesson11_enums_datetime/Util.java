package ru.itmo.lessons.lesson11_enums_datetime;

public class Util {
    // статические переменные не относятся к создаваемым обьектам, только к класс
    public static int max; // значения этих св-в можно изменить
    public static int min;
    public final static double PI; // эти значения нельзя изменить, пишут заглавными буквами
    // обычно переменные static - final
    // статический блок для инициализации статических св-в (переменных)
    // инструкции выполняются один раз при загрузке класса
    // инструкции статического блока выполняются только один раз при загруззке класса
    static {
        PI =3.14;
    }

    private Util(){} // если в классе все статическое закрываем возможность создания обьектов
    // статические классы не возможно переопределить,
    // поэтому нет смысла указывать - final
    public /*final*/ static int random(int min, int max) {
        // нельзя обратиться к не static  св-вам и методам
        // нельзя обратиться к this
        return (int) (min + Math.random()*(max - min));
    }
}
