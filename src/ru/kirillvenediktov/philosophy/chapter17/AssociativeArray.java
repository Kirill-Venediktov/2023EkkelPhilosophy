package ru.kirillvenediktov.philosophy.chapter17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AssociativeArray<K, V> {

    private Object[][] pairs;

    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        if (!containsKey(key)){
            pairs[index++] = new Object[]{key, value};
        } else {
            for (int i = 0; i < index; i++) {
                if (key.equals(pairs[i][0])){
                    pairs[i][1] = value;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }

    public boolean containsKey(K key) {
        boolean contains = false;
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])){
                contains = true;
                break;
            }
        }
        return contains;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> associativeArray = new AssociativeArray<>(6);
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        associativeArray.put("sky", "blue");
        hashMap.put("sky", "blue");
        treeMap.put("sky", "blue");
        linkedHashMap.put("sky", "blue");
        associativeArray.put("grass", "green");
        hashMap.put("grass", "green");
        treeMap.put("grass", "green");
        linkedHashMap.put("grass", "green");
        associativeArray.put("ocean", "dancing");
        hashMap.put("ocean", "dancing");
        treeMap.put("ocean", "dancing");
        linkedHashMap.put("ocean", "dancing");
        associativeArray.put("tree", "tall");
        hashMap.put("tree", "tall");
        treeMap.put("tree", "tall");
        linkedHashMap.put("tree", "tall");
        associativeArray.put("earth", "brown");
        hashMap.put("earth", "brown");
        treeMap.put("earth", "brown");
        linkedHashMap.put("earth", "brown");
        associativeArray.put("sun", "warm");
        hashMap.put("sun", "warm");
        treeMap.put("sun", "warm");
        linkedHashMap.put("sun", "warm");

        try {
            associativeArray.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(associativeArray);
        System.out.println(hashMap);
        System.out.println(treeMap);
        System.out.println(linkedHashMap);
        System.out.println(associativeArray.get("ocean"));
        System.out.println(hashMap.get("ocean"));
        System.out.println(treeMap.get("ocean"));
        System.out.println(linkedHashMap.get("ocean"));
    }

}
