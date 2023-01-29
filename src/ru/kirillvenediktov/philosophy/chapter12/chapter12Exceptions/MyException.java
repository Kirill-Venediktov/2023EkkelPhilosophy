package ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions;

public class MyException extends Exception {

    private String message;

    public MyException(String message) {
        super(message);
        this.message = message;
    }

    public void showMessage() {
        System.out.println("showMessage(): " + message);
    }
}
