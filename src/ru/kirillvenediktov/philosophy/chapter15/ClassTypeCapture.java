package ru.kirillvenediktov.philosophy.chapter15;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

class Building {

}

class House extends Building {

}

public class ClassTypeCapture<T> {

    Map<String, Class<?>> map = new HashMap<>();

    public ClassTypeCapture(Class<T> kind) {
        map.put(kind.getName(), kind);
    }

    public boolean f(Object arg) {
        return f(arg.getClass().getName());
    }

    public boolean f(String className) {
        boolean isPresent = false;
        if (map.get(className) != null) {
            isPresent = true;
        }
        return isPresent;
    }

    public Class<?> addType(String typename, Class<?> kind) {
        return map.put(typename, kind);
    }

    public Object createNew(String typename) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        if (f(typename)) {
            return map.get(typename).getDeclaredConstructor().newInstance();
        } else {
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        ctt1.addType("java.lang.String", String.class);
        System.out.println(ctt1.map);

        try {
            System.out.println(ctt1.createNew("java.lang.String").toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
