package ru.kirillvenediktov.philosophy.chapter19.menu;

import ru.kirillvenediktov.philosophy.util.Enums;

public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    SHAWARMA(Food.Shawarma.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
}
