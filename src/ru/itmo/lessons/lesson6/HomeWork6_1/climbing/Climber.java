package ru.itmo.lessons.lesson6.HomeWork6_1.climbing;

public class Climber {
    private String name;
    private String addr;

    public Climber(){};

    public Climber(String name, String addr) {
        setName(name);
        setAddr(addr);
    }

    public void setName (String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException ("Имя альпиниста должно быть не менее 3х символов");
        }
        this.name = name;
    }
    public void setAddr (String addr) {
        if (addr == null || addr.length() < 5) {
            throw new IllegalArgumentException ("Адрес проживания альпиниста должен содержать не менее 5ти символов");
        }
        this.addr = addr;
    }

    public String getName () {
        return name;
    }
    public String getAddr () {
        return addr;
    }
}
