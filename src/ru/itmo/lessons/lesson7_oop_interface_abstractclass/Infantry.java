package ru.itmo.lessons.lesson7_oop_interface_abstractclass;

//import ru.itmo.lessons.lessons7.base.AttackAble;
//import ru.itmo.lessons.lessons7.base.Unit;
import ru.itmo.lessons.lesson7_oop_interface_abstractclass.base.BattleUnit;

public final class Infantry extends BattleUnit{
    private final int additionalAttack = 5;
    private final int additionalHealth = 5;
    // final свойстыа нельзя изменить,
    // значение можно задать только при обьявлении
    // или через конструктор, но не в сеттерах


    public Infantry(int healthScore, int attackScore){
        super(healthScore, attackScore); // вызов родительского конструктора
    }

    public void infantryVoid(){
        System.out.println("Метод InfantryVoid");
    }


    // переопределение метода родителя
    @Override //-  анотация, говорим, что собираемся переопределить метод родителя, если ошиблись в переопределении сообщит
                // об ошибке переопределения на этапе компиляции
    public boolean runFromField() {
        // можно написать собственную реализацию, которая перекроет реализацию родительского метода
        // super - обращение к родительскому классу
        // если Unit выжил attackScore нменьшается на 3
        // если есть аргументы, нужно добавить аргументы и количество
        if (super.runFromField()) {
            attackScore -= 3;
            System.out.println("После бегства пехотинца атака уменьшилась на 3");
            return true;
        }
        return false;

    }


    //реализация абстрактного метода
    @Override
    public void rest() {
        System.out.println("Пехотинец отдыхает");
        plusHealth (1);
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive() ) enemy.minusHealth (attackScore);
        if (enemy.isAlive()) this.minusHealth (enemy.getAttackScore());
        if (this.isAlive()) enemy.minusHealth(additionalAttack);
    }
}


