package org.habsoft.j2se.generics;

public class Box<T> {

    T obj;

    public Box(T t) {
        this.obj = t;
    }

    public void set(T obj) {
        this.obj = obj;
    }

    public T get() {
        return this.obj;
    }

    @Override
    public String toString() {
        return "Box [obj=" + obj + "]";
    }

}
