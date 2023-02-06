package ru.kirillvenediktov.philosophy.chapter14;

interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        long start = System.currentTimeMillis();
        System.out.println("Do something");
        long finish = System.currentTimeMillis();
        System.out.println(this + " doSomething() time =" + (finish - start) + " мс");
    }

    @Override
    public void somethingElse(String arg) {
        long start = System.currentTimeMillis();
        System.out.println("something else " + arg);
        long finish = System.currentTimeMillis();
        System.out.println(this + " somethingElse() time =" + (finish - start) + " мс");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long start = System.currentTimeMillis();
        System.out.println("Simple Proxy doSomething");
        proxied.doSomething();
        long finish = System.currentTimeMillis();
        System.out.println(this + " doSomething() time =" + (finish - start) + " мс");
    }

    @Override
    public void somethingElse(String arg) {
        long start = System.currentTimeMillis();
        System.out.println("Simple Proxy somethingElse " + arg);
        proxied.somethingElse(arg);
        long finish = System.currentTimeMillis();
        System.out.println(this + " somethingElse() time =" + (finish - start) + " мс");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        long start = System.currentTimeMillis();
        iface.doSomething();
        iface.somethingElse("bonobo");
        long finish = System.currentTimeMillis();
        System.out.println(iface + " consumer() time =" + (finish - start) + " мс");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
