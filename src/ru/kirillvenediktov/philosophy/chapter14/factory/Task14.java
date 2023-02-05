package ru.kirillvenediktov.philosophy.chapter14.factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Task14 {

    private static final List<Class<? extends Part>> allTypes = Collections.unmodifiableList(
            Arrays.asList(FuelFilter.class, AirFilter.class, CabinFilter.class, OilFilter.class, FanBelt.class,
                    PowerSteeringBelt.class, GeneratorBelt.class));

    private static Random random = new Random();

    public static Part createRandom() throws IllegalAccessException, InstantiationException {
        return allTypes.get(random.nextInt(allTypes.size())).newInstance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(Task14.createRandom());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
