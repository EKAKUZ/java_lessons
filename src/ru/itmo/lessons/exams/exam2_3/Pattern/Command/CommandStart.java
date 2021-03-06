package ru.itmo.lessons.exams.exam2_3.Pattern.Command;

import ru.itmo.lessons.exams.exam2_3.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_3.Pattern.ReceiverMenu;

public class CommandStart implements ExecutorMenu {
    private ReceiverMenu receiver;

    public CommandStart(ReceiverMenu receiverMenu){
        this.receiver=receiverMenu;
    }
    @Override
    public int execute(){return receiver.start();}
}

