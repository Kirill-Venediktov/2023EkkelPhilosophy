package ru.kirillvenediktov.philosophy.chapter14;

interface HasBatteries {

}

interface Waterproof {

}

interface Expensive {

}

interface Shoots {

}

class Toy {

//    public Toy() {
//    }

    public Toy(int i) {

    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Expensive {

    public FancyToy(int i) {
        super(i);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        System.out.println("Имя класса: " + cc.getName() + " является интерфейсом? [" + cc.isInterface() + "]");
        System.out.println("Простое имя: " + cc.getSimpleName());
        System.out.println("Каноничное имя: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ru.kirillvenediktov.philosophy.chapter14.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Не удается найти FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Не удалось создать экземпляр");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Access denied");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
