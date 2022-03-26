package ru.itmo.lessons.lesson7.HomeWork7_1.base;

public abstract class LessonUnit extends Unit {
    protected String lessonName;

    public LessonUnit(String name, int age, String lessonName) {
        super (name, age);
        if (lessonName == null || lessonName.length() < 4) throw new IllegalArgumentException("Некорректное название урока");
        this.lessonName = lessonName;
    }

    public void setLessonName(String lessonName) {
        if (lessonName == null || lessonName.length() < 4) throw new IllegalArgumentException("Некорректное название урока");
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }
}
