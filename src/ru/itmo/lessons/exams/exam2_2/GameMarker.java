package ru.itmo.lessons.exams.exam2_2;


import ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu;

import java.util.HashMap;

interface GameMarker {
    HashMap<Integer, ExecutorMenu> getCommandMap();
    void draw();
}
