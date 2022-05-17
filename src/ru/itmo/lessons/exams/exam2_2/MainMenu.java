package ru.itmo.lessons.exams.exam2_2;

import ru.itmo.lessons.exams.exam2_2.Pattern.*;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandExit;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandLoad;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandSave;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandStart;

import java.util.HashMap;
import java.util.Map;

public class MainMenu implements GameMarker {
    private static MainMenu mainMenu;
    private final HashMap<Integer, ExecutorMenu> commandMap;
    private final HashMap<Integer, String> menuMap;
    private final GameStep gameStep;

    private MainMenu(){
        gameStep = GameStep.getGameStep();

        commandMap = new HashMap<>();
        commandMap.put(1, new CommandStart(new ReceiverMenu(gameStep)));
        commandMap.put(2, new CommandLoad(new ReceiverMenu(gameStep)));
        commandMap.put(3, new CommandSave(new ReceiverMenu(gameStep)));
        commandMap.put(4, new CommandExit(new ReceiverMenu(gameStep)));

        menuMap = new HashMap<>();
        menuMap.put(1, "Начать игру");
        menuMap.put(2, "Загрузить игру");
        menuMap.put(3, "Сохранить игру");
        menuMap.put(4, "Выйти");
    }

    public static MainMenu getMainMenu(){
        if (mainMenu == null) {
            mainMenu = new MainMenu();
        }
        return mainMenu;
    }

    public HashMap<Integer, ExecutorMenu> getCommandMap(){
        return commandMap;
    }

    public void draw(){
        System.out.println("Меню игры:");
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, String> pair: menuMap.entrySet()) {
            if (!((!gameStep.isGameStarted())&&(pair.getKey()==3))) System.out.println(pair.getKey() + ". " + pair.getValue());
        }
    }
}