package ru.itmo.lessons.lesson21_oop_patterns;

public class Application {
    public static void main(String[] args) {
        User user = new User(User.Level.LOW, "login1");
        User.Account account1 = user.new Account(20);

        User.Account account2 = new User(User.Level.HIGH, "login2")
                .new Account(200);

        System.out.println(account2.getUser());


        Student.Exam exam1 = new Student.Exam("физика");
        Student.Exam exam2 = new Student.Exam("алгебра");

        Student student1 = new Student("Иванов");

        exam1.setMark(5);
        student1.addExam(exam1);

        // анонимный класс, если нужно описать несколько методов,
        // если метод один использовать лямбда выражение
        // используется для обработки событий, например, нажатие кнопок
        SomeInterface object = new SomeInterface() {
            @Override
            public void void1() {
                System.out.println("void1");
            }

            @Override
            public void void2() {
                System.out.println("void2");
            }

            @Override
            public void void3() {
                System.out.println("void3");
            }
        };
        object.void1();
        object.void2();


    }
}
//--------------------структура патерна клонирование
interface  CloneAble{
    Object clon();
}
class A implements CloneAble{

    @Override
    public Object clon() {
        return null;
    }
}
class B implements CloneAble{

    @Override
    public Object clon() {
        return null;
    }
}
// так как все обьекты наследники Object,
// а в нем метод Clone уже реализован,
// достаточно переопределить метод
class С {
    @Override
    public С clone() {
        return null;
    }
}
//------------------Фабричный метод--------------------
