package ru.kirillvenediktov.philosophy.chapter4;

import java.util.Arrays;

public class FibbonacciGenerator {

    public void showFibbonacciRow(int amount) {
        int[] fibbonacciRow = new int[amount];
        for (int i = 0; i < amount; i++) {
            switch (i) {
                case 0:
                case 1:
                    fibbonacciRow[i] = 1;
                    break;
                default:
                    fibbonacciRow[i] = fibbonacciRow[i-1] + fibbonacciRow[i-2];
                    break;
            }
        }
        System.out.println(Arrays.toString(fibbonacciRow));
    }

    public static void main(String[] args) {
        FibbonacciGenerator generator = new FibbonacciGenerator();
        generator.showFibbonacciRow(10);
    }
}
