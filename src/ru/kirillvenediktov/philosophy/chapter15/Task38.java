package ru.kirillvenediktov.philosophy.chapter15;

import java.time.LocalTime;
import java.util.Date;

class Coffee {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class Decorator extends Coffee {

    protected Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getValue() {
        return coffee.getValue();
    }

    @Override
    public void setValue(String value) {
        coffee.setValue(value);
    }
}

class Cappuccino extends Decorator {

    private final long cappuccinoTime;

    public Cappuccino(Coffee coffee) {
        super(coffee);
        cappuccinoTime = new Date().getTime();
    }

    public long getCappuccinoTime() {
        return cappuccinoTime;
    }
}

class WithDecorativeFoam extends Decorator {

    private boolean withFoam;


    public WithDecorativeFoam(Coffee coffee) {
        super(coffee);
        withFoam = true;
    }

    public boolean isWithFoam() {
        return withFoam;
    }
}

class WithChocolate extends Decorator {

    private final String chocolateType;

    public WithChocolate(Coffee coffee, String s) {
        super(coffee);
        this.chocolateType = s;
    }

    public String getChocolateType() {
        return chocolateType;
    }
}

class WithCaramel extends Decorator {

    private final int caramelWeight;

    public WithCaramel(Coffee coffee, int caramelWeight) {
        super(coffee);
        this.caramelWeight = caramelWeight;
    }

    public int getCaramelWeight() {
        return caramelWeight;
    }
}

class WithWhippedCream extends Decorator {

    private final LocalTime timeOfCooking;

    public WithWhippedCream(Coffee coffee) {
        super(coffee);
        timeOfCooking = LocalTime.now();
    }

    public LocalTime getTimeOfCooking() {
        return timeOfCooking;
    }
}


public class Task38 {

    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(new Coffee());
        Cappuccino cappuccino1 = new Cappuccino(new WithCaramel(new Coffee(), 2));
        WithDecorativeFoam foam = new WithDecorativeFoam(new Coffee());
        WithDecorativeFoam foam1 = new WithDecorativeFoam(
                new WithWhippedCream(new WithChocolate(new Coffee(), "Dark")));
    }

}
