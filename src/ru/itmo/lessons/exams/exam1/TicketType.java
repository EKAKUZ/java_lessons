package ru.itmo.lessons.exams.exam1;

import java.time.LocalTime;
import static ru.itmo.lessons.exams.exam1.Area.*;

public enum TicketType {
    ONEDAY(new Area[]{SWIMPOOL, GYM}, LocalTime.parse("08:00:00"), LocalTime.parse("22:00:00"), 1),
    WORKDAY(new Area[]{SWIMPOOL, GYM}, LocalTime.parse("08:00:00"), LocalTime.parse("16:00:00"), 30),
    YEAR(new Area[]{SWIMPOOL, GYM, GROUP}, LocalTime.parse("08:00:00"), LocalTime.parse("22:00:00"), 365);

    private Area areas[];
    private LocalTime startTime;
    private LocalTime endTime;
    private int period;

    TicketType(Area[] areas, LocalTime startTime, LocalTime endTime, int period) {
        this.areas = areas;
        this.startTime = startTime;
        this.endTime = endTime;
        this.period = period;
    }

    public void setPeriod(int period) {
        if (this.period == 1) {
            System.out.println("Для разовых абонементов, срок действия изменить нельзя");
            return;
        }
        if (period<2) {
            System.out.println("Период длительности не разовых абонементов - больше одного дня");
            return;
        }
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public Area[] getArea(){
        return areas;
    }

}
