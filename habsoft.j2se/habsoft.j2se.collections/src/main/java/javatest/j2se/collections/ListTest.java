package javatest.j2se.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {
	public static void main(String[] args) {
		
		List<String> a = new ArrayList<String>();
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.trimToSize();

//		
//		a1.add(null);
//		a1.get(3);
		
		LinkedList<String> a2 = new LinkedList<String>();
		//a2.get(3);
		
		int[] arr = {1,2,3,4};
		int t = 0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[t = i]);
			System.out.println(t);
		}
		
		
		Vector v = new Vector();
		
	} 
	
}
