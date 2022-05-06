package ru.itmo.lessons.lesson17_stream.hw.pupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>(Arrays.asList(
                new Pupil(1, "Женя", Pupil.Gender.MALE, LocalDate.now().minusYears(10)),
                new Pupil(2, "Олег", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(3, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Pupil(4, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(12)),
                new Pupil(5, "Алексей", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(6, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(9)),
                new Pupil(7, "Иван", Pupil.Gender.MALE, LocalDate.now().minusYears(17)),
                new Pupil(8, "Петр", Pupil.Gender.MALE, LocalDate.now().minusYears(5)),
                new Pupil(9, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Pupil(10, "Алена", Pupil.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Pupil(11, "Григорий", Pupil.Gender.MALE, LocalDate.now().minusYears(7)),
                new Pupil(12, "Ирина", Pupil.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        // TODO: Используя Stream API:
        //  1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> genderMap = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genderMap);
        //  2. Найти средний возраст учеников
        double averageAge = pupils.stream().collect(Collectors.averagingInt(pupil -> (int) ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now())));
        System.out.println("Средний возраст: " + averageAge);
        averageAge = pupils.stream().mapToInt(pupil -> (int) ChronoUnit.YEARS.between(pupil.getBirth(), LocalDate.now())).average().orElse(0);
        System.out.println("Средний возраст: " + averageAge);
        //  3. Найти самого младшего ученика
        Pupil youngPupil = pupils.stream().min((pupil1, pupil2) -> (int) ChronoUnit.DAYS.between(pupil1.getBirth(), pupil2.getBirth())).orElse(null);
        System.out.println(youngPupil);
        //  4. Найти самого старшего ученика
        System.out.println(pupils.stream().max((pupil1, pupil2) -> (int) ChronoUnit.DAYS.between(pupil1.getBirth(), pupil2.getBirth())).orElse(null));
        //  5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> yearMap = pupils.stream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear()));
        System.out.println(yearMap);
        //  6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        System.out.println("---------------");
        Map<String, LocalDate> map = pupils.stream()
                .collect(Collectors.toMap( //Hach -map
                        Pupil::getName, //ключи elem -> elem
                        Pupil::getBirth, // значение
                        (val1, val2) -> val1 // как формировать значения,
                        // если ключи одинаковые
//{Алена=2016-05-05, Алексей=2013-05-05, Олег=2015-05-05, Григорий=2015-05-05, Женя=2012-05-05, Петр=2013-05-05, Иван=2010-05-05, Ирина=2016-05-05}
                ));
        System.out.println(map);


        //  7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> pupilList = pupils.stream()
                .sorted((pupil1, pupil2) -> pupil2.getName().compareTo(pupil1.getName()))
                .sorted((pupil1, pupil2) -> (int) ChronoUnit.DAYS.between(pupil2.getBirth(), pupil1.getBirth()))
                .sorted((pupil1, pupil2) -> pupil1.getGender().compareTo(pupil2.getGender()))
                .toList();

        pupils.sort(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).thenComparing(Pupil::getName).reversed());
        System.out.println(pupilList);
        System.out.println(pupils);

        //  8. Вывести в консоль всех учеников в возрасте от N до M
        int n=10;
        int m=15;
        pupils.forEach(pupil -> {
            if (pupil.getBirth().getYear() <= m && pupil.getBirth().getYear() >= n)
                System.out.println(pupil);
            }
        );

        // 9. Собрать в список всех учиников с именем someName
        String someName = "Петр";
        List<Pupil> somePupil= pupils.stream().filter(pupil -> someName.equalsIgnoreCase(pupil.getName())).toList();
        System.out.println(somePupil);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол,
        // Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderAge = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender,
                Collectors.summingInt(pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear())
                ));
        System.out.println(genderAge);
    }
}