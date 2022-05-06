package ru.itmo.lessons.lesson21_oop_patterns;

public class User {
    private Level level;
    private String login;

    //внутренний класс
    //1. область видимости согласно модификатором доступа
    //2. нельзя создать обьект внутреннего класса без создания экземпляра внешнего класса
    //3. не может содержать статических методов и свойств,
    // только если статическое св-во не final
    public class Account{
        private float balance;
        //private static final int MAX_BALANCE = 500;

        public Account(float balance) {
            // возможен доступ к приватным методам и свойствам внешнего класса
            this.balance = balance + User.this.level.getCount();
        }

        public User getUser(){
            // доступ к экземпляру внешнего класса
            return User.this; // ссылка на экземпляр внешнего класса
        }

    }

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    // User.Level.элемент
    public enum Level { // вложенный класс (static класс)
        HIGH(10), MEDIUM(5), LOW(0);
        private int count;
        Level(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", login='" + login + '\'' +
                '}';
    }

}
