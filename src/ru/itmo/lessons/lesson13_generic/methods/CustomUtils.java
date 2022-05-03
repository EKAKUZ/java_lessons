package ru.itmo.lessons.lesson13_generic.methods;

public class CustomUtils {
    // типизироанные методы (generic methods)
    // примитивы и джинерики не совместимы
    //метод, который проверяет наличие элемента в массиве
    public static <T> boolean inArray (T[] arr, T element) {
        if (arr == null || element == null) {
            throw new IllegalArgumentException("arr и element" +
                    "не могут быть null");

        }
        for (T t : arr) {
            if (element.equals(t)) return true;
        }
        return false;
    }
    // если метод собирается принимать или возвращать разные типы данных
    // можно писать в формате <T,K>
    // но мы конкритезируем от кого наследуем тип, Т скомпилируется в Number, K в стринг
    // при вызове T может быть Number и потомком

    public static <T extends Number, K extends String>
    int compareHasCode(T first, K second){
        // first - методы намбер и его родителе
        //second - методы String и его родителей
        return Integer.compare(first.hashCode(), second.hashCode());

    }
}
