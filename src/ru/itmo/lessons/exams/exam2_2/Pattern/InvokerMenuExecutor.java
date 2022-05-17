package ru.itmo.lessons.exams.exam2_2.Pattern;/*the Invoker class*/

import ru.itmo.lessons.exams.exam2_2.GameStep;

public class InvokerMenuExecutor {
    private ru.itmo.lessons.exams.exam2_2.Pattern.ExecutorMenu menuCommand;

    public InvokerMenuExecutor(){}

    public int executeOperation(ExecutorMenu menuCommand){
        return menuCommand.execute();
    }

}