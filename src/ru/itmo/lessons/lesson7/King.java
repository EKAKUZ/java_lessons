package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.base.Unit;
//import ru.itmo.lessons.lessons7.base.BattleUnit;

// extends  - наследование класса
public final class King extends Unit{
    private int gold = 500;
    private BattleUnit[] army;

    public King(int healthScore) {
        super(healthScore);
    }

    public int plusGold (int count) {
        if (count < 1) throw new IllegalArgumentException("Увеличить золото короля можно только на положительное число");
        return gold + count;
    }

    public int minusGold (int count) {
        if (count < 1) throw new IllegalArgumentException("Уменьшить золото короля можно только на положительное число");
        if (gold < count) return gold;
        else return gold - count;
    }

    public void generateArmy (int countBattleUnit) {
        if (countBattleUnit < 4 ) throw new IllegalArgumentException("Армия должна состоять хотя бы из 4х BattleUnit");
        if (gold < 250) {
            System.out.println("Стоимость армии 250. У короля " + gold);
            return;
        }
        gold -= 250;

        army = BattleUnit.getBattleUnits(countBattleUnit);
        /*for (int i = 0; i < army.length; i +=1) {
            army[i] = BattleUnit.getBattleUnit();
        }*/

        /*if (countBattleUnit < 4 ) throw new IllegalArgumentException("Армия должна состоять хотя бы из 4х BattleUnit");
        if (gold < 250) {
            System.out.println("Стоимость армии 250. У короля " + gold);
            return;
        }
        army = new BattleUnit[countBattleUnit];
        for (int i = 0; i < 3; i +=1) {
            army[i] = new Knight((int)(Math.random()*41 + 10), (int)(Math.random()*14 + 7) );
        }
        for (int i = 3; i < countBattleUnit; i += 1)
        {
            army[i] = new Infantry((int)(Math.random()*41 + 10), (int)(Math.random()*14 + 7) );
        }
        gold -= 250;*/
    }


    public void changeUnits() {
        if (gold < 20) {
            System.out.println("Стоимость юнита 20. У короля " + gold);
            return;
        }
        for (int i=0; i < army.length; i += 1) {
            if (gold > 20) {
                gold -= 20;
                if (army[i] != null && !army[i].isAlive()) army[i] = BattleUnit.getBattleUnit();
            }
        }
        /*
        for (int i=0; i < army.length; i += 1) {
            if (gold > 20) {
                if (army[i] != null && !army[i].isAlive()) army[i] = new Knight((int)(Math.random()*41 + 10), (int)(Math.random()*14 + 7) );
                gold -= 20;
            }
        }*/
    }
    public void startBattle(King enemy){
        for (int i = 0; i < army.length; i++) {
            int unitIndex = (int)(Math.random() * army.length);
            int enemyUnitIndex = (int)(Math.random() * enemy.army.length);
            army[unitIndex].attack(enemy.army[enemyUnitIndex]);
            army[unitIndex].rest();
            enemy.army[enemyUnitIndex].rest();
        }
    }


    public int getBattleUnitsCount(){
        int BattleUnitsCount = 0;
        for (int i=0; i < army.length; i += 1) {
            if (army[i].isAlive()) BattleUnitsCount += 1;
        }
        return BattleUnitsCount;
    }






    //реализация абстрактного метода
    @Override
    public void rest() {

        minusGold (50); // gold -=50;
        plusHealth (5);
        System.out.println("Король отдыхает");
    }

    /*public void startBattle (King enemy) {
        for (int i = 0; i < army.length; i++) {
            int unitIndex = (int) (Math.random() * army.length);
            int enemyUnitIndex = (int) (Math.random() * army.length);
            army[unitIndex].attack(enemy.army[enemyUnitIndex]);
            army[unitIndex].rest();
            enemy.army[enemyUnitIndex].rest();
        }
    }*/
}
