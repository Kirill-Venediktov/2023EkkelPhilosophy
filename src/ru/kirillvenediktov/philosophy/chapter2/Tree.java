package ru.kirillvenediktov.philosophy.chapter2;

/**
 * creates type Tree with two constructors and one info method
 */
public class Tree {

    /**
     * height of tree
     */
    int height;

    /** no argument constructor
     * height = 0
     */
    public Tree() {
        System.out.println("Сажаем росток");
        height = 0;
    }

    /**
     * constructor taking an int argument
     * @param height
     */
    public Tree(int height) {
        this.height = height;
        System.out.println("Создание дерева высотой " + height + " м.");
    }

    /**
     * method print tree height
     */
    void info() {
        System.out.println("Дерево высотой " + height + " м.");
    }

    /*
    Overloaded method. Print tree height with string
     */
    void info(String s) {
        System.out.println(s + ": Дерево высотой " + height + " м.");
    }
}
