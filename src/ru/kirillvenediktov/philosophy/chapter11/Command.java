package ru.kirillvenediktov.philosophy.chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Command {

    private String string;

    public Command(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void operation() {
        System.out.println("Operation(). String = " + string);
    }


}

class Task27 {

    private static Random random = new Random();

    public Queue<Command> fillQueue() {
        Queue<Command> commands = new LinkedList<>();
        OfficeCharacter[] characters = OfficeCharacter.values();
        for (int i = 0; i < 15; i++) {
            commands.offer(new Command(characters[random.nextInt(characters.length)].toString()));
        }
        System.out.println(commands);
        return commands;
    }
}

class Task27Satelite {

    public void showOperation(Queue<Command> commands) {
        while (commands.peek() != null) {
            commands.remove().operation();
        }
    }

    public static void main(String[] args) {
        Task27 task27 = new Task27();
        Task27Satelite satelite = new Task27Satelite();
        satelite.showOperation(task27.fillQueue());
    }
}
