package jackson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonToJava {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		// mapper.setVisibility(user.getAge(), Visibility.ANY);
		// mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
		// true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

		try {

			// convert user object to json string, and save to a file
			// mapper.writeValue(new File("user.json"), user);
			ArrayList<User> list = mapper.readValue(new File("user.jackson"), ArrayList.class);

			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}

			// display to console
			System.out.println(mapper.writeValueAsString(list));

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
