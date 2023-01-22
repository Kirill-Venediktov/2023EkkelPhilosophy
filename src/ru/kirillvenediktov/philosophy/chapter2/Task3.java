package ru.kirillvenediktov.philosophy.chapter2;

class ATypeName{

    public void sayHello(){
        System.out.println("Hello world!");
    }
}

public class Task3 {

    public static void main(String[] args) {
        ATypeName aTypeName = new ATypeName();
        aTypeName.sayHello();
    }
}
