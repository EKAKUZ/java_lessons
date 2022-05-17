package ru.itmo.lessons.exams.exam2_2.Pattern.Command;

import ru.itmo.lessons.exams.exam2_2.GameStep;
import ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu;
import ru.itmo.lessons.exams.exam2_2.Pattern.ReceiverMenu;

public class CommandStep2 implements ExecutorMenu {
    private ReceiverMenu receiver;

    public CommandStep2(ReceiverMenu receiverMenu){
        this.receiver=receiverMenu;
    }
    @Override
    public int execute(){return receiver.step2();}
}
