package ru.kirillvenediktov.philosophy.chapter5;

enum Money {
    DOLLAR, EURO, RUBLE, POUND, FRANK, GRIVNA
}

public class Task21 {

    public static void main(String[] args) {
        for (Money money : Money.values()){
            System.out.println(money + ", ordinal " + money.ordinal());
        }

        MoneyDescriber describer = new MoneyDescriber();
        describer.describe(Money.EURO);
        describer.describe(Money.DOLLAR);
        describer.describe(Money.RUBLE);
    }
}

class MoneyDescriber {

    public void describe(Money money) {
        System.out.println("Эта валюта ");
        switch (money) {
            case DOLLAR:
                System.out.println("USA valute");
                break;
            case EURO:
                System.out.println("European union valute");
                break;
            case FRANK:
                System.out.println("valute of France");
                break;
            case POUND:
                System.out.println("British valute");
                break;
            case GRIVNA:
                System.out.println("Ukrainan valute");
                break;
            case RUBLE:
                System.out.println("Shit");
                break;
            default:
                System.out.println("Чет хер знает");
        }
    }
}
