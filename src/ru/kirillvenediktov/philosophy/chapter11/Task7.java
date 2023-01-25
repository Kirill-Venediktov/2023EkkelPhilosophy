package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayList;
import java.util.List;

public class Task7 {
    private int id = ++count;
    private static int count = 0;

    @Override
    public String toString() {
        return "Task7{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        List<Task7> task7s = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            task7s.add(new Task7());
        }
        System.out.println(task7s);
        List<Task7> sub = task7s.subList(2, 6);
        System.out.println(sub);
        task7s.removeAll(sub);
        System.out.println(task7s);
    }
}
