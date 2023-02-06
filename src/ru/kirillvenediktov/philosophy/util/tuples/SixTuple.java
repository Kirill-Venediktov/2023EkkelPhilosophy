package ru.kirillvenediktov.philosophy.util.tuples;

public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {

    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return "SixTuple{" +
                "sixth=" + sixth +
                ", fifth=" + fifth +
                ", fourth=" + fourth +
                ", third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }
}
