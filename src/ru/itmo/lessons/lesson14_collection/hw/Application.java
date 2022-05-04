package ru.itmo.lessons.lesson14_collection.hw;

import ru.itmo.lessons.lesson14_collection.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Application {
    public static void main(String[] args) {
        Comparator<Employee> employeeComparatorName = new NameComparator();
        Comparator<Employee> employeeComparatorNameSalary = new NameComparator().thenComparing(new SalaryComparator());
        Comparator<Employee> employeeComparatorNameSalaryAgeCompany = new NameComparator()
                .thenComparing(new SalaryComparator())
                        .thenComparing(new AgeComparator())
                                .thenComparing(new CompanyComparator());

        List<Employee> employeeList = new ArrayList<>(Employee.employeeGenerator(20));
        System.out.println(employeeList);

        TreeSet<Employee> treeSet1 = new TreeSet<>(employeeComparatorName);
        treeSet1.addAll(employeeList);
        System.out.println("SortName: " + treeSet1);

        TreeSet<Employee> treeSet2 = new TreeSet<>(employeeComparatorNameSalary);
        treeSet2.addAll(employeeList);
        System.out.println("SortNameSalary: " + treeSet2);

        TreeSet<Employee> treeSet3 = new TreeSet<>(employeeComparatorNameSalaryAgeCompany);
        treeSet3.addAll(employeeList);
        System.out.println("SortNameSalaryAgeCompany: " + treeSet3);

    }
}
