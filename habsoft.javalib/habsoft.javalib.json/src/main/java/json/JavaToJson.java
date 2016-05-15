package json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JavaToJson {
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		User faisal = new User();
		obj.put("name", "faisal");
		obj.put("age", new Integer(20));
		obj.put("user", JSONValue.toJSONString(faisal));
		// obj.put("user", faisal);

		System.out.println("ok");

		// JSONArray list = new JSONArray();
		// list.add("msg 1");
		// list.add("msg 2");
		// list.add("msg 3");
		//
		// obj.put("messages", list);

		try {

			FileWriter file = new FileWriter("test.json", false);
			file.write(obj.toString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(obj);

	}
}
