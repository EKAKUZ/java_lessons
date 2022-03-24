package ru.itmo.lessons.lesson6.HomeWork6_1.climbing;

public class Mountain {
    private String name;
    private String country;
    private double height;

    public Mountain(){};
    public Mountain(String name, String country, double height){
        setName(name);
        setCountry(country);
        setHeight(height);
    };

    public void setName (String name) {
        if (name == null || name.length() < 4) {
            throw new IllegalArgumentException ("Название горы должно быть не менее 4х символов");
        }
        this.name = name;
    }
    public void setCountry (String country) {
        if (country == null || country.length() < 4) {
            throw new IllegalArgumentException ("Название горы должно быть не менее 4х символов");
        }
        this.country = country;
    }
    public void setHeight (double height) {
        if (height < 100.0) {
            throw new IllegalArgumentException ("Высота горы должна быть не менее 100");
        }
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public double getHeight() {
        return height;
    }

}
