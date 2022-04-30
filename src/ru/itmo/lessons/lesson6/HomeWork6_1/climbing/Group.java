package ru.itmo.lessons.lesson6.HomeWork6_1.climbing;

import ru.itmo.lessons.lesson6.HomeWork6_2.Foods.Food;

public class Group {
    private boolean active = true; // true - набор открыт - без доступа из вне
    private Climber[] climbers;
    public Mountain mountain;

    public void countClimber(int count) {
        climbers = new Climber[count];
    }

    public boolean isActive() {
        return active;
    }

    public String printClimberName() {
        StringBuilder sb = new StringBuilder();
        for (Climber climb: climbers) {
            if (climb != null) sb.append(" ").append(climb.getName()).append(" ").append(climb.getAddr());
        }
        return sb.toString();
    }

    public void addClimber(Climber climber) {
        if (!active) throw new IllegalArgumentException("Набор в группу закрыт");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = new Climber();
                climbers[i] = climber;
                if (climbers[climbers.length - 1] != null) active = false;
                return;
            }
        }
    }
}
