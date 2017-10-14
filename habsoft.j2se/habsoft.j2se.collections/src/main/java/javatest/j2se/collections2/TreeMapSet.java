package javatest.j2se.collections2;

import java.util.*;

public class TreeMapSet {

    public static void main(String[] args) {
        List list = new ArrayList();
        Map treeMap = new TreeMap();
        Set<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o1.compareTo(o2);
            }

            @Override
            public Comparator<Integer> reversed() {
                // TODO Auto-generated method stub
                return Comparator.super.reversed();
            }

        });

        list.add(new Integer(1));
        list.add(new Integer(4));
        list.add(new Integer(3));
        list.add(new Integer(2));
        list.add(new Integer(3));

        // sorted by keys
        treeMap.put(new Integer(1), "A");
        treeMap.put(new Integer(4), "B");
        treeMap.put(new Integer(3), "C");
        treeMap.put(new Integer(2), "D");
        treeMap.put(new Integer(3), "E");

        // sorted by keys
        treeSet.add(new Integer(1));
        treeSet.add(new Integer(4));
        treeSet.add(new Integer(3));
        treeSet.add(new Integer(2));
        treeSet.add(new Integer(3));

        System.out.println("List");
        Iterator i = list.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        System.out.println("Map using keys");
        i = treeMap.keySet().iterator();
        while (i.hasNext())
            System.out.println(treeMap.get(i.next()));

        System.out.println("Map using entries");
        i = treeMap.entrySet().iterator();
        while (i.hasNext())
            System.out.println(i.next());

        System.out.println("TreeSet");
        i = treeSet.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
