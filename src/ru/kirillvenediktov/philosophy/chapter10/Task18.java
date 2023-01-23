package ru.kirillvenediktov.philosophy.chapter10;

public class Task18 {
    private static class Inner {
        private int anInt;

        public Inner(int anInt) {
            this.anInt = anInt;
        }

        public int getAnInt() {
            return anInt;
        }

        public void setAnInt(int anInt) {
            this.anInt = anInt;
        }
    }

    public static Inner inner(int a) {
        return new Inner(a);
    }

    public static void main(String[] args) {
        Task18.Inner inner2 = new Task18.Inner(4);
        Task18.Inner inner = Task18.inner(5);
        System.out.println(inner.getAnInt());
        System.out.println(inner2);
    }
}

class Task18Satelite {

    public static void main(String[] args) {
//        Task18.Inner inner2 = new Task18.Inner(4);
//        Task18.Inner inner = Task18.inner(5);
//        System.out.println(inner.getAnInt());
//        System.out.println(inner2);
    }
}
