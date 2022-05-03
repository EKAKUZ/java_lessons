package ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1;

import ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1.base.LessonUnit;

public class Teacher extends LessonUnit {
    private int teacherSkill = 20;

    public Teacher(String name, int age, String lessonName, int teacherSkill){
        super(name, age, lessonName);
        if (age < 25) throw new IllegalArgumentException("Не подходит в учитиля по возрасту");
        if (teacherSkill < 0) throw new IllegalArgumentException("Навык учителя не может быть отрицательным");
        this.teacherSkill = teacherSkill;
    }

    public void study(Student student){
        if (student.getLessonName().equalsIgnoreCase(this.lessonName))
            student.studing(teacherSkill); //не совсем по условию задачи,
        // но кажется так логичнее, сразу в учителе проверять совпадают ли уроки
    }

    @Override
    public String toString() {
        return "Teacher={" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lessonName='" + lessonName + '\'' +
                ", teacherSkill=" + teacherSkill +
                '}';
    }
}
