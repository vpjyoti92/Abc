package reusableFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.android.AndroidDriver;

public class ReusableFunctions {

	static Properties ObjectMapPros;
	static Properties properties;
	static Process process;
	static String nodePath = "C:/Progra~2/Appium/node.exe";
	static String appiumJSPath = "C:/Progra~2/Appium/node_modules/appium/lib/server/main.js";
	static String cmd = nodePath+ " " + appiumJSPath;
	//static ATUTestRecorder recorder;

	/*
	 * Method for fetching the property value from property file
	 */
	public static String getObjectValue(String objectName)
	{
		return ObjectMapPros.getProperty(objectName);
	}

	/* Method to start Appium Server 
	 * 
	 */
	public static void startAppiumServer() {
		try{
		Runtime runtime = Runtime.getRuntime();
		process = runtime.exec("cmd");
		Thread.sleep(5000);
		if (process != null) {
			System.out.println("Appium server started");
		}
		}catch(Exception e)
		{
			System.out.println("Exception starting Appium"+e.getMessage());
		}
	}

	/*Method to stop Appium Server
	 * 
	 */
	public static void stopAppiumServer() throws IOException {
		if (process != null) {
			process.destroy();
		}
		System.out.println("Appium server stop");
	}

	/*Method for start recording the script
	 * using ATUTestRecorder class
	 */
	public static ATUTestRecorder startRecorder(ATUTestRecorder recorder)
	{

		Date date=new Date();
		DateFormat format=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		try {
			recorder=new ATUTestRecorder("G:/WorkSpace/ATUTestRecorderjar/", "Flight-"+format.format(date), false);

		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return recorder;
	}	

	/*
	 * Method to stop recording
	 */
	public static void stopRecoder(ATUTestRecorder recorder)
	{
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	/*
	 * Method to set object map file
	 */
	public static void setPropertiesFile()
	{
		properties=new Properties();
		try {
			InputStream input=new FileInputStream("G:/WorkSpace/MakeMyTrip/ObjectMap.properties");
			properties.load(input);
		} catch (Exception e1) {
			System.out.println("Exception occurred while mapping the properties file :"+e1.getMessage());
		} 
	}

	/*
	 * Method to perform vertical scroll from bottom to top
	 */
	public static void scrollWindow(int amount,AndroidDriver driver)
	{
		Dimension size=driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		driver.swipe(startx,starty,startx,endy,amount);
	}

	/*
	 * Method to take screenshots while execution
	 */
	public static void takeScreen(AndroidDriver driver)
	{
		TakesScreenshot scr=(TakesScreenshot)driver;
		File file=scr.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("G:/WorkSpace/PB_Project/test-output/Screen.jpg"));
		} catch (IOException e) {
			System.out.println("Exception occurred while taking copying file"+e.getMessage());
		}
	}
}
