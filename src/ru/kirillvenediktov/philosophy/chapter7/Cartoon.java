package ru.kirillvenediktov.philosophy.chapter7;

class Art {

    public Art() {
        System.out.println("Конструктор Art");
    }
}

class Drawing extends Art {

    public Drawing() {
        System.out.println("Конструктор Drawing");
    }
}

public class Cartoon extends Drawing {

//    public Cartoon() {
//        System.out.println("Конструктор Cartoon");
//    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
