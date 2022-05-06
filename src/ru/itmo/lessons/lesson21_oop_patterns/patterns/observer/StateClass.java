package ru.itmo.lessons.lesson21_oop_patterns.patterns.observer;

import java.util.ArrayList;
// класс за которым наблюдают слушатели
public class StateClass {
    // коллекция слушателей/наблюдателей
    private ArrayList<EventListener> eventListeners = new ArrayList<>();
    public void addListener(EventListener eventListener) {
        eventListeners.add(eventListener);
    }
    // метод добавления слушателей
    public void removeListener(EventListener eventListener) {
        eventListeners.remove(eventListener);
    }
    // метод удаления слушателей

    // вызов реакций у слушателей
    private void lowNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.greenEvent(code));
    }
    private void mediumNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.yellowEvent(code));
    }
    private void highNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.redEvent(code));
    }

    // метод реакции на изменение состояния
    public void changeState(String newValue) {
        if ("ok".equals(newValue)) lowNotify(1);
        if ("warn".equals(newValue)) mediumNotify(5);
        if ("error".equals(newValue)) highNotify(10);
    }
}