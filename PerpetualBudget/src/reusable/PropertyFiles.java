package reusable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyFiles {
	
	private final static String CONFIG_PROPERTY_PATH = "property-files/config.properties";
	private final static String CONFIG_PROPERTY_PATH_LOCAL = "property-files/local-storage.properties";
	
	/**
	 * This Method reads the property key value from the "config.properties"
	 * file. Terminates the current execution if "config.properties" file not
	 * found or any exception occurs in the method.
	 * 
	 * @param sPropertyName
	 *            - property key name in the config.properties file
	 * @return property key value from the config.properties file
	 * @return null if property key name not found.
	 */
	public static String ReadPropertyValue(String sPropertyName) {

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(CONFIG_PROPERTY_PATH));
			if (prop.containsKey(sPropertyName)) {
				return prop.getProperty(sPropertyName);
			}
		} catch (Exception e) {
			System.out.println("Problem Reading Property File; Terminating Execution");
			System.exit(0); // Stops the Execution If No Property Value Found
		}
		return null;
	}
	
	/**
	 * This method replaces the property value in the config.properties file
	 * @param sPropertyKey
	 * @param sPropertyValue
	 */
	public static void ReplacePropertyValue(String sPropertyKey, String sPropertyValue){
		try{
			FileInputStream in = new FileInputStream(CONFIG_PROPERTY_PATH);
			Properties props = new Properties();
			props.load(in);
			in.close();
			props.replace(sPropertyKey, sPropertyValue);
			FileOutputStream out = new FileOutputStream(CONFIG_PROPERTY_PATH);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out.println("Problem Reading Property File In ReplacePropertyValue; Terminating Execution " +e.getMessage());
			System.exit(0); // Stops the Execution If No Property Value Found
		}
	}
	
	/**
	 * This Method reads the property key value from the "local-storage.properties" file.
	 * @param sPropertyName
	 *            - property key name in the local-storage.properties file
	 * @return property key value from the local-storage.properties file
	 * @return null if property key name not found.
	 */
	public static String ReadPropertyValueLocalStorage(String sPropertyName) {

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(CONFIG_PROPERTY_PATH_LOCAL));
			if (prop.containsKey(sPropertyName)) {
				return prop.getProperty(sPropertyName);
			}
		} catch (Exception e) {
			System.out.println("Problem Reading Local Storage Property File; Terminating Execution");
		}
		return null;
	}
	
	/**
	 * This method replaces the property value in the local-storage.properties file
	 * @param sPropertyKey
	 * @param sPropertyValue
	 */
	public static void ReplacePropertyValueLocalStorage(String sPropertyKey, String sPropertyValue){
		try{
			FileInputStream in = new FileInputStream(CONFIG_PROPERTY_PATH_LOCAL);
			Properties props = new Properties();
			props.load(in);
			in.close();
			props.replace(sPropertyKey, sPropertyValue);
			FileOutputStream out = new FileOutputStream(CONFIG_PROPERTY_PATH_LOCAL);
			props.store(out, null);
			out.close();
		} catch (Exception e) {
			System.out.println("Problem Reading Property File In ReplacePropertyValue local storage; Terminating Execution " +e.getMessage());
		}
	}
}
