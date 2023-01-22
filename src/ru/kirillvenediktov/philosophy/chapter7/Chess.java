package ru.kirillvenediktov.philosophy.chapter7;

class Game {

    public Game(int i) {
        System.out.println("Конструктор Game");
    }
}

class BoardGame extends Game {

    public BoardGame(int i) {
        super(i);
        System.out.println("Конструктор BoardGame");
    }
}

public class Chess extends BoardGame{

    public Chess() {
        super(11);
        System.out.println("Конструктор Chess");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
