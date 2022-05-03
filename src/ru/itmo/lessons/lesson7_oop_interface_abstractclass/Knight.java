package ru.itmo.lessons.lesson7_oop_interface_abstractclass;

//import ru.itmo.lessons.lessons7.base.AttackAble;
import ru.itmo.lessons.lesson7_oop_interface_abstractclass.base.BattleUnit;
//  import ru.itmo.lessons.lessons7.base.Unit;

public final class Knight extends BattleUnit   {
    private final int addtionalHealth = 10;
    private final int additionalHealth = 5;

    public Knight(int healthScore, int attackScore){
        super(healthScore, attackScore); // вызов родительского конструктора
    }

    public void knightVoid(){
        System.out.println("Метод Knight");
    }

    //реализация абстрактного метода
    @Override
    public void rest() {
        System.out.println("Рыцарь отдыхает");
        plusHealth (3);
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive() ) enemy.minusHealth (attackScore);
        if (enemy.isAlive()) this.minusHealth (enemy.getAttackScore());
        if (this.isAlive()) this.plusHealth ((int) (Math.random() * additionalHealth));
    }
}
// final - запрещает наследование
//  implements - класс реализует/ имплеминтирует какой - то интервейс или интерфейсы
// обязан реализовать все методы интерфейса

