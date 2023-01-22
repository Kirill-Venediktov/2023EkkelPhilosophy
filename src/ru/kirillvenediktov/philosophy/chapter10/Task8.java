package ru.kirillvenediktov.philosophy.chapter10;

public class Task8 {

    class Inner {

        private int innerInt = 5;

        private String innerString = "innerString";
    }

    public void getInnerFields() {
        System.out.println(this.new Inner().innerInt);
        System.out.println(this.new Inner().innerString);
    }

}

class Task8Satelite {

    public static void main(String[] args) {
        Task8 task8 = new Task8();
        task8.getInnerFields();
    }
}
