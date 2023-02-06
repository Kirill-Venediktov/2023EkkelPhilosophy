package ru.kirillvenediktov.philosophy.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy);
        System.out.println("*** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object o : args) {
                System.out.println(" " + o);
            }
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        long start = System.currentTimeMillis();
        iface.doSomething();
        iface.somethingElse("bonobo");
        long finish = System.currentTimeMillis();
        System.out.println(iface + " consumer() time =" + (finish - start) + " мс");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
