package ru.itmo.lessons.lesson21_oop_patterns.patterns.builder;

public class TstNutrition {
    public static void main(String[] args) {
        //  // Builder: servings: 3, calories: 200, fat: 4
        NutritionFacts appleFacts =
                new NutritionFacts.Builder(3)
                .calories(200)
                .fat(4)
                .build();
        System.out.println(appleFacts);
    }
}