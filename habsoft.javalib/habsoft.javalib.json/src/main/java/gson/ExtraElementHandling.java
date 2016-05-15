package gson;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ExtraElementHandling {
	public static void main(String[] args) throws Exception {
		// input: {"name":"Spike","breed":"Collie"}
		String json = "{\"name\":\"Spike\",\"breed\":\"Collie\"}";

		Gson gson = new Gson();
		Dog dog1 = gson.fromJson(json, Dog.class);
		System.out.println(gson.toJson(dog1));
		// output: {"name":"Spike"}

		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false);

		Dog dog2 = mapper.readValue(json, Dog.class);
		System.out.println(mapper.writeValueAsString(dog2));
		// output: {"name":"Spike"}
	}
}

// alternative to configuring ObjectMapper
@JsonIgnoreProperties(ignoreUnknown = true)
class Dog {
	public String name;

	@JsonAnySetter
	public void handleUnknown(String key, Object value) {
		System.out.println("Unable to set key = " + key + "  value = " + value);
	}
}
