package ru.itmo.lessons.exams.exam2_3;

import ru.itmo.lessons.exams.exam2_3.Pattern.ExecutorMenu;

import java.util.HashMap;
import java.util.Map;

public class Menu {


    private final HashMap<Integer, ExecutorMenu> commandMap;
    private final HashMap<Integer, String> menuMap;

    private String menuHeader;

    public Menu(HashMap<Integer, ExecutorMenu> commandMap, HashMap<Integer, String> menuMap){
        this.commandMap = commandMap;
        this.menuMap = menuMap ;
    }

    public void setMenuHeader(String menuHeader) {
        this.menuHeader = menuHeader;
    }

    public HashMap<Integer, ExecutorMenu> getCommandMap(){
        return commandMap;
    }

    public void draw(){
        System.out.println(menuHeader);
        System.out.println("-------------------------------------------------");

        for (Map.Entry<Integer, String> pair: menuMap.entrySet()) {
            if (pair.getValue() != null) System.out.println(pair.getKey() + ". " + pair.getValue());
        }
    }

}
