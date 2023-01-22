package ru.kirillvenediktov.philosophy.chapter5;

public class Task17 {

    public Task17(String arg) {
        System.out.println(arg);
    }

    public static void main(String[] args) {
        Task17[] task17s = new Task17[5];
        for (int i = 0; i < task17s.length; i++) {
            task17s[i] = new Task17("hello");
        }
    }
}
