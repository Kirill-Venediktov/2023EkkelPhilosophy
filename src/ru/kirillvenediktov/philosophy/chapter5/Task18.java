package ru.kirillvenediktov.philosophy.chapter5;

public class Task18 {
    public void stringMethod(String ... args){
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Task18 task18 = new Task18();
        task18.stringMethod("hello", "my","friend");
        task18.stringMethod(new String[]{"goodbye", "my", "friend", "goodbye"});
    }
}
