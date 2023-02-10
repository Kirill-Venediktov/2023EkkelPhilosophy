package ru.kirillvenediktov.philosophy.chapter15;

import java.util.List;

public class Task29 {

    public void methodOne(Holder<List<?>> holder) {
        System.out.println(holder.equals(null));
        System.out.println(holder.getValue());
        System.out.println(holder.hashCode());
        holder.getValue();
    }

    public void methodTwo(List<Holder<?>> list) {
//        list.get(0).
    }
}
