package ru.itmo.lessons.lesson13_generic.types;

public class User<T> {
    // тип T определяется при создании обьектов


    private String login;
    private T id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public void setId (T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", id=" + id +
                '}';
    }
}
