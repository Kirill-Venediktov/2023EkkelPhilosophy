package ru.kirillvenediktov.philosophy.chapter8;

class Composing {

    private Shared shared;

    private static long counter = 0;

    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Создаем " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing{" +
                "id=" + id +
                '}';
    }
}


public class ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared), new Composing(shared)};
        for (Composing c : composings) {
            c.dispose();
        }
    }

}
