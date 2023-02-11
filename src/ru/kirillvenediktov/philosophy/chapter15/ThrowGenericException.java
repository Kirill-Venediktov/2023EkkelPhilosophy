package ru.kirillvenediktov.philosophy.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Processor<T, E extends Exception, V extends Exception> {

    void process(List<T> resultCollector) throws E, V;

}

class ProcessRunner<T, E extends Exception, V extends Exception> extends ArrayList<Processor<T, E, V>> {

    List<T> processAll() throws E, V {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E, V> processor : this) {
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}

class Failure1 extends Exception {

}

class Failure2 extends Exception {

}

class Processor1 implements Processor<String, Failure1, Failure2> {

    private static Random random = new Random();

    @Override
    public void process(List<String> resultCollector) throws Failure1, Failure2 {

        int count = random.nextInt(4);

        switch (count) {
            case 0:
                resultCollector.add("Hep!");
                break;
            case 1:
                resultCollector.add("Ho!");
                break;
            case 2:
                throw new Failure1();
            case 3:
                throw new Failure2();
            default:
        }
    }
}

class Failure3 extends Exception {

}

class Failure4 extends Exception {

}

class Processor2 implements Processor<String, Failure3, Failure4> {

    private static Random random = new Random();

    @Override
    public void process(List<String> resultCollector) throws Failure3, Failure4 {

        int count = random.nextInt(4);

        switch (count) {
            case 0:
                resultCollector.add("Hep!");
                break;
            case 1:
                resultCollector.add("Ho!");
                break;
            case 2:
                throw new Failure3();
            case 3:
                throw new Failure4();
            default:
        }
    }
}

public class ThrowGenericException {

    public static void main(String[] args) {
        ProcessRunner<String, Failure1, Failure2> processRunner = new ProcessRunner<>();

        for (int i = 0; i < 3; i++) {
            processRunner.add(new Processor1());
        }
        try {
            System.out.println(processRunner.processAll());
        } catch (Failure1 | Failure2 failure1) {
            System.out.println(failure1);
        }

        ProcessRunner<String, Failure3, Failure4> processRunner2 = new ProcessRunner<>();

        for (int i = 0; i < 3; i++) {
            processRunner2.add(new Processor2());
        }
        try {
            System.out.println(processRunner2.processAll());
        } catch (Failure3 | Failure4 failure) {
            System.out.println(failure);
        }

    }

}
