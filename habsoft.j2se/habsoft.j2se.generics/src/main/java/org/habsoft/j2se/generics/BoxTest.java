package org.habsoft.j2se.generics;

/**
 * Hello world!
 *
 */
public class BoxTest {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(5);

        Box<String> strBox = new Box<>("Black");

        System.out.println(intBox);
        System.out.println(strBox);

        Box rawBox = new Box<>(new Object());

        rawBox = intBox;

        rawBox.set("Invalid");
        rawBox.set(6);
        System.out.println(rawBox);

    }
}
