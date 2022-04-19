package ru.itmo.lessons.exams.exam1;

import java.time.LocalDate;
import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Первый", "Пользователь", 1981);
        Owner owner2 = new Owner("Второй", "Пользователь", 1982);
        Owner owner3 = new Owner("Третий", "Пользователь", 1983);
        Owner owner4 = new Owner("Четвертый", "Пользователь", 1984);
        Owner owner5 = new Owner("Пятый", "Пользователь", 1985);
        Owner owner6 = new Owner("Шестой", "Пользователь", 1986);
        Owner owner7 = new Owner("Седьмой", "Пользователь", 1987);
        Owner owner8 = new Owner("Восьмой", "Пользователь", 1988);
        Owner owner9 = new Owner("Девятый", "Пользователь", 1989);

        Ticket ticket1 = new Ticket(TicketType.YEAR, owner1);
        Ticket ticket2 = new Ticket(TicketType.YEAR, owner2);
        Ticket ticket3 = new Ticket(TicketType.YEAR, owner3);
        Ticket ticket4 = new Ticket(TicketType.ONEDAY, owner4);
        Ticket ticket5 = new Ticket(TicketType.ONEDAY, owner5);
        Ticket ticket6 = new Ticket(TicketType.ONEDAY, owner6);
        Ticket ticket7 = new Ticket(TicketType.WORKDAY, owner7);
        Ticket ticket8 = new Ticket(TicketType.WORKDAY, owner8);
        Ticket ticket9 = new Ticket(TicketType.WORKDAY, owner9);

        Fitness fitness = new Fitness();

        fitness.regAbonement(Area.SWIMPOOL, ticket1);
        fitness.regAbonement(Area.GYM, ticket2);
        fitness.regAbonement(Area.GROUP, ticket3);
        fitness.regAbonement(Area.SWIMPOOL, ticket4);
        fitness.regAbonement(Area.GYM, ticket5);
        fitness.regAbonement(Area.GROUP, ticket6);
        fitness.regAbonement(Area.SWIMPOOL, ticket7);
        fitness.regAbonement(Area.GYM, ticket8);
        fitness.regAbonement(Area.GROUP, ticket9);

        fitness.regAbonement(Area.GROUP, ticket1);
        fitness.regAbonement(Area.SWIMPOOL, ticket9);


        System.out.println(fitness.getOwners(Area.SWIMPOOL));
        System.out.println(fitness.getOwners(Area.GROUP));
        System.out.println(fitness.getOwners(Area.GYM));

    }
}
