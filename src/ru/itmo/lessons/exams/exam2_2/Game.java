package ru.itmo.lessons.exams.exam2_2;

import ru.itmo.lessons.exams.exam2_2.Pattern.InvokerMenuExecutor;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static Game game;
    private final GameMenu gameMenu;
    private final MainMenu mainMenu;
    private final HashMap<Integer, GameMarker> hashMap;

    private final InvokerMenuExecutor invoker;
    private int menuNumber = 1;

    private Game (){

        mainMenu = MainMenu.getMainMenu();
        gameMenu = GameMenu.getGameMenu();

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
        hashMap.get(menuNumber).draw();
        //mainMenu.setStarted(true);
    }

    public void nextstep (){

        Scanner scan = new Scanner(System.in);
        Boolean badvalue = true;
        int number = 0;

        while(badvalue) {
            String str = scan.nextLine();
            badvalue = false;

            try {
                number = Integer.parseInt(str);
                if (number < 1 || number > hashMap.get(menuNumber).getCommandMap().size()) {
                    System.out.println("Введена некорректная информация. Повторите ввод!");
                    badvalue = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введена некорректная информация. Повторите ввод!");
                badvalue = true;
            }

        }

        menuNumber = invoker.executeOperation(hashMap.get(menuNumber).getCommandMap().get(number));

        hashMap.get(menuNumber).draw();
        nextstep ();

    }
}
