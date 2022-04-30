package ru.itmo.lessons.lesson7.base;

public abstract class Unit {
    protected int healthScore; // Доступ осуществляется из текущего класса или дочерних классов
    private int maxHealthScore;
    // абстратный метод - метод без реализации {без {})
    // может быть только у абстрактного  класса
    // заставляет все не абстрактные классы описать метод
    public Unit(int healthScore) {
        if (healthScore < 1) {
            throw new IllegalArgumentException("Здоровье должно быть положительным");
        }
        this.healthScore = healthScore;
        this.maxHealthScore = healthScore;
    }

    public void plusHealth(int healthScore) {
        if (!isAlive()) return;
        this.healthScore = Math.min(this.healthScore + healthScore, maxHealthScore);
    }

    public void minusHealth(int healthScore) {
        if (!isAlive()) return;
        this.healthScore -=healthScore;
    }

    public boolean isAlive() {
        return healthScore > 0;
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void unitVoid(){
        System.out.println("Метод Unit");
    }

    public abstract void rest();
}
