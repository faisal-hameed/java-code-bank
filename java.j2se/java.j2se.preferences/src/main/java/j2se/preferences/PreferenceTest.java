package j2se.preferences;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.prefs.Preferences;

/*
 * For Encrypted preferences
 * http://www.drdobbs.com/security/encrypted-preferences-in-java/184416587?pgno=1
 */
public class PreferenceTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PreferenceTest test = new PreferenceTest();
		test.setPreference();
	}

	private Preferences prefs;

	public void setPreference() throws ClassNotFoundException, IOException {
		// This will define a node in which the preferences can be stored
		prefs = Preferences.userRoot().node(this.getClass().getName());
		String ID1 = "Test1";
		String ID2 = "Test2";
		String ID3 = "Test3";

		String ID4 = "Object-1";
		int[] obj_1 = { 1, 2, 3 };

		// First we will get the values
		// Define a boolean value
		System.out.println(prefs.getBoolean(ID1, true));
		// Define a string with default "Hello World
		System.out.println(prefs.get(ID2, "Hello World"));
		// Define a integer with default 50
		System.out.println(prefs.getInt(ID3, 50));

		System.out.println(Arrays.toString((int[]) bytes2Object(prefs.getByteArray(ID4, null))));

		// now set the values
		prefs.putBoolean(ID1, false);
		prefs.put(ID2, "Hello Europa");
		prefs.putInt(ID3, 45);
		prefs.putByteArray(ID4, object2Bytes(obj_1));

		// Delete the preference settings for the first value
		prefs.remove(ID1);

	}

	static private byte[] object2Bytes(Object o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		return baos.toByteArray();
	}

	static private Object bytes2Object(byte raw[]) throws IOException, ClassNotFoundException {
		if (raw == null)
			return null;
		ByteArrayInputStream bais = new ByteArrayInputStream(raw);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object o = ois.readObject();
		return o;
	}
}