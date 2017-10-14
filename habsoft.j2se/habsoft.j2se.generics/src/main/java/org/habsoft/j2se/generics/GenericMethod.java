package org.habsoft.j2se.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {
    public static void main(String[] args) {

        List<Box<?>> objects = new ArrayList<>();

        objects.add(new Box<>(4));
        objects.add(new Box<>("a"));
        objects.add(new Box<>("z"));
        objects.add(new Box<>(1));

        System.out.println(compare(new Box<>(1), new Box<>(4)));
        System.out.println(compare(new Box<>(1), new Box<>(1)));

    }

    public static <T> boolean compare(Box<T> b1, Box<T> b2) {
        return b1.get().equals(b2.get());
    }
}
