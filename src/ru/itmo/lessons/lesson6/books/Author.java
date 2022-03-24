package ru.itmo.lessons.lesson6.books;

public class Author {
    // свойства, характеристики, поля, атрибуты
    public String name; //null
    public String surname; //null

    // public - к свойству можно обратиться из любого участка программ
    // методы, могут возвращать результат работы, или не возвращать - void

    public void printFullName() {
        System.out.println(name + " " + surname);
    };

    public String getFullName() {
        return name + " " + surname; // возвращает результат работы метода и прерывает работу метода
        // используется в void для прерывание работы метода - return;
    };

    public String getAuthor() {
        return name;
    }

}