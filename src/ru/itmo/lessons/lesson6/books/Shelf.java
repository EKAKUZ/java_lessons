package ru.itmo.lessons.lesson6.books;

import java.util.Arrays;

public class Shelf {

    private String color = "белый"; // цвет полки
    public Book[] books = new Book[10]; // книгb

    @Override
    public String toString() {
        return "Shelf{" +
                "color='" + color + '\'' +
                ", books=" + Arrays.toString(books) +
                '}';
    }

     // метод давления одной книги на полку
    private void addBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) books[i] = book;
            return; // целиком метод
        }
        System.out.println("Нет места на полке");
    }
    // метод давления нескольких книги на полку
    public void addBook(Book... books) {
        System.out.println(Arrays.toString(books));
        for (Book book: books) {
            addBook(book);
        }
    }

}
