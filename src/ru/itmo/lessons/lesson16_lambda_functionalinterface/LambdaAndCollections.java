package ru.itmo.lessons.lesson16_lambda_functionalinterface;


import ru.itmo.lessons.lesson16_lambda_functionalinterface.education.Course;
import ru.itmo.lessons.lesson16_lambda_functionalinterface.education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaAndCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        //перебрать коллекцию методом foreach
        // список курсов к нему .forEach - дефолтный метод интерфейся Iterable
        // (принимает обьект класса(интерфейса) Consumer,
        // который принимает переменную типа T и ничего не возвращает)
        Consumer<Course> soutCourse = course -> System.out.println(course);
        university.getCourses().forEach(soutCourse);
        System.out.println("------------------------------");
        university.getCourses().forEach(course -> System.out.println(course));
        System.out.println("------------------------------");
        university.getCourses().forEach(System.out::println);//:: - ссылка на метод
        System.out.println("------------------------------");
        // ::имяМетода - ссылка на метод имяМетода,
        // только если пытаемся вывести элемент коллекции целиком
        //println принимает на вход аргумент и ничего не возвращает,
        // как метод accept функционального интерфейса Consumer
        // TODO:: увеличить стоимость каждого курса на 10%
        university.getCourses().forEach(course -> course.setPrice(course.getPrice() * 1.1) );

        // TODO:: вывести названия каждого курса
        university.getCourses().forEach(course -> System.out.println(course.getName()) );
        System.out.println();
        System.out.println("------------------------------");

        // TODO:: удалить из коллекции курсы, если их стоимость меньше 15000
        // removeIf принимает на вход Predicate,
        // значит нужно написать реализацию метода test интерфейса Predicate
        university.getCourses().removeIf(course -> course.getPrice() < 15000);

        // TODO:: написать реализацию метода getFilteredCourses, который принимает на вход Predicate<Course>
        //  и возвращает список отфильтрованных данным предикатом курсов университета


        // TODO::написать предикаты, которые возвращают true, если:
        //  1) курс дешевле 20000
        Predicate<Course> lessPrice = course -> course.getPrice() < 20000;
        //  2) продолжительность курса 3 месяца или меньше
        Predicate<Course> lessDuration = course -> course.getDuration() <= 3;
        //  3) название курса JJD
        Predicate<Course> jjd = course -> course.getName().equalsIgnoreCase("JJD");

        // TODO:: Отфильтровать
        //  1) дешевле 20000
        List<Course> filtred1 = university.getFilteredCourses(lessPrice);
        filtred1.forEach(System.out::println);
        System.out.println("------------------------------");
        //  2) дешевле 20000 и меньше 3х месяцев
        List<Course> filtred2 = university.getFilteredCourses(lessPrice.and(lessDuration));
        filtred2.forEach(System.out::println);
        System.out.println("------------------------------");
        //  3) JJD или дешевле 20000
        List<Course> filtred3 =university.getFilteredCourses(jjd.or(lessPrice));
        filtred3.forEach(System.out::println);
        System.out.println("------------------------------");


        Comparator<Course> byName = (course1, course2) -> course1.getName().compareTo(course2.getName()) ;
        university.getCourses().sort(byName);
        System.out.println(university.getCourses());
        System.out.println("------------------------------");
        Comparator<Course> byDuration = (course1, course2) -> course1.getDuration() - course2.getDuration() ;
        university.getCourses().sort(byDuration);
        university.getCourses().forEach(System.out::println);
        System.out.println("------------------------------");
        university.getCourses().sort(byName.thenComparing(byDuration));
        university.getCourses().forEach(System.out::println);
    }
}