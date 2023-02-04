package ru.kirillvenediktov.philosophy.chapter14;

class Candy {

    static {
        System.out.println("Загрузка класса Candy");
    }
}

class Gum {

    static {
        System.out.println("Загрузка класса Gum");
    }
}

class Cookie {

    static {
        System.out.println("Загрузка класса Cookie");
    }
}

public class SweetShop {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.exit(1);
        }
        System.out.println("в методе main");
        if (args[0].equals(Candy.class.getSimpleName())) {
            new Candy();
            System.out.println("После создания Candy");
        } else if (args[0].equals(Gum.class.getSimpleName())) {
            try{
                Class.forName("Gum");
            } catch (ClassNotFoundException e) {
                System.out.println("Не удалось найти Gum");
            }
            System.out.println("После вызова метода Class.forName(\"Gum\")");
        } else if (args[0].equals(Cookie.class.getSimpleName())) {
            new Cookie();
            System.out.println("После создания объекта Cookie");
        }
    }

}
