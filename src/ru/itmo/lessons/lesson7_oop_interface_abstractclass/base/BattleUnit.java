package ru.itmo.lessons.lesson7_oop_interface_abstractclass.base;
//abstract - не можем создать обьект на основе этого класса  и можем разместить в нем абстрактные методы
//import ru.itmo.lessons.lessons7.Infantry;
//import ru.itmo.lessons.lessons7.Knight;
//import ru.itmo.lessons.lessons7.base.Unit;

//Unit - родительский класс (супер класс)
//BattleUnit  - наследник класса

import ru.itmo.lessons.lesson7_oop_interface_abstractclass.Infantry;
import ru.itmo.lessons.lesson7_oop_interface_abstractclass.Knight;

public abstract class BattleUnit extends Unit implements AttackAble {
    protected int attackScore;
    public BattleUnit(int healthScore, int attackScore) {
        super(healthScore); // если в родительском классе есть конструктор, он обязательно дб в дочернем
        if (attackScore < 1) throw new IllegalArgumentException("Атака должна быть положительным");
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public final void battleUnitVoid(){
        System.out.println("Метод BattleUnit");
    }

    public boolean runFromField(){
        if (!isAlive()) {
            System.out.println("Юнит умер");
            return false;
        }
        minusHealth(1); // так или с минусом?
        if (!isAlive()) {
            System.out.println("Юнит не смог сбежать с поля боя");
            return false;
        }
        System.out.println("Юнит сбежал с поля боя");
        return true;
        //при бегстве Unit теряет 1 ед здоровья
    }


    public static BattleUnit getBattleUnit() {
        String [] types = {"knight", "infantry"};
        BattleUnit unit  = null;
        switch ( (types[(int)(Math.random() * types.length)])) {
            case "knight":
                unit = new Knight(30,18);
                break;
            case "infantry":
                unit = new Infantry(35,20);
                break;
        }
        return unit;
    }

    public static BattleUnit[] getBattleUnits (int count) {
        BattleUnit[] units = new BattleUnit[count];

        for (int i = 0; i < units.length; i++) {
            // в статических методах можно обратиться
            // только к статическим методам или свойствам класса
            units[i] = getBattleUnit();
            }
        return units;
    }
    //iter для генерации foreach

}
