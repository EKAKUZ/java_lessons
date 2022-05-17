package ru.itmo.lessons.exams.exam2_2.Pattern.Command;

import ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_2.Pattern.ReceiverMenu;

public class CommandLoad implements ExecutorMenu {
    private ReceiverMenu receiver;

    public CommandLoad(ReceiverMenu receiverMenu){
        this.receiver=receiverMenu;
    }
    @Override
    public int execute(){return receiver.load();}
}
