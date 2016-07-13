import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggerTest {
	static Logger LOGGER = LoggerFactory.getLogger(Slf4jLoggerTest.class);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++)
			if (i % 2 == 0)
				LOGGER.info("Hello {}", i);
			else
				LOGGER.debug("I am on index {}", i);

		exceptionLog();
	}

	private static void exceptionLog() {
		String wrongInt = "aa22";

		try {
			int a = Integer.parseInt(wrongInt);
		} catch (NumberFormatException e) {
			LOGGER.error("Unable to parse {}", wrongInt, e);
		}
	}
}