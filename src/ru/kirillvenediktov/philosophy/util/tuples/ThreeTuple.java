package ru.kirillvenediktov.philosophy.util.tuples;

public class ThreeTuple<A, B, C> extends TwoTuple<A, B> implements Comparable {

    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TwoTuple &&
                first.equals(((ThreeTuple<?, ?, ?>) o).first) &&
                second.equals(((ThreeTuple<?, ?, ?>) o).second) &&
                third.equals(((ThreeTuple<?, ?, ?>) o).third);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        result = 37 * result + third.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                ", first=" + first +
                ", second=" + second +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }
}
