package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.exceptions.InvalidParameterException;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {

    private final Random random = new Random();

    public double[][][] create3DArray(int size1, int size2, int size3, double from, double to) {
        if (to < from || to == from) {
            throw new InvalidParameterException("'from' must be less than 'to'");
        }
        double[][][] doublesArray = new double[size1][size2][size3];
        for (int i = 0; i < size1; i++){
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < size3; k++) {
                    doublesArray[i][j][k] = ThreadLocalRandom.current().nextDouble(from, to);
                }

            }
        }
        return doublesArray;
    }

    public void showArray(double[][][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    public static void main(String[] args) {

        Task4 task3 = new Task4();
        double[][][] one = task3.create3DArray(2,3,2,4,5);
        double[][][] two = task3.create3DArray(3,4,5,50,60);
        double[][][] three = task3.create3DArray(1,4,1,100,120);
        task3.showArray(one);
        task3.showArray(two);
        task3.showArray(three);
    }
}
