package org.habsoft.j2se.generics;

public class BoundedBoxTest {

    public static void main(String[] args) {
        BoundedBox<Integer> b1 = new BoundedBox<>(4);
        BoundedBox<Double> b2 = new BoundedBox<>(5.4);

        inspect(b1);
        inspect(b2);
    }

    public static <T extends Number> void inspect(BoundedBox<T> boundedBox) {
        System.out.println("Class name is : " + boundedBox.get().getClass().getName());
    }
}

class BoundedBox<T extends Number> {

    T value;

    public BoundedBox(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
