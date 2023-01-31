package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.MyException;

public class Task21 {

    public Task21() throws MyException {
        throw new MyException("Exception text");
    }
}

class Task21Satelite extends Task21 {

    public Task21Satelite() throws MyException {
//        try {
//            super();
//        } catch (MyException e) {
//            e.printStackTrace();
//        }

    }
}
