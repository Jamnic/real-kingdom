package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import architecture.Utility;

/**
 * Reads given .properties file.
 */
public class PropertiesReader extends Utility {

	/* ========== Public ========== */
	/**
	 * Reads given .properties file, and constructs {@link ConnectionParameters}.
	 */
	public PropertiesReader(String file) {

		properties = new Properties();

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(file);

		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* ========== Private ========== */
	protected final Properties properties;
}
