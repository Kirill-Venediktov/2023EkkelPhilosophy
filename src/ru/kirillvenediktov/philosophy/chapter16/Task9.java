package ru.kirillvenediktov.philosophy.chapter16;

import java.util.ArrayList;
import java.util.List;

class Banana {
    private static long counter;

    private final long id = counter++;

    @Override
    public String toString() {
        return "Banana{" +
                "id=" + id +
                '}';
    }
}

class Peel<T> {

    private T[] t;

    public T[] getT() {
        return t;
    }

    public void setT(T[] t) {
        this.t = t;
    }

    public void peel(){
        if (t != null) {
            System.out.println("Peels!");
            t = null;
        }
    }
}


public class Task9 {

    public static void main(String[] args) {
//        Peel<Banana>[] peels = new Peel<Banana>();

        List<Peel<Banana>> peels = new ArrayList<>();
    }
}
