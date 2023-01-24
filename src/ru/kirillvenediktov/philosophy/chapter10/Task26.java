package ru.kirillvenediktov.philosophy.chapter10;

public class Task26 {

    public class Inner {

        int anInt;

        String s;

        public Inner(int anInt, String s) {
            this.anInt = anInt;
            this.s = s;
        }
    }
}

class Task26Satelite {

    public class SateliteInner extends Task26.Inner {

        public SateliteInner(Task26 task26, int anInt, String s) {
            task26.super(anInt, s);
        }
    }
}
