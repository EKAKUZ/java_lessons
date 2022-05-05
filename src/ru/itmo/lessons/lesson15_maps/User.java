package ru.itmo.lessons.lesson15_maps;

public class User {
    private String login;
    private String pwd;
    private Role role;
    private int age;

    public User(String login, String pwd, Role role, int age) {
        this.login = login;
        this.pwd = pwd;
        this.role = role;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getPwd() {
        return pwd;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                ", age=" + age +
                '}';
    }
}
