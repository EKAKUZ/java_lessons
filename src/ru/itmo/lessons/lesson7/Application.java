package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.base.Unit;

import java.util.Scanner;

// extends, super
// переопределение @Override - переопрелеляется метод от родителя
// final - класс не будет иметь насследников, final - метод нельзя переопределить,
// final - свойства нельзя переопределить, задать можно при определении или в конструкторе
public class Application {
    public static void main(String[] args) {
        Knight knight1 = new Knight(20, 17);
        knight1.knightVoid();
        knight1.battleUnitVoid();
        knight1.unitVoid();

        BattleUnit knight2 = new Knight(20, 17);
        knight2.battleUnitVoid();
        knight2.unitVoid();

        Unit knight3 = new Knight(20, 17);
        knight3.unitVoid();

        ((Knight) knight3).knightVoid();
        ((Knight) knight3).battleUnitVoid();
        ((Knight) knight3).unitVoid();

        knight1.runFromField();
        Infantry infantry1 = new Infantry(18, 15);
        infantry1.runFromField();

        Scanner in = new Scanner(System.in);
        System.out.println("Укажите тип персонажа");
        String type = in.nextLine();

        // полиморфизм наследования
        Unit unit = null;
        if (type.equalsIgnoreCase("Knight") ) {
            unit = new Knight(23, 56);
        }   else if (type.equalsIgnoreCase("infanty") ) {
            unit = new Knight(20, 50);
        }   else if (type.equalsIgnoreCase("King") ) {
            unit = new Knight(100, 200);
        }
        unit.rest();

        System.out.println("Укажите тип боевого персонажа");
        String btype = in.nextLine();

        // полиморфизм наследования
        BattleUnit battleUnit = null;
        if (btype.equalsIgnoreCase("Knight") ) {
            battleUnit = new Knight(23, 56);
        }   else   {
            battleUnit = new Knight(23, 56);
        }
        battleUnit.attack(knight1);


            // static - принято делать обслуживающие методы, как в классе Math
            // или методы задача которых вызывать экземпляры класса (методы в которых вызывается конструктор)
            // для обращения к методу не нужно создавать экземпляр Math.random (имя класса . метод)
            // статические методы - не являются возможностями обьекта

    }

}
