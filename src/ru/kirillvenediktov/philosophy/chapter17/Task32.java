package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class Task32 {

    private int[] storage;

    private static final int DEFAULT_SIZE = 20;

    private static final int ADDITION = 10;

    public Task32() {
        storage = new int[DEFAULT_SIZE];
    }

    public Task32(int size) {
        storage = new int[size];
    }

    private boolean addToArray(int item) {
        boolean modified = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == 0) {
                storage[i] = item;
                modified = true;
                break;
            }
        }
        return modified;
    }

    private void increaseStorage() {
        int[] newStorage = new int[storage.length + ADDITION];
        for (int i : storage) {
            if (i != 0) {
                for (int j = 0; j < newStorage.length; j++) {
                    if (newStorage[j] == 0) {
                        newStorage[j] = i;
                        break;
                    }
                }
            }
        }
        storage = newStorage;
    }

    public void add(int i) {
        while (!addToArray(i)) {
            increaseStorage();
        }
    }

    public boolean remove(int index) {
        boolean modified = false;
        if (index < storage.length) {
            storage[index] = 0;
            modified = true;
        }
        return modified;
    }

    public boolean removeItem(int item) {
        boolean modified = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == item) {
                storage[i] = 0;
                modified = true;
                break;
            }
        }
        return modified;
    }

    public int size() {
        return storage.length;
    }

    public void clear() {
        storage = new int[DEFAULT_SIZE];
    }

    @Override
    public String toString() {
        return "Task31{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }

    public static void main(String[] args) {
        RandomGenerator.Integer rg = new RandomGenerator.Integer();
        Task32 task31 = new Task32();
        for (int i = 0; i < 50; i++) {
            task31.add(rg.next());
        }
        System.out.println(task31);
        System.out.println(task31.size());

    }
}

class Task32Test {

    public static long addTimeTest(Task32 list, int iter) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.add(5);
        }
        long finish = System.nanoTime();
        return (finish - start) / iter;
    }

    public static long addTimeTest(ArrayList<Integer> list, int iter) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.add(5);
        }
        long finish = System.nanoTime();
        return (finish - start) / iter;
    }

    public static long removeTimeTest(Task32 list, int iter) {
        list.clear();
        for (int i = 0; i < iter; i++) {
            list.add(5);
        }
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.remove(i);
        }
        long finish = System.nanoTime();
        return (finish - start) / iter;
    }

    public static long removeTimeTest(ArrayList<Integer> list, int iter) {
        list.clear();
        for (int i = 0; i < iter; i++) {
            list.add(5);
        }
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.remove(0);
        }
        long finish = System.nanoTime();
        return (finish - start) / iter;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Task32 task32 = new Task32();
        System.out.println("Add times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + addTimeTest(task32, 10));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + addTimeTest(task32, 100));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 100));
        System.out.println("1 000");
        System.out.println("Task31: " + addTimeTest(task32, 1000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + addTimeTest(task32, 10000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10000));
        System.out.println("Remove times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + removeTimeTest(task32, 10));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + removeTimeTest(task32, 100));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 100));
        System.out.println("1000");
        System.out.println("Task31: " + removeTimeTest(task32, 1000));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + removeTimeTest(task32, 10000));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 10000));
    }

}