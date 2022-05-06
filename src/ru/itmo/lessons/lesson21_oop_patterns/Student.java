package ru.itmo.lessons.lesson21_oop_patterns;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Exam> examList = new ArrayList<>();

    public void printExamInfo() {
        examList.forEach(System.out::println);
    }

    public void addExam(Exam exam) {
        examList.add(exam);
    }

    public Student(String name) {
        this.name = name;
    }

    //вложенный класс static
    //1. внешний класс не может быть static
    //2. область видимости согласно модификаторам
    //3. можно создать без экземпляра внешнего класса
    //4. нет доступа к нестатическим св-вам и методам внешнего класса
    public static class Exam{
        private String title;
        private int mark;

        public Exam(String title) {
            this.title = title;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "title='" + title + '\'' +
                    ", mark=" + mark +
                    '}';
        }
    }
}
