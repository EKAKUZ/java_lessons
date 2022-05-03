package ru.itmo.lessons.lesson12_exception;
// можно создавать собственные классы исключения
// если мы хотим создавать исключения времени выполнения,
// наследуем класс от RunTimeException

// если мы хотим создавать исключения времени компиляции,
// наследуем класс от Exception

public class CalcException extends Exception{

    public CalcException (String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Будьте внимательны!";
    }
}
// чтоб передавать аргументы нужно переобредилить родительский конструктор
// можно добавлять собственные методы и свойства
// можно вызывать конструктор родителя
// можно переобределять методы родителя