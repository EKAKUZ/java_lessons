package ru.itmo.lessons.exams.exam1;

import java.time.LocalDate;

public class Owner {
    private String name;
    private String surname;
    private int year;

    public Owner (String name, String surname, int year){
        if (name == null || name.length() < 2) throw new IllegalArgumentException("Некорректное имя владельца абонемента");
        if (surname == null || surname.length() < 2) throw new IllegalArgumentException("Некорректная фамилия владельца абонемента");

        LocalDate currentDate = LocalDate.now();
        if ( currentDate.getYear() - 14 < year ||  currentDate.getYear() - 80 > year)
            throw new IllegalArgumentException("В фитнесс клубе могут заниматься лица до "
                    + (currentDate.getYear() - 14) + " года рождения и после "
                    + (currentDate.getYear() - 80) + " года рождения");

        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public String FullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                '}';
    }
}
