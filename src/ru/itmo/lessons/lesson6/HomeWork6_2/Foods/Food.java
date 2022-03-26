package ru.itmo.lessons.lesson6.HomeWork6_2.Foods;

public class Food {
    private String name;
    private double protein = 0;
    private double carb = 0;
    private double fats = 0;
    private double kal = 0;

    public Food(){}

    public Food(String name){
        setName(name);
    }
    public Food(String name, double kkal){
        setName(name);
        setKal(kkal);
    }
    public Food(String name, double protein, double carb, double fats, double kkal){
        setName(name);
        setProtein(protein);
        setCarb(carb);
        setFats(fats);
        setKal(kkal);
    }

    public void setName(String name) {
        if (name == null || name.length() == 0 ) throw new IllegalArgumentException ("Отсутствует название продукта");
        this.name = name;
    }
    public void setCarb(double carb) {
        if (carb < 0) throw new IllegalArgumentException ("Количество углеводов в продукте  не может быть меньше  0");
        this.carb = carb;
    }
    public void setProtein(double protein) {
        if (protein < 0) throw new IllegalArgumentException ("Количество белков в продукте не может быть меньше 0");
        this.protein = protein;
    }
    public void setFats(double fats) {
        if (fats < 0) throw new IllegalArgumentException ("Количество жиров в продукте не может быть меньше 0");
        this.fats = fats;
    }
    public void setKal(double kal) {
        if (kal < 0) throw new IllegalArgumentException ("Количество ккал в продукте  не может быть меньше  0");
        this.kal = kal;
    }

    public String getName() {
        return name;
    }
    public double getProtein() {
        return protein;
    }
    public double getFats() {
        return fats;
    }
    public double getCarb() {
        return carb;
    }
    public double getKal() {
        return kal;
    }


}
