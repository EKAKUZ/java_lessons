package ru.itmo.lessons.lesson7.HomeWork7_1;

import ru.itmo.lessons.lesson7.HomeWork7_1.base.Unit;

public class Application {
    public static void main(String[] args) {

        School school1 = new School("№32", new Director("Иван Петрович", 45), 3, 3);
        System.out.println(school1);

        school1.oneDayInSchool(); // из условий задачи поняла, что школа может работать без учителей и учиников


        School school2 = new School("№36", new Director("Сергей Иванович", 40), 3, 3);
        System.out.println(school2);

        Director director3 =new Director("Роман Сергеевич", 36);
        director3.setAge(37);
        school2.setDirector(director3);

        school2.addTeaher(new Teacher("Тамара Романовна", 25, "Русский язык",20));
        school2.addTeaher(new Teacher("Екатерина Сергеевна", 35, "Математика",25));
        school2.addTeaher(new Teacher("Александр Романович", 27, "Физика", 30));
        school2.addStudent(new Student("Тамара", 12, "Русский язык"));
        school2.addStudent(new Student("Сергей", 13, "Математика", 5));
        Student student3 = new Student("Александр", 17, "Физкультура");

        student3.setKnowledgeLevel(10);
        System.out.println(student3);
        school2.addStudent(student3);


        System.out.println(school2);
        school2.oneDayInSchool();
        System.out.println(school2);
    }
}
