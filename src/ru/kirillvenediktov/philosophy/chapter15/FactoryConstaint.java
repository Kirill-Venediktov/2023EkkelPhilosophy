package ru.kirillvenediktov.philosophy.chapter15;

interface FactoryI<T, Q> {

    T create(Q a);
}

class Foo2<T, Q> {

    private T x;

    public <F extends FactoryI<T, Q>> Foo2(F factory, Q a) {
        x = factory.create(a);
    }
}

class IntegerFactory implements FactoryI<Integer, Integer> {

    @Override
    public Integer create(Integer a) {
        return a;
    }
}

class Widget2 {

    public static class Factory implements FactoryI<Widget2, String> {

        @Override
        public Widget2 create(String s) {
            System.out.println(s);
            return new Widget2();
        }
    }
}

public class FactoryConstaint {

    public static void main(String[] args) {
        new Foo2<Integer, Integer>(new IntegerFactory(), 7);
        new Foo2<Widget2, String>(new Widget2.Factory(), "Hello");
    }
}
