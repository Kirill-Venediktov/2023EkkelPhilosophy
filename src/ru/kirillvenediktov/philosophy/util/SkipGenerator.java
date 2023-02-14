package ru.kirillvenediktov.philosophy.util;

public class SkipGenerator {

    public static class Boolean implements Generator<java.lang.Boolean> {

        private boolean value;

        public Boolean(boolean value) {
            this.value = value;
        }

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        private byte value;

        public Byte(byte value) {
            this.value = value;
        }

        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements Generator<java.lang.Character> {

        int index;

        public Character(int index) {
            this.index = index;
        }

        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements Generator<java.lang.String> {

        private int length = 7;

        Generator<java.lang.Character> cg;

        public String(int index) {
            this.cg = new SkipGenerator.Character(index);
        }

        public String(int index, int length) {
            this.length = length;
            cg = new SkipGenerator.Character(index);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {

        private short value;

        public Short(short value) {
            this.value = value;
        }

        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int value;

        public Integer(int value) {
            this.value = value;
        }

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements Generator<java.lang.Long> {

        private long value;

        public Long(long value) {
            this.value = value;
        }

        @Override
        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements Generator<java.lang.Float> {

        private float value;

        public Float(float value) {
            this.value = value;
        }

        @Override
        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        private double value;

        public Double(double value) {
            this.value = value;
        }

        @Override
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }
}
