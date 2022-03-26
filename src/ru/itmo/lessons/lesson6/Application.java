package ru.itmo.lessons.lesson6;
// значение поумолчанию для boolean - false

// создаем новый пакет ru.itmo.lessons.lesson6 (ru.itmo - доменное имя компании наоборот, lessons - название проекта )
// посмотреть как обозначить папку для разработки и для компиляции

// полное имя класса - имя пакета + имя класса ru.itmo.lessons.lesson6.Application

import ru.itmo.lessons.lesson6.books.Author;
import ru.itmo.lessons.lesson6.books.Book; // (Alt + Enter)
import ru.itmo.lessons.lesson6.books.Shelf;

public class Application {
    public static void main(String[] args) {
        // класс - шаблон обьекта, способ описания сущности
        // определяющий ее сосстояние и поведение
        // класс - набор свойст и методов будующих обьектов

        // на основе класса создаются обьекты
        // (экземпляры данного класса) - представители класса, имеющие конкретное состояние и
        // имеющие конкретное состояние и
        // поведение, определенное в классе


        // В lesson6 создаем еще пакет books (будем описывать авторов, книги, полку)
        // в books создаем класс Author

        // создаем экземпляр класса автор
        Author author1 = new Author();
        //доступ к свойства обьекта через точку
        author1.name = "Tom";
        author1.surname = "Crowed";
        Author author2 = new Author();
        author2.name = "Mike";
        author2.surname = "Thompson";
        // если классы находятся в разных пакетах, импортируем его import ru.itmo.lessons.lesson6.books.Author;

        // вызов методов
        author1.printFullName();
        author2.printFullName();
        System.out.println(author1.getFullName());
        System.out.println(author2.getFullName());

        Book book1 = new Book(author1);
        // book1.title = ""; // проверка внутри класса
        // book1.pageCount= -34; // проверка внутри класса
        book1.setTitle("Книга");
        System.out.println(book1.getTitle());
        book1.setPageCount(34);
        System.out.println(book1.getPageCount());

        Shelf shelf = new Shelf();
        shelf.addBook(book1);
        shelf.addBook(book1,book1, book1); //книги в методе собируться в массив в локальную переменную books
        // вывод имени автора первой книги на полке
        // Book book2 = new Book(author2); ???
        System.out.println(author1);
        System.out.println(book1);
        System.out.println(shelf);
    }
}




