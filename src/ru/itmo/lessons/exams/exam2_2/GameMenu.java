package ru.itmo.lessons.exams.exam2_2;

import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandExitToMenu;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandStep1;
import ru.itmo.lessons.exams.exam2_2.Pattern.Command.CommandStep2;
import ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_2.Pattern.ReceiverMenu;

import java.util.HashMap;
import java.util.Map;

public class GameMenu implements GameMarker {

    private static GameMenu gameMenu;
    private final GameStep gameStep;

    private final HashMap<Integer, ExecutorMenu> commandMap;
    private final HashMap<Integer, String> menuMap;

    private GameMenu(){
        gameStep = GameStep.getGameStep();

        commandMap = new HashMap<>();
        commandMap.put(1, new CommandStep1(new ReceiverMenu(gameStep)));
        commandMap.put(2, new CommandStep2(new ReceiverMenu(gameStep)));
        commandMap.put(3, new CommandExitToMenu(new ReceiverMenu(gameStep)));

        menuMap = new HashMap<>();
        menuMap.put(1, gameStep.getAllParams()[3]);
        menuMap.put(2, gameStep.getAllParams()[5]);
        menuMap.put(3, "Выйти в меню");

    }

    public static GameMenu getGameMenu(){
        if (gameMenu == null) {
            gameMenu = new GameMenu();
        }
        return gameMenu;
    }

    public HashMap<Integer, ExecutorMenu> getCommandMap(){
        return commandMap;
    }

    public void draw(){
        gameStep.parse();

        System.out.println(gameStep.getAllParams()[0]); //заголовок
        System.out.println("-------------------------------------------------");
        System.out.println(gameStep.getAllParams()[1]); //текст
        System.out.println();
        if (gameStep.getAllParams().length == 3) {
            System.out.println("-------------------------------------------------");
            System.out.println(gameStep.getAllParams()[2]); //итог
            gameStep.gameStop();
            System.exit(1);
        }
        else {
            menuMap.put(1, gameStep.getAllParams()[3]);
            menuMap.put(2, gameStep.getAllParams()[5]);
            for (Map.Entry<Integer, String> pair: menuMap.entrySet()) {
                System.out.println(pair.getKey() + ". " + pair.getValue());
            }
        }
    }

}
