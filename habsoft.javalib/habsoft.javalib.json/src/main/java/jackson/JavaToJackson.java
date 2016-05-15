package jackson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJackson {
	public static void main(String[] args) {

		List msg = new ArrayList();
		msg.add("abc");
		msg.add("abcd");
		// User user = new User(24, "Faisal ", msg, new Address("", "", ""));
		// System.out.println(user);
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		// mapper.setVisibility(user.getAge(), Visibility.ANY);

		// Setting custom fields
		// DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		// SerializationConfig serConfig = mapper.getSerializationConfig();
		// serConfig.with(dateFormat);
		// DeserializationConfig deserializationConfig =
		// mapper.getDeserializationConfig();
		// deserializationConfig.with(dateFormat);
		// mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
		// false);

		try {

			// convert user object to json string, and save to a file
			// mapper.writeValue(new File("user.json"), user);

			// display to console
			// System.out.println(json);

			List<User> list = new ArrayList<User>();
			for (int i = 0; i < 5; i++) {
				User usr = new User(i + 20, "Faisal " + i, msg, new Address("Pakistan", "Lahore", "St # " + i));
				usr.setMarks(new int[] { 77, 88, 99 });
				list.add(usr);
			}

			mapper.writeValue(new FileWriter("user.jackson"), list);

			String json = mapper.writeValueAsString(list);
			System.out.println(json);

			System.out.println("ok");

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
