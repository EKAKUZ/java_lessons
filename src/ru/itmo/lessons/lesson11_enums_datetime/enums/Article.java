package ru.itmo.lessons.lesson11_enums_datetime.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime created;
    private Country country; // по умолчанию  null -> AUSTRALIA, UK, FRANCE

    public Article(String title) {
        this.title = title;
        created = LocalDateTime.now();
        // текущее дата и время now - статичский метод, задача создать экзепляр
        // типа DateTime и передать туда текущие дату и время
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        if (country != null) {
            this.country = country;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null) {
            this.text = text;
        }
    }


}
