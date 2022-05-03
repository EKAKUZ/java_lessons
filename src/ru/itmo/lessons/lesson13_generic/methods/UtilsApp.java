package ru.itmo.lessons.lesson13_generic.methods;

public class UtilsApp {
    public static void main(String[] args) {
        String[] strings = {"eee", "ssf", "ddd", "1"};
        String string = "eee";
        System.out.println(CustomUtils.inArray(strings,string));//при компиляции будет тип Object
        System.out.println(CustomUtils.<String>inArray(strings,string)); // при компиляции будет String
        //System.out.println(CustomUtils.<String>inArray(strings,1)); // не скомпилирует
        System.out.println(CustomUtils.inArray(strings,1)); // скомпилируется
        System.out.println(CustomUtils.<String>inArray(strings,"1")); // скомпилируется

        Integer[] integers = {2,4,5}; // обертка над примитивом int
        Integer integer = 34;

        System.out.println(CustomUtils.<Integer>inArray(integers,integer));

        Number numb = 12;
        System.out.println(CustomUtils.compareHasCode(numb, string));
        System.out.println(CustomUtils.<Number, String>compareHasCode(numb, string));
     }
}
