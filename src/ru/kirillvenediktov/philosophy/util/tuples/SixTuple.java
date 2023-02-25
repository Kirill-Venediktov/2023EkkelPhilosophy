package ru.kirillvenediktov.philosophy.util.tuples;

public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> implements Comparable{

    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TwoTuple &&
                first.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).first) &&
                second.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).second) &&
                third.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).third) &&
                fourth.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).fourth) &&
                fifth.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).fifth) &&
                sixth.equals(((SixTuple<?, ?, ?, ?, ?, ?>) o).sixth);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        result = 37 * result + third.hashCode();
        result = 37 * result + fourth.hashCode();
        result = 37 * result + fifth.hashCode();
        result = 37 * result + sixth.hashCode();
        return result;
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

    @Override
    public int compareTo(Object o) {
        if (o == null) throw new ClassCastException();
        return Integer.compare(hashCode(),o.hashCode());
    }
}
