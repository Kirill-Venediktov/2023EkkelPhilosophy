package ru.kirillvenediktov.philosophy.chapter16;

import ru.kirillvenediktov.philosophy.util.CountingGenerator;
import ru.kirillvenediktov.philosophy.util.Generated;

import java.math.BigDecimal;
import java.util.Arrays;

public class Task17 {

    public static void main(String[] args) {
        BigDecimal[] bigDecimals = Generated.array(BigDecimal.class, new CountingGenerator.BigDecimal(), 5);
        System.out.println(Arrays.toString(bigDecimals));
    }
}
