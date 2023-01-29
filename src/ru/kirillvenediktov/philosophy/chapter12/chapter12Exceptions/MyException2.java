package ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class MyException2 extends Exception {

    private static Logger logger = Logger.getLogger("LoggingException");

    public MyException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
