package ru.kirillvenediktov.philosophy.chapter16;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<List<String>> lls;
        List list = new ArrayList();
        lls = list;
        lls.add(new ArrayList<>());

//        lls.add(new ArrayList<Integer>());

//        ls[1] = new ArrayList<Integer>();

//        List<List<Object>> objects = lls;
//
//        Object[] objects = ls;
//        objects[1] = new ArrayList<Integer>();

        List<List<BerylliumSphere>> spheresList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            spheresList.add(new ArrayList<>());
        }

    }
}
