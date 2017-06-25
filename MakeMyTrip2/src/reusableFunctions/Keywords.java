package reusableFunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Keywords {

	// Variables for Properties , Recorder, Path for node.exe and appium.js

	static Properties ObjectMapPros;
	static ATUTestRecorder recorder;
	static Process process;
	static String nodePath = "C:/Progra~2/Appium/node.exe";
	static String appiumJSPath = "C:/Progra~2/Appium/node_modules/appium/lib/server/main.js";
	static String cmd = nodePath + " " + appiumJSPath;

	/*
	 * Method for fetching the property value from property file
	 */
	public static String getObjectValue(String objectName) {
		try {
			return ObjectMapPros.getProperty(objectName);
		} catch (Exception e) {
			System.out.println("Cannot fetch the properties data" + e.getMessage());
			Assert.fail();
			return null;
		}
	}

	/*
	 * Method to start Appium Server
	 */
	public static void appiumStart() {
		try {
			process = Runtime.getRuntime().exec(cmd);
			Thread.sleep(10000);
			if (process != null) {
				System.out.println("Appium server Is started now.");
			}
		} catch (Exception e) {
			System.out.println("Appium Start Exception" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method is to stop the Appium Server
	 */
	public static void appiumStop() {
		try {
			if (process != null) {
				process.destroy();
			}
			System.out.println("Appium server Is stopped now.");
		} catch (Exception e) {
			System.out.println("\nAppium Stop Exception" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method for start recording the script using ATUTestRecorder class
	 */
	public static ATUTestRecorder startRecorder() {
		try {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("dd-mm-yy hh-mm-ss");

			recorder = new ATUTestRecorder("G:/WorkSpace/ATUTestRecorderjar/", "Flight-" + format.format(date), false);
		} catch (Exception e) {
			System.out.println("\nException occurred while start recording" + e.getMessage());
			Assert.fail();
		}
		return recorder;
	}

	/*
	 * Method to stop recording
	 */
	public static void stopRecoder(ATUTestRecorder recorder) {
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			System.out.println("\nException occurred while stop recording" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method to set object map file
	 */
	public static void setPropertiesFile() {
		try {
			ObjectMapPros = new Properties();

			InputStream input = new FileInputStream("G:/WorkSpace/MakeMyTrip/ObjectMap.properties");
			ObjectMapPros.load(input);
		} catch (Exception e) {
			System.out.println("Exception occurred while mapping the properties file :" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method to perform vertical scroll from bottom to top
	 */
	public static void scrollWindow(int amount, AndroidDriver driver) {
		try {
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
			int starty = (int) (size.height * 0.80);
			int endy = (int) (size.height * 0.20);
			int startx = size.width / 2;
			System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
			driver.swipe(startx, starty, startx, endy, amount);
		} catch (Exception e) {
			System.out.println("Exception occurred while doing Scrolling operation\n" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method to perform vertical scroll from bottom to top
	 */
	public static void scrollWindow1( AndroidDriver driver) {
		try {
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
			int starty = (int) (size.height * 0.8);
			int endy = (int) (size.height * 0.2);
			int startx = 0;
			System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
			System.out.println("1");
			Thread.sleep(3000);
			driver.swipe(startx, starty, startx, endy, 110);
			System.out.println("2");
		    
		
		} catch (Exception e) {
			System.out.println("Exception occurred while doing Scrolling operation\n" + e.getMessage());
			Assert.fail();
		}
	}
	/*
	 * 
	 */
	public static void touchAction(AndroidDriver driver)
	{
		try {
			
			Dimension size = driver.manage().window().getSize();
			  System.out.println("Size :"+size);
			  int x1 = (int) (size.height * 0.8);
			  int x2 = (int) (size.height * 0.2);
			  TouchAction action = new TouchAction(driver);
			   
			  WebElement element1=new objectRepository.HolidayBook(driver).wePage1FirstScrollA;
			  
			  if(element1!=null)
			  {
				  System.out.println("Element found");
			  }
			  else
			  {
				  System.out.println("Element not found");
			  }
			  
			  action.longPress(720,1728).moveTo(0,-100).release().perform();
			  
		} catch (Exception e) {
			System.out.println("Exception while doing the touch action flow"+e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method to take screenshots while execution
	 */
	public static void takeScreen(AndroidDriver driver) {
		try {
			TakesScreenshot scr = (TakesScreenshot) driver;
			File file = scr.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("G:/WorkSpace/PB_Project/test-output/Screen.jpg"));
		} catch (Exception e) {
			System.out.println("Exception occurred while taking copying file" + e.getMessage());
			Assert.fail();
		}
	}
}
