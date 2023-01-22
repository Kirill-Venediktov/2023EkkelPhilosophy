package ru.kirillvenediktov.philosophy.chapter10;

public class Task15 {

    int anInt;

    public Task15(int anInt) {
        this.anInt = anInt;
    }

    public void methodOne() {
        System.out.println("Hello!");
    }
}

class Task15Satelite {

    public Task15 getTask15(int a){
        return new Task15(a){

            @Override
            public void methodOne() {
                System.out.println("Override!");
            }
        };
    }

    public static void main(String[] args) {
        Task15Satelite satelite = new Task15Satelite();
        Task15 task15 = satelite.getTask15(5);
        System.out.println(task15.anInt);
        task15.methodOne();
    }
}
