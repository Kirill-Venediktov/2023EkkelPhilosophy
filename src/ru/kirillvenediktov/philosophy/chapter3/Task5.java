package ru.kirillvenediktov.philosophy.chapter3;

class Dog {

    private String name;

    private String says;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }
}

public class Task5 {

    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        Dog reks = new Dog();
        spot.setName("spot");
        scruffy.setName("scruffy");
        spot.setSays("bark-bark");
        scruffy.setSays("woof-woof");
        reks.setName("reks");
        reks.setSays("gav");
        System.out.println(spot.getName());
        System.out.println(spot.getSays());
        System.out.println(scruffy.getName());
        System.out.println(scruffy.getSays());
        System.out.println(reks.getName());
        System.out.println(reks.getSays());
        spot = reks;
        System.out.println(spot == reks);
        System.out.println(spot.equals(reks));
        System.out.println(spot.getName());
        System.out.println(spot.getSays());
    }
}
