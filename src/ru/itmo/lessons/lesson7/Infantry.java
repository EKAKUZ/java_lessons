package ru.itmo.lessons.lesson7;

//import ru.itmo.lessons.lessons7.base.AttackAble;
//import ru.itmo.lessons.lessons7.base.Unit;
import ru.itmo.lessons.lesson7.base.BattleUnit;

public class Infantry extends BattleUnit{
    private int additionalAttack = 5;

    public Infantry(int healthScore, int attackScore){
        super(healthScore, attackScore); // вызов родительского конструктора
    }

    public void infantryVoid(){
        System.out.println("Метод Infantry");
    }
}
/*public class Infantry extends BattleUnit {

    private final int additionalAttack = 5;
    // final свойстыа нельзя изменить,
    // значение можно задать только при обьявлении
    // или через конструктор, но не в сеттерах

    public void infantryVoid() {
        System.out.println("Метод infantryVoid");
    }


    // переопределение метода родителя
    @Override // говорим что собираемся переопределить метод родителя, если ошиблись в переопределении сообщит
            // об ошибке переопределения на этапе компиляции
    public boolean runFromField() {
        // можно написать собственную реализацию, которая перекроет реализацию родительского метода
        // super - обращение к родительскому классу
        // если Unit выжил attackScore нменьшается на 3
        // если есть аргументы, нужно добавить аргументы и количество
        if (super.runFromField()) {
            attackScore -= 3;
            System.out.println("После бегства атака уменьшилась на 3");
            return true;
        }
        return false;

    }


    //реализация абстрактного метода
    @Override
    public void rest() {
        System.out.println("Пехотинец отдыхает");
        //plusHealth (1);
    }

    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive() ) enemy.minusHealth (attackScore);
        if (enemy.isAlive()) enemy.minusHealth (enemy.getAttackScore());
        if (this.isAlive()) this.plusHealth ((int) (Math.random() * additionalHealth));
    }
    //public void a (String name) {}
    //public void a (String name, String subject) {}
    //obj.a ("fff");
}*/
