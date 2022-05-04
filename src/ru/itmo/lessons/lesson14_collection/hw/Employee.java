package ru.itmo.lessons.lesson14_collection.hw;// Создать список объектов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;


    public Employee(String name, String company, int salary, int age, int minSalary, int maxSalary, int minAge, int maxAge){
        if (name == null || company == null || salary < minSalary && salary > maxSalary || age < minAge && age > maxAge) {
            System.out.println("Сотрудник с указанными характеристиками Имя: " + name + ", компания: " + company +
                    ", зарплата: " + salary + ", возраст: " + age + " не может быть создан!");
            return;
        }
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

     public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    // TODO: конструктор, геттеры и сеттеры

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        int minSalary = 40;
        int maxSalary = 300;
        int minAge = 18;
        int maxAge = 65;

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
            employees.add(new Employee(names[(int)(Math.random() * names.length)],
                    companies[(int)(Math.random() * companies.length)],
                    (int)(minSalary + Math.random() * (maxSalary - minSalary)),
                    (int)(minAge + Math.random() * (maxAge - minAge)),
                    minSalary, maxSalary, minAge, maxAge));
        }
        return employees;
    }

}
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.getName().compareTo(o2.getName());
    }
}

class CompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.getCompany().compareTo(o2.getCompany());
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

