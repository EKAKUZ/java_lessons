package ru.itmo.lessons.lesson11_enums_datetime.enums;
//  в перечислениях могут быть св-ва, методы включая геттеры и сеторы
public enum Priority {
    HIGH(10), MIDDLE(5), LOW(1);
    // объекты класса типа enum
    //если только элементы перечеслиния - точку
    // с запятой можно не ставить,
    // но если появляется еще что-то точка
    // с запятой обязательны!!!

    private int code;
    //конструкотр поумолчанию private,
    // так как обьекты создаются внутри класса
    Priority(int code) { //конструктор приватный по умолчанию
            this.code = code;
    }
    // методы доступны элемнтам перечисления согласно модификатором доступа
    public void setCode(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
