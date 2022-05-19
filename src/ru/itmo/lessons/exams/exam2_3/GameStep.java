package ru.itmo.lessons.exams.exam2_3;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

public class GameStep {

    private String stepKey = "key1";
    //private String title;0
    //private String text;1
    //private String step1Key;2
    //private String textStep1;3
    //private String step2Key;4
    //private String textStep2;5
    //private String itog;6
    private String[] allParams;
    private final Properties properties = new Properties();
    private static GameStep gameStep;

    private final String propFile = "exam2.properties";
    private boolean gameStarted = false;

    private GameStep(){
        try (InputStream stream  = GameApp.class.getClassLoader().getResourceAsStream(propFile)) {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        parse();
    }

    public static GameStep getGameStep(){
        if (gameStep == null) {
            gameStep = new GameStep();
        }
        return gameStep;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public String[] getAllParams() {
        return allParams;
    }

    public void parse(){
        allParams = Arrays.stream(properties.getProperty(stepKey).split("&&")).flatMap(param-> Arrays.stream(param.split("="))).toArray(String[]::new);
    }

    public String getStepKey() {
        return stepKey;
    }

    public void setStepKey(String stepKey) {
        this.stepKey = stepKey;
    }

    public void gameStop(){
        properties.clear();
    }

}
