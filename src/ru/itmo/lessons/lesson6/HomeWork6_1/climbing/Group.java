package ru.itmo.lessons.lesson6.HomeWork6_1.climbing;

public class Group {
    public boolean active = true; // true - набор открыт
    public Climber[] climbers;
    public Mountain mountain;

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
        return;
    }
}
