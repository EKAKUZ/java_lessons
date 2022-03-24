package ru.itmo.lessons.lesson6.books;

import ru.itmo.lessons.lesson6.books.Author;

import java.util.Objects;

public class Book {
    private String title; // название
    private Author author; // Автор
    private int pageCount; // количество страниц
    // private - значит к свойству и методу можно обратиться только в этом классе

    public Book () {}
    public Book (Author author) {
        // Objects - класс для работы с обьектами (как Arrays для работы с массивами)
        this.author = Objects.requireNonNull(author,"author не мб null");
    }
    public Book (String title,Author author) {
        // вызов другого конструктора
        this(author);
        setTitle(title);
    }

    // методы, позволяющие установить значения свойств
    // со всеми необходимыми проврками - сеттеры

    public void setTitle (String titleValue) {
        if (titleValue == null || titleValue.length() < 3) {
            throw new IllegalArgumentException ("Значение title от 3 символов");
        }
        title = titleValue;
    }
    // методы, позволяющие вернуть значения свойств
    // со всеми необходимыми проврками - геттеры
    public String getTitle () {
        return title;
    }



    public void setPageCount (int pageCount) {
        if (pageCount < 10) {
            throw new IllegalArgumentException ("Значение pageCount должно быть больше 10");
        }
        this.pageCount = pageCount; // this - ссылка на текущий обьект, когда имя свойства и локальной переменной совпадают
    }

    public int getPageCount () {
        return pageCount;
    }

}
