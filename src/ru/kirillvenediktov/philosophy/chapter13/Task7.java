package ru.kirillvenediktov.philosophy.chapter13;

public class Task7 {

    public boolean checkSentence(String s) {
        return s.matches("[a-z[а-я]].+\\.");
    }

    public static void main(String[] args) {
        Task7 task7 = new Task7();

        System.out.println(task7.checkSentence
                ("a regular expression, specified as a string, must first be compiled into an instance of this class."));

    }
}
