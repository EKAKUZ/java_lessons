package ru.itmo.lessons.exams.exam2_3.Pattern;/*the Invoker class*/

public class InvokerMenuExecutor {
    private ru.itmo.lessons.exams.exam2_3.Pattern.ExecutorMenu menuCommand;

    public InvokerMenuExecutor(){}

    public int executeOperation(ExecutorMenu menuCommand){
        return menuCommand.execute();
    }

}