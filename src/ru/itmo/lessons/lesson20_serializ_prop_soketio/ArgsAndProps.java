package ru.itmo.lessons.lesson20_serializ_prop_soketio;

import java.io.*;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        // запуск программы с аргументами:
        // Modify Run Configuration
        // перечислить аргументы через пробел

        for (String arg: args) {
            System.out.println(arg);
        }

        // дирректория с ресурсами (resources) - может быть любое название
        // lesson20.properties (.properties - расширение)
        // пкм -> Mark Directory As -> Resources Root

        Properties properties = new Properties();
        // хранит данные в паре: ключ  и значение всегда строки
        properties.setProperty("ключ", "значение");
        // получение
        properties.getProperty("ключ");
        //очистить
        properties.clear();
        //....
        // загрузить из файла *.properties

        //properties.load(InputStream);
        //try {
        //    File file = new File("resources.properties");
        //    properties.load(InputStream input1 = new FileInputStream(file));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}


        try (InputStream input  = ArgsAndProps.class
                .getClassLoader()
                .getResourceAsStream("lesson20.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.forEach((key,value) -> System.out.println(key + " : " +value + " "));

    }
}
