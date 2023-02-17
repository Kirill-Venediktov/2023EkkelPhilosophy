package ru.kirillvenediktov.philosophy.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer, String> {

    private int size;

    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if (size < 0) {
            this.size = 0;
        }
        this.size = size;
    }

    private static class Entry implements Map.Entry<Integer, String> {

        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + index / chars.length;
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return index == entry.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }

    class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

        private int entrySetSize;

        public EntrySet(int entrySetSize) {
            if (entrySetSize < 0) {
                this.entrySetSize = 0;
            } else if (entrySetSize > size) {
                this.entrySetSize = size;
            } else {
                this.entrySetSize = entrySetSize;
            }
        }

        public int size() {
            return entrySetSize;
        }

        private class Iter implements Iterator<Map.Entry<Integer, String>> {

            private Entry entry = new Entry(-1);

            @Override
            public boolean hasNext() {
                return entry.index < entrySetSize - 1;
            }

            @Override
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new EntrySet.Iter();
        }
    }

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer, String>> entries = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        CountingMapData mapData = new CountingMapData(60);
        Set<Map.Entry<Integer, String>> entries = mapData.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
