package json;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class User implements JSONAware {

	private int age = 15;
	private String name = "faisal 5";
	private List<String> messages = new ArrayList<String>() {
		{
			add("msg 1");
			add("msg 2");
			add("msg 3");
		}
	};

	// getter and setter methods

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", " + "messages=" + messages + "]";
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	// @Override
	// public String toJSONString() {
	// StringBuffer sb = new StringBuffer();
	// sb.append("{");
	//
	// sb.append(JSONObject.escape("age"));
	// sb.append(":");
	// sb.append(age);
	//
	// sb.append(",");
	// sb.append(JSONObject.escape("name"));
	// sb.append(":");
	// sb.append("\"" + JSONObject.escape(name) + "\"");
	//
	// // sb.append(",");
	// // sb.append(JSONObject.escape("ID"));
	// // sb.append(":");
	// // sb.append(id);
	//
	// sb.append("}");
	// return sb.toString();
	// }

	@Override
	public String toJSONString() {
		JSONObject obj = new JSONObject();
		obj.put("age", age);
		obj.put("name", name);
		obj.put("messages", messages);
		return obj.toJSONString();
	}

	// public void writeJSONString(Writer out) throws IOException {
	// LinkedHashMap obj = new LinkedHashMap();
	// obj.put("age", new Integer(age));
	// obj.put("name", name);
	// obj.put("messages", messages);
	// JSONValue.writeJSONString(obj, out);
	// }
}
