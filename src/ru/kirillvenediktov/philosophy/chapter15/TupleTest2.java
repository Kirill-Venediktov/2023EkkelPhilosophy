package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter11.OfficeCharacter;
import ru.kirillvenediktov.philosophy.chapter7.Amphibian;
import ru.kirillvenediktov.philosophy.util.tuples.FiveTuple;
import ru.kirillvenediktov.philosophy.util.tuples.FourTuple;
import ru.kirillvenediktov.philosophy.util.tuples.SixTuple;
import ru.kirillvenediktov.philosophy.util.tuples.ThreeTuple;
import ru.kirillvenediktov.philosophy.util.tuples.TwoTuple;

import static ru.kirillvenediktov.philosophy.util.tuples.Tuple.tuple;

public class TupleTest2 {

    static TwoTuple<String, Integer> f() {
        return tuple("hi", 47);
    }

    static TwoTuple<String, Integer> f2() {
        return tuple("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static FourTuple<Double, Amphibian, String, Integer> h() {
        return tuple(4.5, new Amphibian(), "hi", 47);
    }

    static FiveTuple<Character, Double, Amphibian, String, Integer> k() {
        return tuple('c',4.5, new Amphibian(), "hi", 47);
    }

    static SixTuple<OfficeCharacter,Character, Double, Amphibian, String, Integer> z() {
        return tuple(OfficeCharacter.DWIGHT,'c',4.5, new Amphibian(), "hi", 47);
    }

    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
        System.out.println(z());
    }
}
