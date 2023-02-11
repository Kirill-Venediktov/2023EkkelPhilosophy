package ru.kirillvenediktov.philosophy.chapter15;

import ru.kirillvenediktov.philosophy.util.tuples.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static ru.kirillvenediktov.philosophy.util.tuples.Tuple.tuple;

class MixinProxy implements InvocationHandler {

    Map<String, Object> delegatedByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatedByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatedByMethod.containsKey(methodName)) {
                    delegatedByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatedByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple ... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}


public class DynamicProxyMixin {

    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImpl(), Basic.class),
                tuple(new TimeStampedImpl(), TimeStamped.class),
                tuple(new SerialNumberedImpl(), SerialNumbered.class),
                tuple(new ColoredImpl(), Colored.class)
        );
        Basic b = (Basic) mixin;
        TimeStamped timeStamped = (TimeStamped) mixin;
        SerialNumbered serialNumbered = (SerialNumbered) mixin;
        Colored colored = (Colored) mixin;
        b.set("Hello");
        colored.setColor("Red");
        System.out.println(b.get());
        System.out.println(timeStamped.getStamp());
        System.out.println(serialNumbered.getSerialNumber());
        System.out.println(colored.getColor());
    }

}
