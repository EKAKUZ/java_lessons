package ru.itmo.lessons.lesson17_stream;

import ru.itmo.lessons.lesson16_lambda_functionalinterface.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    ArrayList<Course> courses = new ArrayList<>(Course.getInstances(5));
    Map<String, List<Course>> map1 = courses.stream()
            .collect(Collectors.groupingBy(Course::getName)); //группировать по ключу мапы(имя курса), курсы в List

    Map<Integer, ArrayList<Course>> map2 = courses.stream()
            .collect(Collectors.groupingBy(Course::getDuration, Collectors.toCollection(ArrayList::new)));
    //групировать по ключу мапы(продолжительность курса), курсы в ArrayList

    Map<String, Long> map3 = courses.stream()
            .collect(Collectors.groupingBy(Course::getName, Collectors.counting()));
    //количество курсов по имени

    Map<String, Double> map4 = courses.stream()
            .collect(Collectors.groupingBy(Course::getName, Collectors.averagingDouble(Course::getPrice)));

    Map<String, Map<Integer, List<Course>>> map5 = courses.stream()
            .collect(Collectors.groupingBy(
                    Course::getName,
                    Collectors.groupingBy(Course::getDuration)
            ));


}
