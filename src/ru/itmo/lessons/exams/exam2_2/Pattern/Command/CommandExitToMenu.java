package ru.itmo.lessons.exams.exam2_2.Pattern.Command;

import ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_2.Pattern.ReceiverMenu;

public class CommandExitToMenu implements ExecutorMenu {
    private ReceiverMenu receiver;

    public CommandExitToMenu(ReceiverMenu receiverMenu){
        this.receiver=receiverMenu;
    }
    @Override
    public int execute(){return receiver.exitToMenu();}
}
