package ru.kirillvenediktov.philosophy.chapter19;

import ru.kirillvenediktov.philosophy.util.Enums;

import java.util.EnumMap;
import java.util.Iterator;

class MailTask9 {

    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;

    Scannability scannability;

    Readability readability;

    Address address;

    ReturnAddress returnAddress;

    static long counter = 0;

    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this +
                ", generalDelivery: " + generalDelivery +
                ", scannability: " + scannability +
                ", readability: " + readability +
                ", address: " + address +
                ", returnAdress: " + returnAddress;
    }

    public static MailTask9 randomMail() {
        MailTask9 mail = new MailTask9();
        mail.generalDelivery = Enums.random(GeneralDelivery.class);
        mail.scannability = Enums.random(Scannability.class);
        mail.readability = Enums.random(Readability.class);
        mail.address = Enums.random(Address.class);
        mail.returnAddress = Enums.random(ReturnAddress.class);
        return mail;
    }

    public static Iterable<MailTask9> generator(final int count) {
        return new Iterable<MailTask9>() {

            int n = count;

            @Override
            public Iterator<MailTask9> iterator() {
                return new Iterator<MailTask9>() {

                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public MailTask9 next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {
//                       не реализованно
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}

public class PostOfficeTask9 {

    private interface Command {

        boolean handle(MailTask9 m);
    }
    
    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(MailTask9 m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(MailTask9 m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(MailTask9 m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(MailTask9 m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(MailTask9 m);
    }

    static void handle(MailTask9 m) {
        for (MailHandler handler : MailHandler.values())
            if (handler.handle(m))
                return;
        System.out.println(m + " is dead letter");
    }

    public static void main(String[] args) {
        for (MailTask9 mail : MailTask9.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}
