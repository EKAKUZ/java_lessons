package ru.itmo.lessons.exams.exam2_3;

import ru.itmo.lessons.exams.exam2_3.Pattern.Command.*;
import ru.itmo.lessons.exams.exam2_3.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_3.Pattern.InvokerMenuExecutor;
import ru.itmo.lessons.exams.exam2_3.Pattern.ReceiverMenu;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static Game game;
    private final GameStep gameStep;
    private final Menu gameMenu;
    private final Menu mainMenu;
    private final HashMap<Integer, ExecutorMenu> commandMainMap;
    private final HashMap<Integer, String> menuMainMap;
    private final HashMap<Integer, ExecutorMenu> commandGameMap;
    private final HashMap<Integer, String> menuGameMap;
    private final HashMap<Integer, Menu> hashMap;

    private final InvokerMenuExecutor invoker;
    private int menuNumber;

    private Game (){
        gameStep = GameStep.getGameStep();

        commandMainMap = new HashMap<>();
        commandMainMap.put(1, new CommandStart(new ReceiverMenu(gameStep)));
        commandMainMap.put(2, new CommandLoad(new ReceiverMenu(gameStep)));
        commandMainMap.put(3, new CommandExit(new ReceiverMenu(gameStep)));

        menuMainMap = new HashMap<>();
        menuMainMap.put(1, "Начать игру");
        menuMainMap.put(2, "Загрузить игру");
        menuMainMap.put(3, "Выйти");

        commandGameMap = new HashMap<>();
        commandGameMap.put(1, new CommandStep1(new ReceiverMenu(gameStep)));
        commandGameMap.put(2, new CommandStep2(new ReceiverMenu(gameStep)));
        commandGameMap.put(3, new CommandExitToMenu(new ReceiverMenu(gameStep)));

        menuGameMap = new HashMap<>();
        menuGameMap.put(1, gameStep.getAllParams()[3]);
        menuGameMap.put(2, gameStep.getAllParams()[5]);
        menuGameMap.put(3, "Выйти в меню");


        mainMenu = new Menu(commandMainMap, menuMainMap);
        gameMenu = new Menu(commandGameMap, menuGameMap);

        hashMap = new HashMap<>();
        hashMap.put(1, mainMenu);
        hashMap.put(2, gameMenu);

        invoker = new InvokerMenuExecutor();
    }

    public static Game getGame(){
        if(game == null){
            game = new Game();
        }
        return game;
    }

    public void go(){
        mainMenu.setMenuHeader("Меню игры:");
        menuNumber = 1;
        hashMap.get(menuNumber).draw();
    }

    public void nextstep (){

        if (gameStep.isGameStarted()) {
            menuMainMap.put(3, "Сохранить игру");
            menuMainMap.put(4, "Выйти");
            commandMainMap.put(3, new CommandSave(new ReceiverMenu(gameStep)));
            commandMainMap.put(4, new CommandExit(new ReceiverMenu(gameStep)));
        }

        Scanner scan = new Scanner(System.in);
        boolean badValue = true;
        int stepNumber = 0;

        while(badValue) {
            String str = scan.nextLine();
            badValue = false;

            try {
                stepNumber = Integer.parseInt(str);
                if (stepNumber < 1 || stepNumber > hashMap.get(menuNumber).getCommandMap().size()) {
                    System.out.println("Введена некорректная информация. Повторите ввод!");
                    badValue = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введена некорректная информация. Повторите ввод!");
                badValue = true;
            }

        }

        menuNumber = invoker.executeOperation(hashMap.get(menuNumber).getCommandMap().get(stepNumber));

        gameStep.parse();

        if (gameStep.getAllParams().length == 3) {
            gameMenu.setMenuHeader(gameStep.getAllParams()[0] + "\n\n" + gameStep.getAllParams()[1]
                    + "\n\n" + gameStep.getAllParams()[2]);
            menuGameMap.put(1, null);
            menuGameMap.put(2, null);
            menuGameMap.put(3, null);
            hashMap.get(menuNumber).draw();
            menuNumber = invoker.executeOperation(hashMap.get(1).getCommandMap().get(4));
        }
        else
        {
            gameMenu.setMenuHeader(gameStep.getAllParams()[0] + "\n\n" + gameStep.getAllParams()[1]);
            menuGameMap.put(1, gameStep.getAllParams()[3]);
            menuGameMap.put(2, gameStep.getAllParams()[5]);
            hashMap.get(menuNumber).draw();
        }

        nextstep ();

    }
}
