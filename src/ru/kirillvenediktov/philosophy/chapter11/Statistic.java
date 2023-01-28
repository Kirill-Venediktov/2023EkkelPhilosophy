package ru.kirillvenediktov.philosophy.chapter11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Statistic {

    private static final int LIMIT = 600;
    private Random random = new Random();

    public void analiseStatistic() {
        int count = 0;
        int number = 0;
        boolean isBeyond = false;
        Map<Integer, Integer> statistic = null;
        while (!isBeyond) {
            count++;
            statistic = getStatisticMap();
            Iterator<Map.Entry<Integer, Integer>> iterator = statistic.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() > LIMIT) {
                    number = entry.getKey();
                    isBeyond = true;
                    break;
                }
            }
        }
        System.out.println(statistic);
        System.out.println("Число " + number + " встретилось более 600 раз.");
        System.out.println("Потребовалось " + count + " проходов");

    }

    public Map<Integer, Integer> getStatisticMap() {

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        Statistic statistic = new Statistic();
        statistic.analiseStatistic();
    }
}
