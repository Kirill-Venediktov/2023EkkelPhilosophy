package ru.kirillvenediktov.philosophy.chapter13;

import java.util.Formatter;

public class Receipt {

    private static final String TITLE_WIDTH = "%-15s %5s %10s%n";
    private static final String PRODUCTS_FIELD_WIDTH = "%-15.15s %5d %10.2f%n";
    private static final String TAX_FIELD_WIDTH = "%-15s %5s %10.2f%n";
    private static final String TOTAL_FIELD_WIDTH = "%-15.15s %5s %10.2f%n";

    private double total = 0;
    private Formatter formatter = new Formatter(System.out);

    public void printTitle(){
        formatter.format(TITLE_WIDTH, "Item", "Qty", "Price");
        formatter.format(TITLE_WIDTH, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        formatter.format(PRODUCTS_FIELD_WIDTH, name, qty, price);
        total +=price;
    }

    public void printTotal() {
        formatter.format(TAX_FIELD_WIDTH, "Tax", "", total*0.06);
        formatter.format(TITLE_WIDTH, "", "", "-----");
        formatter.format(TOTAL_FIELD_WIDTH, "Total", "", total*1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's magic beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();

    }
}
