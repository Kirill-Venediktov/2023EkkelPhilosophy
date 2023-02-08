package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.chapter6_1.access.Widget;

interface FactoryI<T> {

    T create(int a);
}

class Foo2<T> {

    private T x;

    public <F extends FactoryI<T>> Foo2(F factory, int a) {
        x = factory.create(a);
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create(int a) {
        return a;
    }
}

class Widget2 {

    public static class Factory implements FactoryI<Widget2> {

        @Override
        public Widget2 create(int a) {
            return new Widget2();
        }
    }
}

public class FactoryConstaint {

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory(), 7);
        new Foo2<Widget>(new Widget2.Factory(), 8);

    }
}
