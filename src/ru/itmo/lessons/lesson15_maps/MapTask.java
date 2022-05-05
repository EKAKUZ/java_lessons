package ru.itmo.lessons.lesson15_maps;

import java.util.*;

public class MapTask {
    public static ArrayList<String> createListLogin(HashMap<String,String> firstTaskMap, String city){
        if (firstTaskMap ==null || city == null) throw new IllegalArgumentException();
        ArrayList<String> arrayListLogin = new ArrayList<>();
        for (Map.Entry<String, String> pair: firstTaskMap.entrySet()) {
            if (pair.getValue().equalsIgnoreCase(city)) {
                arrayListLogin.add(pair.getKey());
            }
        }
        return arrayListLogin;
    }
    public static HashMap<String, Integer> sameWordCount (List<String>  words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word)) hashMap.replace(word, hashMap.get(word) + 1);
            else hashMap.put(word, 1);
        }
        return hashMap;
    }
    public static HashMap<String, Customer> createMapFromTo (HashMap <String, Customer> customerMap, int from, int to){
        HashMap<String, Customer> createMapFromTo = new HashMap<>();
        for (Map.Entry<String, Customer> customerEntry : customerMap.entrySet()) {
            if (customerEntry.getValue().getAge() >= from && customerEntry.getValue().getAge() <= to) {
                createMapFromTo.put(customerEntry.getKey(), customerEntry.getValue());
            }
        }
        return createMapFromTo;
    }
    public static int wordCount (String text, String string) {
        if (text == null || string == null) {
            System.out.println("Некорректные параметры метода");
            return -1;
        }
        int count = 0;
        while (text.contains("  ")) {
            text = text.replaceAll("  ", " ");
        }
        String[] words = text.split(" ");
        for (String word : words) {
            if (word.equalsIgnoreCase(string)) count ++;
        }

        System.out.println(Arrays.toString(words));
    return count;
    }
    public static HashMap<Integer, List<String>> generateWordGroup (String text) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        if (text == null ) {
            System.out.println("Некорректные параметры метода");
            return hashMap;
        }
        while (text.contains("  ")) {
            text = text.replaceAll("  ", " ");
        }
        String[] words = text.split(" ");

        for (String word : words) {
            List<String> l = hashMap.getOrDefault(word.length(), new ArrayList<>());
            l.add(word);
            hashMap.put(word.length(), l);
        }
        return hashMap;
    }
    public static void topTenWord (String text) {

        if (text == null ) {
            System.out.println("Некорректные параметры метода");
            return;
        }
        while (text.contains("  ")) {
            text = text.replaceAll("  ", " ");
        }
        String[] words = text.split(" ");

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            int count = hashMap.getOrDefault(word, 0);
            count ++;
            hashMap.put(word, count);
        }
        System.out.println(hashMap);

        Comparator<Map.Entry<String,Integer>> Comparator1 = new CountComparator()
                .thenComparing(new WordComparator());
        TreeSet<Map.Entry<String,Integer>> treeSet2 = new TreeSet<>(Comparator1);

        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            if (treeSet2.size()< 10) treeSet2.add(pair);
            else {
                if (treeSet2.first().getValue()< pair.getValue()) {
                    treeSet2.remove(treeSet2.first());
                    treeSet2.add(pair);
                }
            }
        }
        System.out.println(treeSet2);

        for (Map.Entry<String, Integer> entry : treeSet2) {
            System.out.println(entry.getKey());
        }
    }


    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(createListLogin(firstTaskMap, city));


        // TODO:: дан список слов (words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов
        //  в списке вида Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(sameWordCount(words));


        // TODO:: дана мапа (customerMap).
        //  Написать статический метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(createMapFromTo(customerMap, 17, 60));

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод (можно статический):
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        String string = "still";
        System.out.println(string + ": " + wordCount(text,string));

        System.out.println(generateWordGroup(text));
        topTenWord(text);

    }
}
class CountComparator implements Comparator<Map.Entry<String,Integer>> {
    @Override
    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {

        return Integer.compare(o1.getValue(), o2.getValue());
    }
}
class WordComparator implements Comparator<Map.Entry<String,Integer>> {
    @Override
    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {

        return o1.getKey().compareTo(o2.getKey());
    }
}
/*
{reader=1, use=1, evolved=1, sometimes=2, sites=2, when=1, years=1, that=2, lorem=1, injected=1, model=1, has=1, text=1, Ipsum=2, publishing=1, Various=1, readable=2, using=2, still=2, making=1, like=2, in=1, its=1, is=2, infancy=1, uncover=9, it=2, packages=1, look=1, as=1, at=1, versions=1, Content=1, ipsum=1, looking=1, page=2, lettersas=1, here=2, fact=1, be=1, purpose=1, for=1, their=2, It=1, distribution=1, long=1, content=2, point=1, accident=1, The=1, default=1, search=1, desktop=1, more-or-less=1, web=2, and=3, by=2, of=3, humour=2, now=1, have=1, Many=1, editors=1, on=1, established=1, over=1, a=5, normal=1, opposed=1, will=2, distracted=1, many=1, the=3, layout=1, English=1, Lorem=2, to=1}
[Content=1, English=1, It=1, Many=1, The=1, Various=1, accident=1, as=1, at=1, be=1, default=1, desktop=1, distracted=1, distribution=1, editors=1, established=1, evolved=1, fact=1, for=1, has=1, have=1, in=1, infancy=1, injected=1, ipsum=1, its=1, layout=1, lettersas=1, long=1, look=1, looking=1, lorem=1, making=1, many=1, model=1, more-or-less=1, normal=1, now=1, on=1, opposed=1, over=1, packages=1, point=1, publishing=1, purpose=1, reader=1, search=1, text=1, to=1, use=1, versions=1, when=1, years=1, Ipsum=2, Lorem=2, by=2, content=2, here=2, humour=2, is=2, it=2, like=2, page=2, readable=2, sites=2, sometimes=2, still=2, that=2, their=2, using=2, web=2, will=2, and=3, of=3, the=3, a=5, uncover=9]
uncover
a
the
of
and
will
web
using
their
that
 */