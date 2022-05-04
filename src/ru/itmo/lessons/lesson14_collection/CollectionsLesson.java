package ru.itmo.lessons.lesson14_collection;

import java.util.*;
//int - Integer, bool - Boolean, byte - Byte, long - Long, double - Double
// автоупаковка - переменной обертки присваивается значение примитива, не работает, если примитив не соответствует типу;
// автораспаковка
// автоупаковка и автораспаковка не работают с массивами
public class CollectionsLesson {
    public static void main(String[] args) {
        // 1. по многопоточности
        // 2. возможности хранить дублирующие элементы
        // 3. возможностью хранить элементы в порядке добавления
        // 4. возможностью хранения элементов в отсортированном виде

        System.out.println("ArrayList");
        // реализован на основе массива
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления

        Student student1 = new Student(1,"Maxim", 17);
        Student student2 = new Student(2,"Anna", 21);
        Student student3 = new Student(3,"Paul", 23);
        Student student4 = new Student(4,"Helen", 19);
        Student student5 = new Student(5,"Oleg", 18);


        ArrayList<Student> studentArrayList = new ArrayList<>(); //по умолчанию 10 коллекции - дженерики, нужно указывать тип
        studentArrayList = new ArrayList<>(30); //конструктор для определения емкости, емкость мб увеличена или уменьшена
        System.out.println(studentArrayList.size()); // size возвращает количество добавленных элементов
        System.out.println(studentArrayList.add(student1));
        studentArrayList.add(studentArrayList.size(), student2);
        studentArrayList.add(1, student3); // второй подвинулся
        // выход за предел массива по индексу как у массива
        System.out.println(studentArrayList);
        studentArrayList.add(null); // можно добавить null
        studentArrayList.trimToSize(); // сжимает емкость до количества элементов

        // получение по индексу
        System.out.println(studentArrayList.get(1)); // ссылка на обьект

        // удаление
        System.out.println(studentArrayList.remove(3)); // возвращает ссылку на удаленный обьект

        studentArrayList.remove(student1); //возвращает true или false - если не найдет
        // (для удаления использает метод equals)
        // удалит первого найденного
        studentArrayList.add(student1);
        System.out.println(studentArrayList);

        studentArrayList.add(student1);
        System.out.println("1 " + studentArrayList);

        Student[] students = {student1, student2};
        studentArrayList.removeAll(Arrays.asList(students));
        System.out.println("2 " + studentArrayList);

        studentArrayList.clear();
        studentArrayList.add(student2);
        studentArrayList.add(student1);
        studentArrayList.add(student3);
        studentArrayList.add(student4);
        System.out.println("3 " + studentArrayList);

        for (Student student : studentArrayList) {
            student.setName("Student: " + student.getName());
            // удаление элементов в цикле приведет к
            // ConcurrentModificationException
        }
        System.out.println("4 " + studentArrayList);

        Iterator<Student> iterator = studentArrayList.listIterator();
        while (iterator.hasNext()) { //пока есть следующий
            if (iterator.next().getAge() > 20) //возвращает ссылку на эелемент коллекции
                iterator.remove();
        }
        System.out.println("5 " + studentArrayList);
        LinkedList<Student> studentLinkedList1 = new LinkedList<>();
        // нельзя задать размер, внутри не массив
        // можно хранить null
        // можно хранить дублирующиеся элементы
        // порядок хранения элементов соответствует порядку добавления
        LinkedList<Student> studentLinkedList2 = new LinkedList<>(studentArrayList);
        studentLinkedList2.add(student1);
        studentLinkedList2.add(student2);
        studentLinkedList2.add(student3);
        //Node(student1) <-> Node(student2) <-> Node(student3) -> null
        System.out.println(studentLinkedList2);

        System.out.println("Set"); //множества
        // используются для хранения уникальных элементов
        // обязательно должн быть переопределен метод equals


        //HashSet
        // позволяет хранить null -  всегда будет на первом месте
        // порядок хранения отличается от порядка добавления
        // основан на hash таблице


        Student student11 = new Student(1,"Maxim", 17);
        Student student12 = new Student(2,"Anna", 21);
        Student student13 = new Student(3,"Paul", 23);
        Student student14 = new Student(4,"Paul", 23);

        HashSet<Student> studentHashSet = new HashSet<>();
        List<Student> list= Arrays.asList(student11, student12, student13, student14);
        studentHashSet = new HashSet<>(list);
        studentHashSet.add(student1);
        studentHashSet.remove(student13);
        double average = 0;
        for (Student student: studentHashSet) {
            average += student.getAge();
        }
        average /= studentHashSet.size();
        System.out.println(studentHashSet);
        System.out.println(average);

        //LinkedHashSet
        // порядок хранения не отличается от порядка добавления
        // медленнее, чем HashSet

        System.out.println("TreeSet");
        //1. хранит элементы в отсортированном виде
        //2. нельзя добавить null
        //3. основан на алгоритме красно-черного дерева

        //просто так нельзя добавить элементы в TreeSet
        //сначала нужно добавить правила сортировки
        // 1. класс должен реализовать compareTo интерфейс Comparable
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student3);
        treeSet1.add(student4);
        treeSet1.add(student5);
        System.out.println("TreeSet 1: " + treeSet1);

        Student student15 = new Student(2,"Paul", 21);
        Student student16 = new Student(3,"Paul", 23);

        // 2. написать компораторы - создать экземпляры класса Comparator
        Comparator<Student> studentComparator1 = new NameComparator();
        TreeSet<Student> treeSet2 = new TreeSet<>(studentComparator1);
        treeSet2.add(student15);
        treeSet2.add(student16);
        System.out.println("TreeSet 2: " + treeSet2);


        Comparator<Student> studentComparator2 = new NameComparator()
                .thenComparing(new AgeComparator());
        TreeSet<Student> treeSet3 = new TreeSet<>(studentComparator2);
        treeSet3.add(student15);
        treeSet3.add(student16);
        System.out.println("TreeSet 3: " + treeSet3);

    }
}
