package ru.kirillvenediktov.philosophy.chapter5;

public class Dog {

    public void bark(char x) {
        System.out.println("лай");
    }

    public void bark(byte x) {
        System.out.println("завывание");
    }

    public void bark(short x) {
        System.out.println("поскуливание");
    }

    public void bark(int x) {
        System.out.println("вой");
    }

    public void bark(long x) {
        System.out.println("визжание");
    }

    public void bark(float x, double y) {
        System.out.println("блюет");
    }

    public void bark(double x, float y) {
        System.out.println("срет");
    }
}

class Task5 {

    public static void main(String[] args) {
        char a = 'x';
        byte b = 0;
        short c = 0;
        int d = 0;
        long e = 0;
        float f = 0;
        double g = 0;
        Dog dog = new Dog();
        dog.bark(a);
        dog.bark(b);
        dog.bark(c);
        dog.bark(d);
        dog.bark(e);
        dog.bark(f, g);
        dog.bark(g,f);
    }
}
