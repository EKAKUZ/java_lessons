package ru.itmo.lessons.exams.exam1;

import java.time.LocalDate;
import java.util.Objects;


public class Ticket {
    private final LocalDate dataCreate; // стоит ли делать final
    private final LocalDate dataClose;
    private TicketType ticketType;
    private Owner owner;

    public Ticket(TicketType ticketType, Owner owner) {
        if (owner == null) throw new IllegalArgumentException("У абонемента должен быть владелец");
        if (ticketType == null) throw new IllegalArgumentException("Укажите тип абонемента");
        dataCreate = LocalDate.now();
        dataClose = dataCreate.plusDays(ticketType.getPeriod());
        this.ticketType = ticketType;
        this.owner = owner;
    }

    public LocalDate getDataClose() {
        return dataClose;
    }

    public Owner getOwner() {return owner;}

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return dataCreate.equals(ticket.dataCreate) && dataClose.equals(ticket.dataClose) && ticketType == ticket.ticketType && owner.equals(ticket.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataCreate, dataClose, ticketType, owner);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "dataCreate=" + dataCreate +
                ", dataClose=" + dataClose +
                ", ticketType=" + ticketType +
                ", owner=" + owner +
                '}';
    }
}
