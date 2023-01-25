package ru.kirillvenediktov.philosophy.chapter11;

import java.util.ArrayDeque;
import java.util.Deque;


public class Task15 {
   private static final String CODE = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";

    public static void main(String[] args) {
        StackInterpreter interpreter = new StackInterpreter();
        interpreter.interpret(CODE);
    }
}

class StackInterpreter {

    Deque<Character> buff = new ArrayDeque<>();

    public void interpret(String code) {
        char[] signs = code.toCharArray();
        for (int i = 0; i < signs.length; i++) {
            char c = signs[i];
            switch (c){
                case '+':
                    buff.push(signs[++i]);
                    break;
                case '-':
                    System.out.print(buff.pop());
                    break;
                default:
            }
        }


    }
}
