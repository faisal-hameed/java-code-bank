package javatest.j2se.collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String args[]) {
		int count[] = { 34, 22, 10, 60, 30, 22 };
		Set<Integer> set = new HashSet<Integer>();
		try {
			for (int i = 0; i < 6; i++) {
				set.add(count[i]);
			}
			System.out.println("HashSet elements are:");
			System.out.println(set);

			TreeSet sortedSet = new TreeSet<Integer>(set);
			System.out.println("The sorted list is:");
			System.out.println(sortedSet);
			System.out.println("Descending sorting:");
			System.out.println(sortedSet.descendingSet());
			

			System.out.println("The First element of the set is: " + (Integer) sortedSet.first());
			System.out.println("The last element of the set is: " + (Integer) sortedSet.last());

		

			TreeSet<Person> t1 = new TreeSet<Person>();
			t1.add(new Person());
			
			Set<Integer> test = Collections.unmodifiableSet(set);
			test.add(4);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
