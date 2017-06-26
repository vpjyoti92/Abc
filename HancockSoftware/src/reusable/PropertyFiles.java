package reusable;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFiles {

	public static final String CONFIG_PROPRTY_PATH="property-files\\config.properties";
	
	/**
	 * This Method reads the property key value from the "config.properties"
	 * file. Terminates the current execution if "config.properties" file not
	 * found or any exception occurs in the method.
	 * 
	 */
	
	public static String readPropertyValue(String sPropertyName)
	{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PROPRTY_PATH ));
			if(prop.containsKey(sPropertyName))
			{
				return prop.getProperty(sPropertyName);
			}	
			
		} catch (Exception e) {		
			System.out.println("Problem loading Property File :"+e.getMessage());
			e.printStackTrace();
			
		} 
		return null;
	}
	
}
