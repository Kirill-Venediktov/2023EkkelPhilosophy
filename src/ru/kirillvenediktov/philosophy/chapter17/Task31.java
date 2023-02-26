package ru.kirillvenediktov.philosophy.chapter17;

import ru.kirillvenediktov.philosophy.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class Task31 {

    private String[] storage;

    private static final int DEFAULT_SIZE = 20;

    private static final int ADDITION = 10;

    public Task31() {
        storage = new String[DEFAULT_SIZE];
    }

    public Task31(int size) {
        storage = new String[size];
    }

    private boolean addToArray(String s) {
        boolean modified = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = s;
                modified = true;
                break;
            }
        }
        return modified;
    }

    private void increaseStorage() {
        String[] newStorage = new String[storage.length + ADDITION];
        for (String s : storage) {
            if (s != null) {
                for (int j = 0; j < newStorage.length; j++) {
                    if (newStorage[j] == null) {
                        newStorage[j] = s;
                        break;
                    }
                }
            }
        }
        storage = newStorage;
    }

    public void add(String s) {
        while (!addToArray(s)){
            increaseStorage();
        }
    }

    public boolean remove(int index) {
        boolean modified = false;
        if (index < storage.length) {
            storage[index] = null;
            modified = true;
        }
        return modified;
    }

    public boolean remove(String s) {
        boolean modified = false;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(s)) {
                storage[i] = null;
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
        storage = new String[DEFAULT_SIZE];
    }

    @Override
    public String toString() {
        return "Task31{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }

    public static void main(String[] args) {
        RandomGenerator.String rg = new RandomGenerator.String();
        Task31 task31 = new Task31();
        for (int i = 0; i < 50; i++) {
            task31.add(rg.next());
        }
        System.out.println(task31);
        System.out.println(task31.size());

    }
}

class Task31Test {

    public static long addTimeTest(Task31 list, int iter) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.add("hi");
        }
        long finish = System.nanoTime();
        return (finish - start)/iter;
    }

    public static long addTimeTest(ArrayList<String> list, int iter) {
        list.clear();
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.add("hi");
        }
        long finish = System.nanoTime();
        return (finish - start)/iter;
    }

    public static long removeTimeTest(Task31 list, int iter) {
        list.clear();
        for (int i = 0; i < iter; i++) {
            list.add("hi");
        }
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.remove(i);
        }
        long finish = System.nanoTime();
        return (finish - start)/iter;
    }

    public static long removeTimeTest(ArrayList<String> list, int iter) {
        list.clear();
        for (int i = 0; i < iter; i++) {
            list.add("hi");
        }
        long start = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            list.remove(0);
        }
        long finish = System.nanoTime();
        return (finish - start)/iter;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Task31 task31 = new Task31();
        System.out.println("Add times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + addTimeTest(task31, 10));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + addTimeTest(task31, 100));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 100));
        System.out.println("1 000");
        System.out.println("Task31: " + addTimeTest(task31, 1000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + addTimeTest(task31, 10000));
        System.out.println("ArrayList: " + addTimeTest(arrayList, 10000));
        System.out.println("Remove times (ns)");
        System.out.println("10");
        System.out.println("Task31: " + removeTimeTest(task31, 10));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 10));
        System.out.println("100");
        System.out.println("Task31: " + removeTimeTest(task31, 100));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 100));
        System.out.println("1000");
        System.out.println("Task31: " + removeTimeTest(task31, 1000));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 1000));
        System.out.println("10 000");
        System.out.println("Task31: " + removeTimeTest(task31, 10000));
        System.out.println("ArrayList: " + removeTimeTest(arrayList, 10000));
    }

}