package ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1;

import ru.itmo.lessons.lesson7_oop_interface_abstractclass.HomeWork7_1.base.LessonUnit;

public class Student extends LessonUnit {
    private int knowledgeLevel;

    public Student(String name, int age, String lessonName, int knowledgeLevel) {
        super(name, age, lessonName);
        if (age < 6 || age > 17) throw new IllegalArgumentException("Не подходит в ученики по возрасту");
        if (knowledgeLevel < 0) throw new IllegalArgumentException("Уровень знаний не может быть отрицательным");
        this.knowledgeLevel = knowledgeLevel;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", lessonName='" + lessonName + '\'' +
                ", knowledgeLevel=" + knowledgeLevel +
                '}';
    }
    public void studing(int teacherSkill) {
        if (teacherSkill < knowledgeLevel) {
            System.out.println("Ученик знает предмет лучше учителя");
            return;
        }
        knowledgeLevel = (int) (Math.random() *(teacherSkill - knowledgeLevel) + knowledgeLevel);
    }

}
