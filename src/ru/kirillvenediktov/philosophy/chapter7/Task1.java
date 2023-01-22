package ru.kirillvenediktov.philosophy.chapter7;

public class Task1 {

    private String s1;
    private int anInt = 5;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return "Task1{" +
                "s1='" + s1 + '\'' +
                ", anInt=" + anInt +
                '}';
    }
}

class Task1Satelite {
    private Task1 task1;

    @Override
    public String toString() {
        if (task1 == null) {
            task1 = new Task1();
        }
        return "Task1Satelite{" +
                "task1=" + task1 +
                '}';
    }
}
