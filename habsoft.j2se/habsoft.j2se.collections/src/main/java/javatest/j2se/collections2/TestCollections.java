package javatest.j2se.collections2;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;

public class TestCollections {
	public static void main(String[] args) {
		/*
		 * Ordered Duplicate Sorted 
		 * Set No No No 
		 * (HashSet,LinkedHashSet,TreetSet, EnumSet ) Sequence (List) Yes Yes No 
		 * (Vector, Stack, LinkedList, ArrayList, Queue) Map Yes No Yes 
		 * (Hashtable,HashMap, LinkedHashMap, WeakHashMap, IdentityHashMap, TreeMap)
		 */
		Vector<Person> vec = new Vector<Person>();
		vec.add(new Person("Tahir", "Akram", "takram@ab.com", 3434433445L));
		vec.add(new Person("Amir", "Moin", "talha@ab.com", 3434433445L));
		vec.add(new Person("Tayyab", "Ejaz", "tejaz@ab.com", 445567L));
		vec.add(new Person("Ghaus", "Mehmood", "gmehmood@ab.com", 33345445566L));

		Collections.sort(vec);
		Collections.sort(vec, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				int index = o1.getFirstName().compareTo(o2.getFirstName());
				if (index == 0) {
					index = o1.getLastName().compareTo(o2.getLastName());
					if (index == 0) {
						index = o1.getEmail().compareTo(o2.getEmail());
						if (index == 0) {
							index = o1.getPhNumber().compareTo(o2.getPhNumber());
						}
					}
				}
				return index;
			}
		});

		Date date;
		Time time;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 20);
		date = cal.getTime();

		System.currentTimeMillis();

		SimpleDateFormat sdf = new SimpleDateFormat();

		// try {
		// Process p = Runtime.getRuntime().exec("abc.bat");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}
}