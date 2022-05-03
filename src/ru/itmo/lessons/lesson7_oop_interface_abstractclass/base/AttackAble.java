package ru.itmo.lessons.lesson7_oop_interface_abstractclass.base;

// нельзя создать экземпляры
// нет ни конструкторов, ни свойств
// интерфесы содержат методы без реализации 1 или несколько
// побольшей части интерфейсы для абстрактных методов
public interface AttackAble {
    // метод без реализации
    /* public можно не писать*/
    void attack(BattleUnit enemy);
    // метод с реализацией только default
    default void someVoid(){}
}
