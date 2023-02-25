package ru.kirillvenediktov.philosophy.util.tuples;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> implements Comparable {

    public final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TwoTuple &&
                first.equals(((FourTuple<?, ?, ?, ?>) o).first) &&
                second.equals(((FourTuple<?, ?, ?, ?>) o).second) &&
                third.equals(((FourTuple<?, ?, ?, ?>) o).third) &&
                fourth.equals(((FourTuple<?, ?, ?, ?>) o).fourth);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        result = 37 * result + third.hashCode();
        result = 37 * result + fourth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FourTuple{" +
                "fourth=" + fourth +
                ", third=" + third +
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
