package jackson1;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JavaToJackson {
	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		mapper.enableDefaultTyping();
//		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		// mapper.setVisibility(user.getAge(), Visibility.ANY);

		// DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		// SerializationConfig serConfig = mapper.getSerializationConfig();
		// serConfig.with(dateFormat);
		// DeserializationConfig deserializationConfig =
		// mapper.getDeserializationConfig();
		// deserializationConfig.with(dateFormat);
		// mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
		// false);

		try {
			Person p = new Student("Faisalll", 24, "MIT");
			p.setAge(24);
			p.setName("Faisal");

			Person p2 = new Teacher("Faisalll", 24, 40000);
			p2.setAge(32);
			p2.setName("Ali");

			mapper.writeValue(new FileWriter("student.jackson"), p);
			// mapper.writerWithType(Student.class).writeValue(new
			// FileWriter("student.jackson"), p);

			String json = mapper.writeValueAsString(p);
			System.out.println(p);

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
