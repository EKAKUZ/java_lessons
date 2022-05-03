package ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1;

import java.util.Arrays;

public class School {
    private String title;
    private Director director;
    private Teacher[] teachers;
    private Student[] students;

    public School(String title, Director director, int countTeachers, int countStudents) {
        if (title == null || title.length()<0)
            throw new IllegalArgumentException("Ошибка создания экзепляра школа, некорректное название");
        if (director == null) throw new IllegalArgumentException("Школа не может функционировать без директора");
        if (countTeachers < 1) throw new IllegalArgumentException("Некорректное количество учителей");
        if (countStudents < 1) throw new IllegalArgumentException("Некорректное количество учиников");
        this.title = title;
        this.director = director;
        teachers = new Teacher[countTeachers];
        students = new Student[countStudents];
    }

    public School(String title, Director director, Teacher[] teachers, Student[] students) {
        if (title == null || title.length()==0)
            throw new IllegalArgumentException("Ошибка создания экзепляра школа, некорректное название");
        if (director == null) throw new IllegalArgumentException("Школа не может функционировать без директора");
        if (teachers == null) throw new IllegalArgumentException("В школе должны быть учителя");
        if (students == null) throw new IllegalArgumentException("В школе должны быть учиники");
        this.title = title;
        this.director = director;
        this.teachers = teachers;
        this.students = students;
    }

    public void setDirector(Director director) {
        if (director == null) throw new IllegalArgumentException("Школа не может функционировать без директора");
        this.director = director;
    }

    public void oneDayInSchool () {
        System.out.println("Школа " + title);
        director.lessonStart();
        if (teachers[0] != null && students[0] != null) {
            for (Teacher teacher: teachers) {
                for (Student student : students) {
                teacher.study(student);
                }
            }
        }
        director.lessonStop();
    }
    public void addTeaher(Teacher teacher) {
        if (teacher == null) throw new IllegalArgumentException("Обьект учитель null");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            }
        }
        System.out.println("В школе достаточное количество учитилей");
    }
    public void addStudent(Student student) {
        if (student == null) throw new IllegalArgumentException("Обьект ученик null");
        for (int i = 0; i  < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        System.out.println("В школе достаточное количество учеников");
    }


    @Override
    public String toString() {
        return "School{" +
                "title='" + title + '\'' +
                ", director=" + director +
                ", teachers=" + Arrays.toString(teachers) +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
