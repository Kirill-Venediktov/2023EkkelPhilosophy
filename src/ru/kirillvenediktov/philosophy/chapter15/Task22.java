package ru.kirillvenediktov.philosophy.chapter15;

import java.lang.reflect.InvocationTargetException;

class Task22Test {

    private int anInt;

    private String string;

    public Task22Test(Integer anInt, String string) {
        this.anInt = anInt;
        this.string = string;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "Task22Test{" +
                "anInt=" + anInt +
                ", string='" + string + '\'' +
                '}';
    }
}

public class Task22<T> {

    Class<T> kind;

    public Task22(Class<T> kind) {
        this.kind = kind;
    }

    public T createNew(Integer anInt, String s) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class[] cArg = new Class[2];
        cArg[0] = anInt.getClass();
        cArg[1] = s.getClass();
        return kind.getDeclaredConstructor(cArg).newInstance(anInt, s);
    }

    public static void main(String[] args) {
        Task22<Task22Test> task22 = new Task22<>(Task22Test.class);
        try {
            Task22Test test = task22.createNew(12, "Gag");
            System.out.println(test);
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
