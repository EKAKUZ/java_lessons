package ru.itmo.lessons.lesson12_exception;

import java.util.Arrays;

public class Storage {
    private String[] strings;
    private int lastindex = 0;

    public Storage (int len) {
        if (len < 1) {
            throw new IllegalArgumentException("Задайте размер массива");
        }
        strings = new String[len];
    }

    public void addString(String newString) {
        if (newString == null) throw  new IllegalArgumentException("Некорректное значение строки");

        if (lastindex == strings.length ) {
            System.out.println("Элементу " + newString + "не хватило места");
            return;
        }
        strings[lastindex]=newString;
        lastindex +=1;

    }

    @Override
    public String toString() {
        return "Storage{" +
                "strings=" + Arrays.toString(strings) +
                ")";
    }


}