package ru.itmo.lessons.lesson17_stream.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopTenWords {
    public static void main(String[] args) {

        String text = "It    is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout the point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // TODO: Используя Stream API: создать Map<String, Long>, где
        //  - String - слово
        //  - Long - частота встречаемости
        //  В мапу должны войти только первые 10 по частоте встречаемости слов.
        Map<String, Long> map = Arrays.stream(text.replaceAll(" +", " ").toLowerCase().split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted((entry2,entry1)-> (int) (entry1.getValue() - entry2.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //[uncover=9, a=5, the=4, lorem=3, it=3, ipsum=3, content=3, and=3, of=3, sometimes=2]
        System.out.println(map);
        //{the=4, lorem=3, a=5, and=3, sometimes=2, of=3, ipsum=3, it=3, uncover=9, content=3}
    }
}