package ru.itmo.lessons.lesson13_generic.types;

public class TypesApp {
    public static void main(String[] args) {
        User<String> stringUser = new User<>(); //указываем тип который будем использовать вместо Т
        // если не указываем тип то работаем как с обжект
        stringUser.setId("fr25425");
        stringUser.setLogin ("qwerty");

        String sId = stringUser.getId();
        System.out.println(sId.contains("fr"));

        User<Integer> integerUser = new User<>();
        integerUser.setId(1);
        integerUser.setLogin ("asd");

        Integer iId = integerUser.getId();
        System.out.println(iId > 0);

        PairContainer<String, Integer> container1 = new PairContainer<>("qwe",3);
        System.out.println(container1.getKey()); //string
        System.out.println(container1.getValue()); //integer

        PairContainer<Integer, User> container2 = new PairContainer<>(3, stringUser);
        Object old = container2.getValue().getId();

        PairContainer<Integer, User<String>> container3 = new PairContainer<>(3, stringUser);
        String strld = container3.getValue().getId();



        //PairContainer<Integer,User<Integer>> container4 = new PairContainer<>(4,integerUser);
        PairContainer<Integer, PairContainer<Integer,User<Integer>>> container5 = new PairContainer<>(5, new PairContainer<>(4,integerUser));

        Integer iId2 = container5.getValue().getValue().getId();
        PairContainer<Integer,User<Integer>> container6 = container5.getValue();
        User<Integer> integerUser2 = container6.getValue();

    }
}
