package jackson1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonToJava {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		try {

			Person student = mapper.readValue(new File("student.jackson"), Person.class);
			if (student instanceof Student) {
				System.out.println("It is Student");
				System.out.println(student);
			}
			if (student instanceof Teacher) {
				System.out.println("It is Teacher");
				System.out.println(student);
			}

			// display to console
			System.out.println(mapper.writeValueAsString(student));

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
