package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.exceptions.InvalidParameterException;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {

    private final Random random = new Random();

    public double[][] createDoubleArray(int size1, int size2, double from, double to) {
        if (to < from || to == from) {
            throw new InvalidParameterException("'from' must be less than 'to'");
        }
        double[][] doublesArray = new double[size1][size2];
        for (int i = 0; i < size1; i++){
            for (int j = 0; j < size2; j++) {
                doublesArray[i][j] = ThreadLocalRandom.current().nextDouble(from, to);
            }
        }
        return doublesArray;
    }

    public void showArray(double[][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    public static void main(String[] args) {

        Task3 task3 = new Task3();
        double[][] one = task3.createDoubleArray(2,3,4,5);
        double[][] two = task3.createDoubleArray(3,4,50,60);
        double[][] three = task3.createDoubleArray(1,4,100,120);
        task3.showArray(one);
        task3.showArray(two);
        task3.showArray(three);
    }
}
