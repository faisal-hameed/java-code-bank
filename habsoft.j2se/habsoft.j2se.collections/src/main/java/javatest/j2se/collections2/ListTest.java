package javatest.j2se.collections2;

import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("aa");
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		System.out.println(list.contains(new String("aa")));
		System.out.println(list.contains(("aa")));
		
		System.out.println(list.get(0));
	}
}
