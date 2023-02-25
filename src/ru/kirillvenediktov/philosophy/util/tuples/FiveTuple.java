package ru.kirillvenediktov.philosophy.util.tuples;

public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> implements Comparable {

    public E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TwoTuple &&
                first.equals(((FiveTuple<?, ?, ?, ?, ?>) o).first) &&
                second.equals(((FiveTuple<?, ?, ?, ?, ?>) o).second) &&
                third.equals(((FiveTuple<?, ?, ?, ?, ?>) o).third) &&
                fourth.equals(((FiveTuple<?, ?, ?, ?, ?>) o).fourth) &&
                fifth.equals(((FiveTuple<?, ?, ?, ?, ?>) o).fifth);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        result = 37 * result + third.hashCode();
        result = 37 * result + fourth.hashCode();
        result = 37 * result + fifth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FiveTuple{" +
                "fifth=" + fifth +
                ", fourth=" + fourth +
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
