package javatest.j2se.collections;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put("Zara", "8");
		m1.put("Mahnaz", "31");
		m1.put("Ayan", "12");
		m1.put("Daisy", "14");
		m1.put(null, "test");
		System.out.println();
		System.out.println(" Map Elements");
		System.out.println("\t" + m1);
		
		System.out.println("res : "+m1.get(null));
		
		
	}
}