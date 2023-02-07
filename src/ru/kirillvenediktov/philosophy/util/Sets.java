package ru.kirillvenediktov.philosophy.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        try {
            if(a instanceof EnumSet) {
                Set<T> result = ((EnumSet)a).clone();
                result.addAll(b);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        try {
            if(a instanceof EnumSet) {
                Set<T> result = ((EnumSet)a).clone();
                result.retainAll(b);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    // Subtract subset from superset:
    public static <T> Set<T>  difference(Set<T> superset, Set<T> subset) {
        try {
            if(superset instanceof EnumSet) {
                Set<T> result = ((EnumSet)superset).clone();
                result.removeAll(subset);
                return result;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }
}
