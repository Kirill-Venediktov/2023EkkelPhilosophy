package ru.kirillvenediktov.philosophy.chapter18;

import java.nio.CharBuffer;

public class Task23 {

    public boolean isPrintable(char c) {
        return ((c >= '!') && (c <= '~'));
    }

    public void showCharBuffer(CharBuffer cb) {
        cb.rewind();
        while (cb.hasRemaining()) {
            char c = cb.get();
            if (isPrintable(c)) {
                System.out.println(c);
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b','c','d'};
        CharBuffer cb = CharBuffer.wrap(chars);
        Task23 task23 = new Task23();
        task23.showCharBuffer(cb);

        CharBuffer cb2 = CharBuffer.allocate(6);
        char[] chars2 = new char[]{(char)0x01, (char)0x07, (char)0x7F,'b','y','e'};
        cb2.put(chars2);
        task23.showCharBuffer(cb2);

    }
}
