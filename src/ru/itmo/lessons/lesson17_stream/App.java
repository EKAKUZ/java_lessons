package ru.itmo.lessons.lesson17_stream;

import ru.itmo.lessons.lesson16_lambda_functionalinterface.education.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        //обект типа Stream
        Stream<Integer> integerStream = Stream.of(-560, 312, 12, -1, 45, 0 , 0, 23, -2, 221);
        //промежуточные операции со stream, не выполняются, если нет конечной операции
        integerStream.filter(  num -> num < 0)
                .limit(5)
                .map(num -> num * num)
                .forEach(System.out::println); //num -> System.out.println (num)
        //после вызова терминальной операции работать с потоком нельзя


        Stream<Integer> integerStream2 = Stream.of(-6, 45, 12, -77, 77, 45 , 6, -6, 0, 0, 0, 12);
        integerStream2.distinct()
                .sorted()
                .forEach(System.out::println); //num -> System.out.println (num)
        System.out.println("-------------------------");
        Stream<Integer> integerStream3 = Stream.of(411, 7, 90, -1000, 0, 2 , 71);
        System.out.println(integerStream3.anyMatch(num -> num==0)); // хотя бы один - true
        integerStream3 = Stream.of(411, 7, 90, -1000, 0, 2 , 71);
        System.out.println(integerStream3.allMatch(num -> num > 0)); // true - если все
        integerStream3 = Stream.of(411, 7, 90, -1000, 0, 2 , 71);
        System.out.println(integerStream3.noneMatch(num -> num > 10_000));
        // true - если никто не удовлетворяет условию

        System.out.println("-------------------------");
        String[] colors = {"white", "black", "red", "yellow", "yellowgreen"};
        String color1 = Arrays.stream(colors).findFirst().get();
        // findfirst возвращает экземпляр типа Option<T> - null safe container
        System.out.println(color1);
        String color2 = Arrays.stream(colors).findAny().orElse("brown");
        System.out.println(color2);
        boolean isPresent = Arrays.stream(colors).findFirst().isPresent();

        Arrays.stream(colors)
                .skip(2)
                .filter(color -> color.startsWith("y"))
                .forEach(System.out::println);

        List<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        Course minByPrice = courses.stream()
                .min((course1, course2) -> (int) (course1.getPrice()- course2.getPrice()))
                .orElse(Course.getInstance());
        System.out.println(minByPrice);

        Course maxByDuration = courses.stream()
                .max(Comparator.comparing(Course::getDuration))
                //в метод Comparing  передаем ссылку на метод по которому будем сравнивать
                .orElse(Course.getInstance());
        System.out.println(maxByDuration);

        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                //.toArray() создаст массив типа обжект
                .toArray(Course[]::new); // ссылка на консруктор массива заданного типа
                //.toArray() - создаст массив типа Object

        //peek - заменяет значение элемента в потоке, а map - заменяет элемент в потоке на новый
        List<Course> courses2 = courses.stream()
                .filter(course -> course.getDuration() > 3)
                .peek( course -> course.setPrice(course.getPrice() + 5000))
                .collect(Collectors.toList()); //.toList(); List<Course>
                //.collect(Collectors.toSet());  - множество Set<Course>
                //.collect(Collectors.toCollection(ArrayList::new));
                // - ArrayList<Course> - какая-то конкретная коллекция


        //мапа
        Map<String, Integer> map = Arrays.stream(colors)
                .collect(Collectors.toMap( //Hach -map
                        Function.identity(), //ключи elem -> elem
                        elem -> elem.length(), // значение
                        (elem1, elem2) -> elem1 // как формировать значения,
                        // если ключи одинаковые

                ));
        System.out.println(map);



        //map - flatMap
        String[][] strings = {
                {"45", "78", "-90", "0", "1", "1"},
                {"441", "14", "14", "28"},
                {"122", "-6", "10", "50"}
        };

        String [][] strings1 = Arrays.stream(strings)
                .map(elem -> Arrays.stream(elem)
                        .distinct()
                        .sorted()
                        .toArray(String[]::new))
                .toArray(String[][]::new);
        System.out.println(Arrays.deepToString(strings1));

        String [] strings2 = Arrays.stream(strings)
                .flatMap(elem -> Arrays.stream(elem)) //элемента вложенного потка в общий поток
                        .distinct()
                        .sorted()
                        .toArray(String[]::new);
        System.out.println(Arrays.toString(strings2));

    }
}
