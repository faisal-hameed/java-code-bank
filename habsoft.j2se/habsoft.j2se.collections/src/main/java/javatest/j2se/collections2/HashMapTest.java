package javatest.j2se.collections2;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	public static void main(String[] args) {
		// Hash Map
		System.out.println("Hash Map");
		Map m = new HashMap();
		Person p = new Person("aa", "bb", "aaaaaa", 123133l);
		m.put("a", p);
		m.put("b", p);
		m.put("c", p);
		Iterator<String> iter = m.keySet().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		Person p2 = (Person) m.get("a");
		p2.setEmail("new email");
		// m.put("b", "p2");

		System.out.println(m.get("ass"));
		// System.out.println(m.size());
		// System.out.println(m.toString());

		System.out.println("Test Dictionary");
		Dictionary<String, Person> mapping = new Hashtable<String, Person>();
		mapping.put("a", p2);
		mapping.put("b", p2);
		mapping.put("c", p2);

		Enumeration<String> enumm = mapping.keys();
		while (enumm.hasMoreElements()) {
			System.out.println(enumm.nextElement());
		}

		// Concurrent Hash Map
		System.out.println("Concurrent Hash Map");
		ConcurrentHashMap<String, String> chp = new ConcurrentHashMap<String, String>();
		chp.put("a", "aa");
		chp.put("b", "aa");
		chp.put("c", "aa");

		enumm = chp.keys();
		while (enumm.hasMoreElements()) {
			System.out.println(enumm.nextElement());
		}
	}
}
