package ru.kirillvenediktov.philosophy.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A implements Serializable {

    private B b = new B();

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}

class B implements Serializable {

}

public class Task27 {

    private static final String PATH =
            "C:\\ideaWorkspace\\2023EkkelPhilosophy\\src\\ru\\kirillvenediktov\\philosophy\\chapter18\\forTesting\\task27.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A a = new A();
        System.out.println(a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH));
        out.writeObject(a);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(PATH));
        A a2 = (A) in.readObject();
        System.out.println(a2);
    }

}
