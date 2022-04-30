package ru.itmo.lessons.exams.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


public class Fitness {
    private Ticket[] ticketsSwimpool = new Ticket[20];
    private Ticket[] ticketsGym = new Ticket[20];
    private Ticket[] ticketsGroup = new Ticket[20];


    public Fitness(){};

    public void closeFitness() {
        // я понимаю, что в данном случае одним циклом быстрее, но считаем, что в будущем массивы будут разной длинны
        Arrays.setAll(ticketsSwimpool, null);
        Arrays.setAll(ticketsGym, null);
        Arrays.setAll(ticketsGroup, null);
    }

    public void regAbonement(Area area, Ticket ticket) {
        if (area == null || ticket == null) throw new IllegalArgumentException("Некорректные аргументы функции regAbonement");

        if (LocalDate.now().isAfter(ticket.getDataClose())) {
            System.out.println("Абонемент просрочен");
            return;
        }

        if (area == Area.GROUP && ticketsGroup[ticketsGroup.length -1] != null
                || area == Area.GYM && ticketsGym[ticketsGym.length -1] != null
                || area == Area.SWIMPOOL && ticketsSwimpool[ticketsSwimpool.length - 1] != null) {
            System.out.println("В зоне нет свободных мест");
            return;
        }

        if (!findArea(area, ticket)) {
            System.out.println("Зона " + area + " не разрешена по абонементу!");
            return;
        }

        if (checkTicketsArray(ticket, ticketsGroup) || checkTicketsArray(ticket, ticketsGym)
                || checkTicketsArray(ticket, ticketsSwimpool)) {
            System.out.println("Абонемент уже зарегистрирован");
            return;
        }

        addTicket(area, ticket);
        regInformation(area, ticket);
    }

    // во внутренних методах, не делаю проверки на корректность аргументов, считаю, что проверка осуществляется в публичных методах
    // Найти зону в абонементе false - если не найдена
    private boolean findArea(Area area, Ticket ticket) {
        for (Area ar : ticket.getTicketType().getArea()) {
            if (ar == area) return true;
        }
        return false;
    }

    // Проверка на наличие абонемента в массиве false - если абонемента нет
    private boolean checkTicketsArray(Ticket ticket, Ticket[] tickets) {
        for (Ticket tick : tickets) {
            if (tick == null) break;
            if (tick.equals(ticket)) return true;
        }
        return false;
    }

    // Поиск массива для добавления абонемента
    private Ticket[] findTicketsArea (Area area) {

        if (area == Area.GROUP) return ticketsGroup;
        if (area == Area.SWIMPOOL) return ticketsSwimpool;
        if (area == Area.GYM) return ticketsGym;

        return null;

        /*
        Ticket[] tickets = null;
        if (area == Area.GROUP) tickets = ticketsGroup;
        if (area == Area.SWIMPOOL) tickets = ticketsSwimpool;
        if (area == Area.GYM) tickets = ticketsGym;

        return tickets;
        */

    }

    // Добавить абонемент
    private void addTicket(Area area, Ticket ticket){

        Ticket[] ticketsArr = findTicketsArea(area);
        if (ticketsArr == null) {
            System.out.println("По условиям задачи такого не может быть, " +
                    "но в данном фитнесс клубе нет указанной зоны занятий");
            return;
        }
        for (int i = 0; i < ticketsArr.length; i++) {
            if (ticketsArr [i] == null) {
                ticketsArr [i] = ticket;
                return;
            }
        }
    }

    public String getOwners(Area area){
        if (area == null) throw new IllegalArgumentException("Некорректные аргументы функции getOwners");

        StringBuilder str = new StringBuilder();

        Ticket[] ticketsArr = findTicketsArea(area);
        if (ticketsArr == null) {
            System.out.println("По условиям задачи такого не может быть, " +
                    "но в данном фитнесс клубе нет указанной зоны занятий");
            return null;
        }

        for(Ticket ticket : ticketsArr) {
            if (ticket == null) break;
            str.append(ticket.getOwner().fullName());
            str.append("; ");
        }
        return str.toString();
    }


    private void regInformation(Area area, Ticket ticket){
        String str = null;
        if (area == Area.GYM) str = "тренажерный зал";
        else if (area == Area.GROUP) str = "групповые занятия";
        else if (area == Area.SWIMPOOL) str = "бассейн";
        System.out.println(ticket.getOwner().fullName() + " " + str);
        System.out.println(LocalDate.now() + " " + LocalTime.now());
    }
}
