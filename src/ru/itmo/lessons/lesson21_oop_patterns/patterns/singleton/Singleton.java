package ru.itmo.lessons.lesson21_oop_patterns.patterns.singleton;

// ленивая (отложенная) инициализация
public class Singleton {
    // все необходимые методы и свойства

    private static Singleton instance; /* new Singleton()*/
    //- ссылка на единственный экземпляр этого класса

    // закрываем возможность создания объекта вне класса
    // - это для возможности создания только одного обьекта внутри класса
    private Singleton() {}

    public static Singleton getInstance(){
        if (instance == null) { // проверка был ли создан объект
            // создание объекта (если он не был создан ранее)
            instance = new Singleton();
        }
        return instance;
    }
}