package ru.kirillvenediktov.philosophy.chapter14;

import ru.kirillvenediktov.philosophy.chapter14.task25.Task25;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Task25Invoker {

    private static final List<String> METHOD_NAMES = Arrays.asList(
            "privateMethod","protectedMethod", "packagePrivateMethod");

    public void callTask25Methods(Task25 task25) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        for (String name : METHOD_NAMES) {
            Method method = task25.getClass().getDeclaredMethod(name);
            method.setAccessible(true);
            method.invoke(task25);
        }
    }

    public static void main(String[] args) {
        Task25 task25 = new Task25();
        Task25Invoker invoker = new Task25Invoker();
        try {
            invoker.callTask25Methods(task25);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        task25.privateMethod();

    }
}
