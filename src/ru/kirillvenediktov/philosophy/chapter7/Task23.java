package ru.kirillvenediktov.philosophy.chapter7;

class Task23Satelite {
    static int i = getInt("поле i проинициализированно");

    public static int getInt(String s) {
        System.out.println(s);
        return 46;
    }
}

public class Task23 {

    static int anInt = getInt("поле anInt проинициализированно");

    public static int getInt(String s) {
        System.out.println(s);
        return 46;
    }

    public static void main(String[] args) {

        System.out.println("Инициализация при создании экземпляра:");
        Task23Satelite task23Satelite = new Task23Satelite();

    }

}
