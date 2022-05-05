package ru.itmo.lessons.lesson13_generic.wildcards;

import ru.itmo.lessons.lesson13_generic.types.PairContainer;

public class AnimalApp {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();


        PairContainer<Integer,Animal> container1 = new PairContainer<>(1, animal);
        PairContainer<Integer,Cat> container2 = new PairContainer<>(2, cat);
        PairContainer<Integer,Dog> container3 = new PairContainer<>(3, dog);

        AnimalApp.<Animal>copyValue(container1, container1);
        AnimalApp.<Animal>copyValue(container2, container1);
        AnimalApp.<Cat>copyValue(container2, container1);

    }

    public static <T> void copyValue(
        PairContainer<Integer, ? extends T> from,
        PairContainer<Integer, ? super T> to){
        /* предположим, что T - Animal
        * тогда ? extends T тип Animal и его потомки Cat и Dog
        * ? super T - тип Animal и все его предки, т.е. Object*/
        to.setValue(from.getValue());
    }
}
