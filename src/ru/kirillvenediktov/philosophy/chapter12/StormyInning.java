package ru.kirillvenediktov.philosophy.chapter12;

import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.BaseballException;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.Foul;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.PopFoul;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.RainedOut;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.Strike;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.ThrownFromGame;
import ru.kirillvenediktov.philosophy.chapter12.chapter12Exceptions.UmpireException;

abstract class Inning {

    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul, UmpireException;

    public void walk() {

    }
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {

    public StormyInning() throws BaseballException, RainedOut {

    }

    public StormyInning(String s) throws BaseballException, Foul {

    }

//    @Override
//    public void walk() throws PopFoul {
//        super.walk();
//    }


//    @Override
//    public void event() throws RainedOut {
//        super.event();
//    }


    @Override
    public void event() {
    }

    @Override
    public void atBat() throws PopFoul, ThrownFromGame {

    }

    @Override
    public void rainHard() throws RainedOut {

    }

    public static void main(String[] args) {
        StormyInning si = new StormyInning();
        si.atBat();

        Inning i = new StormyInning();
        i.atBat();
//        try {
//
//        } catch (PopFoul e) {
//            System.out.println("Pop Foul");
//        } catch (RainedOut e) {
//            System.out.println("Rained out");
//        } catch (BaseballException e) {
//            System.out.println("Generic Baseball exception");
//        }
//        try {
//            Inning i = new StormyInning();
//            i.atBat();
//        } catch (Strike e) {
//            System.out.println("Strike");
//        } catch (Foul e) {
//            System.out.println("Foul");
//        } catch (RainedOut e) {
//            System.out.println("Rained out");
//        } catch (BaseballException e) {
//            System.out.println("Generic Baseball exception");
//        }
    }
}
