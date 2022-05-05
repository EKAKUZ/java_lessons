package ru.itmo.lessons.lesson15_maps;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // в мапах храняться данные в парах ключ - значение
        // можно добавлять, заменять и удалять данные в связке ключ значение
        // наиболее популярны HashMap<K,V>, TreeMap<K,V>, EnumMap<K,V>, LinkedHasMap<K,V>

        //особенности HashMap
        //1. хранит ключи в hash таблице (на основе hash кода)
        //2. для ключей должны быть переопределены методы  equals и hashCode
        //3. обладает хорошей производительностью
        //4. для ключа можно использовать null
        //5. порядок хранения элементов может отличаться от порядка добавления

        //создание HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();

        //добавление элементов
        hashMap.put("Москва",790);
        hashMap.put("Ростов",270);
        hashMap.put("Великий Новгород",75);
        hashMap.put("Тверь",12);
        hashMap.put(null,null);
        System.out.println(hashMap);

        //удаление пары
        hashMap.remove(null); // удалиться - возвращает true/false
        hashMap.remove("Москва", 5); // не удалиться
        hashMap.remove("Ростов",270); // удалиться
        System.out.println(hashMap);

        //замена элемента
        hashMap.replace("Великий Новгород", 100); //по ключу
        hashMap.replace("Тверь", 12, 22); //по ключу
        System.out.println(hashMap);

        //получение
        System.out.println(hashMap.get("Тверь"));
        System.out.println(hashMap.getOrDefault("Тверь", 0));
        System.out.println(hashMap.getOrDefault("Санкт-Петербург", 0));
        //возвращает найденное значение или значение по умолчанию

        //проверяет наличие ключа
        System.out.println(hashMap.containsKey("Санкт-Петербург"));
        //проверяет наличие значения
        System.out.println(hashMap.containsValue(1000));

        System.out.println("------Перебор мап-------");
        for (Map.Entry<String,Integer> pair: hashMap.entrySet()) {
            //entrySet - получаем список пар, keySet тип данных Set, values() - тип данных Collection
            System.out.println("город(ключ): " + pair.getKey());
            System.out.println("количество покупателей(значение): " + pair.getValue());
        }



        User user1 = new User("login1","pwd1",Role.USER, 67);
        User user2 = new User("login2","pwd2",Role.USER, 55);
        User user3 = new User("login3","pwd3",Role.ADMIN, 67);
        User user4 = new User("login4","pwd4",Role.USER, 55);
        User user5 = new User("login5","pwd5",Role.USER, 13);
        User user6 = new User("login6","pwd6",Role.USER, 12);
        User user7 = new User("login7","pwd7",Role.ADMIN, 13);
        User user8 = new User("login8","pwd8",Role.USER, 14);

        HashMap<String, User> hashMap1 = new HashMap<>();
        hashMap1.put(user1.getLogin(),user1);
        hashMap1.put(user2.getLogin(),user2);
        hashMap1.put(user3.getLogin(),user3);
        hashMap1.put(user4.getLogin(),user4);
        hashMap1.put(user5.getLogin(),user5);
        hashMap1.put(user6.getLogin(),user6);
        hashMap1.put(user7.getLogin(),user7);
        hashMap1.put(user8.getLogin(),user8);



        //List<User> list = new ArrayList<>();
        //for (User user: hashMap1.values()) {
        //    if (user.getAge() > 20) {
        //        list.add(user);
        //    }
        //}
        //System.out.println(list );

        List<String> list = new ArrayList<>();
        for (Map.Entry<String,User> pair: hashMap1.entrySet()) {
            if (pair.getValue().getAge() > 20) {
                list.add(pair.getKey());
            }
        }
        System.out.println(list);


        for (User user: hashMap1.values()) {
            if (user.getRole() == Role.ADMIN) {
                System.out.println(user.getLogin() + " " + user.getPwd());
            }
        }

        HashMap<Integer, ArrayList<User>> hashMap2 = new HashMap<>();
        for (User user: hashMap1.values()){

            ArrayList<User> l = hashMap2.getOrDefault(user.getAge(), new ArrayList<>());
            l.add(user);
            hashMap2.put(user.getAge(),l);

            //if ( !hashMap2.containsKey(user.getAge())) {
            //    ArrayList<User> list2 = new ArrayList<>();
            //    list2.add(user);
            //    hashMap2.put( user.getAge(), list2);
            //}
            //else {
            //    hashMap2.get(user.getAge()).add(user);
            //}

        }

        System.out.println(hashMap2 );

        //LinkedHashMap - сохраняет порядок добавления элементов

        //EnumMap - перечисления (enum) в качестве ключей
        // ключи одного типа перечисления
        // null нельзя использовать в качестве ключа
        // парядок элементов соответствует порядку в перечислении
        //для извлечения значения используют индекс ключа vals[key.or...]

        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);

/*
        User user1 = new User("login1","pwd1",Role.USER, 67);
        User user2 = new User("login2","pwd2",Role.USER, 55);
        User user3 = new User("login3","pwd3",Role.ADMIN, 67);
        User user4 = new User("login4","pwd4",Role.USER, 55);
        User user5 = new User("login5","pwd5",Role.USER, 13);
        User user6 = new User("login6","pwd6",Role.USER, 12);
        User user7 = new User("login7","pwd7",Role.ADMIN, 13);
        User user8 = new User("login8","pwd8",Role.USER, 14);

 */
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user1, user2, user4, user5, user6,user8));
        ArrayList<User> admins = new ArrayList<>(Arrays.asList(user3, user7));
        enumMap.put(Role.ADMIN, admins);
        enumMap.put(Role.USER, users);

        for (User user: enumMap.get(Role.USER)) {
            System.out.println(user.getLogin());
        }

        User user9 = new User("login9","pwd9",Role.USER, 14);

        enumMap.get(user9.getRole()).add(user9);
        System.out.println(enumMap);

        // TreeMap -хранит данные в отсортированном по ключам порядке
        // основан на алгортме красно-черного дерева
        // null - нельзя использовать в качестве значений
        // должен быть интерфей Comparable или в конструктор мапы необходимо передать Comparator
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);

    }
}