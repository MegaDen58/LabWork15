package com.company;

enum ClothesSize{
    XXS(32){
        @Override
        public String getDescription(){
            return "Детский размер.";
        }
    }, XS(34), S(36), M(38), L(40);
    private final int Eurosize;

    ClothesSize(int i) {
        Eurosize = i;
    }

    public String getDescription(){
        return "Взрослый размер.";
    }
    public String toString(){
        return name() + " (" + Eurosize + ") " + getDescription();
    }
}

interface ClothesOfMen{
    default void dressAMen(){
        System.out.println("Одеть мужчину.");
    }
}

interface ClothesOfWomen{
    default void dressAWomen(){
        System.out.println("Одеть девушку.");
    }
}

abstract class Clothes{
    private final ClothesSize size;
    private double price;
    private final String color;

    Clothes(ClothesSize size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public void setPrice(double x){
        this.price = x;
    }
    public ClothesSize getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}

class Atelier{
    void dressAMan(Clothes[] clothes){
        System.out.println("Мужская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof ClothesOfMen){
                System.out.println(c);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("Женская одежда\n");
        for(Clothes c : clothes){
            if(c instanceof ClothesOfWomen){
                System.out.println(c);
            }
        }
    }
    public static class TShirt extends Clothes implements ClothesOfMen, ClothesOfWomen{
        TShirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "=============" + "\n" + "Размер футболки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Trousers extends Clothes implements ClothesOfMen, ClothesOfWomen{
        Trousers(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "=============" + "\n" + "Размер штанов " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Skirt extends Clothes implements ClothesOfWomen{
        Skirt(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "=============" + "\n" + "Размер юбки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Tie extends Clothes implements ClothesOfMen{
        Tie(ClothesSize size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "=============" + "\n" + "Размер галстука " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Atelier.TShirt(ClothesSize.M, "Синяя", 800),
                new Atelier.TShirt(ClothesSize.S, "Красная", 800),
                new Atelier.Trousers(ClothesSize.XXS, "Серые", 1300),
                new Atelier.Trousers(ClothesSize.M, "Чёрные", 1400),
                new Atelier.Skirt(ClothesSize.XS, "Красная", 2200),
                new Atelier.Skirt(ClothesSize.L, "Белая", 2500),
                new Atelier.Tie(ClothesSize.XS, "Чёрный", 800),
                new Atelier.Tie(ClothesSize.XXS, "Синий", 1200),
        };

        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        System.out.println();
        atelier.dressAWoman(clothes);
    }
}