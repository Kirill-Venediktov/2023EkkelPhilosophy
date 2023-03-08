package ru.kirillvenediktov.philosophy.exceptions;

public class OSExecuteException extends RuntimeException{
    public OSExecuteException(String why) {
        super(why);
    }
}
