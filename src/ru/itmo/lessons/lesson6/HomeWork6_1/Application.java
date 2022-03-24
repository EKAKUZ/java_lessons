package ru.itmo.lessons.lesson6.HomeWork6_1;

import ru.itmo.lessons.lesson6.HomeWork6_1.climbing.Climber;
import ru.itmo.lessons.lesson6.HomeWork6_1.climbing.Group;
import ru.itmo.lessons.lesson6.HomeWork6_1.climbing.Mountain;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Climber climber1 = new Climber();
        climber1.setName("Иван");
        climber1.setAddr("Cанкт-Петербург");
        System.out.println(climber1.getName() + " " + climber1.getAddr());

        Climber climber2 = new Climber("Сергей", "Нижний Новгород");
        System.out.println(climber2.getName() + " " + climber2.getAddr());

        Mountain[] mounts = new Mountain[5];
        mounts[0]= new Mountain("Эльбрус", "Россия", 5000.0);
       // System.out.println(mounts[0].getName() + " " + mounts[0].getCountry() + " " + mounts[0].getHeight());

        mounts[1] = new Mountain("Эверест", "Непал", 8000.0);
        mounts[2] = new Mountain("Эверест", "Непал", 8000.0);
        mounts[3] = new Mountain("Эльбрус", "Россия", 5000.0);
        mounts[4] = new Mountain("Казбек", "Грузия", 4500.0);

        // заполнение групп восхождения на различные горы
        Group[] groups = new Group[3];
        for (Mountain mount : mounts) { //1 2 2 1 3
            for (int i = 0; i < groups.length; i++) { // null null null
                if (groups[i] != null && mount.getName().equalsIgnoreCase(groups[i].mountain.getName())) {
                    break;
                }
                if (groups[i]  == null) {
                    groups[i] = new Group();
                    groups[i].mountain = mount;
                    break;
                }
            }
        }
        for(Group group: groups) {
            System.out.println(group.mountain.getName() + " " + group.mountain.getCountry() + " " + group.mountain.getHeight());
        }

        String str;
        Climber[] climbmas = new Climber[7];
        Scanner scanner = new Scanner(System.in);

        // заполняем массив альпинистов из 7 человек (3+2+2) вводом с клавиатуры
        for (int i = 0; i < climbmas.length; i +=1 ) {
            if (climbmas[i] == null) {
                System.out.println("Введите имя альпиниста " + (i + 1));
                str = scanner.nextLine();
                //if (str.equalsIgnoreCase("exit")) break;
                if (str.length() > 2) {
                    climbmas[i] = new Climber();
                    climbmas[i].setName(str);
                } else {
                    System.out.println("Некорректное имя альпиниста " + (i + 1));
                }
            }
            if (climbmas[i]  != null && climbmas[i].getAddr() == null) {
                System.out.println("Введите адрес альпиниста " + (i + 1));
                str = scanner.nextLine();
                //if (str.equalsIgnoreCase("exit")) break;
                if (str.length() > 4) {
                    climbmas[i].setAddr(str);
                } else {
                    System.out.println("Некорректный адрес альпиниста " + (i + 1));
                }
            }
            if (climbmas[i]  == null || climbmas[i].getAddr() == null) i -= 1;
        }

        // заполняем группы альпинистами
        for (int i = 0; i < groups.length; i++) {
            groups[i].climbers = new Climber[3];
        }
        for (int j = 0; j < climbmas.length; j += 3) {
            for (int i = 0; i < groups.length; i += 1) {
                if (climbmas.length  > j + i) {
                    if (groups[i].active) {
                        groups[i].addClimber(climbmas[i + j]);
                    } else System.out.println("Набор в группу закрыт");

                }
            }
        }

        // результат
        for (Group gr: groups) {
            System.out.println("Набор в группу " + gr.active);
            System.out.println("На гору " + gr.mountain.getName() + ", " + gr.mountain.getCountry() + ", " + gr.mountain.getHeight());
            System.out.println("Альпинисты: ");
            for (Climber climb: gr.climbers) {
                if (climb != null) System.out.println(climb.getName() + " " + climb.getAddr());
            }
        }

    }

}
