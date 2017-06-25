package reusableFunctions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppiumStartAndStop {
	static Process p;
	static String nodePath = "C:/Progra~2/Appium/node.exe";
	static String appiumJSPath = "C:/Progra~2/Appium/node_modules/appium/lib/server/main.js";
	static String cmd = nodePath+ " " + appiumJSPath;
	static AndroidDriver driver;

	public static void main(String args[]) {
		try {
			appiumStop();
			appiumStart();
			launch();
			startRecord();
			try{
			appiumStop();
			}
			catch(Exception e)
			{
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Appium Server is not started" + e.getMessage());
			Assert.fail();
		}

	}


	public static void startRecord()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("adb shell screenrecord");
	}

	public static void appiumStart() {
		try {
			p = Runtime.getRuntime().exec(cmd);
			Thread.sleep(10000);
			if (p != null) {
				System.out.println("Appium server Is started now.");
			}
		} catch (Exception e) {
			System.out.println("appium start excep" + e.getMessage());
			// TODO: handle exception
		}
	}

	// This method Is responsible for stopping appium server.
	public static void appiumStop()  {
		try {
			if (p != null) {
				p.destroy();
			}
			System.out.println("Appium server Is stopped now.");
		} catch (Exception e) {
			System.out.println("appium stop excep" + e.getMessage());
			// TODO: handle exception
		}
	}

	public static void launch() {
		try {
			System.out.println("Inside Launch");
			DesiredCapabilities dc1 = new DesiredCapabilities();
			dc1.setCapability("deviceName", "abc");
			dc1.setCapability(CapabilityType.BROWSER_NAME, "Android");
			dc1.setCapability(CapabilityType.VERSION, "4.2.2");
			dc1.setCapability("platformName", "Android");
			dc1.setCapability("appPackage", "com.makemytrip");
			dc1.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
			System.out.println("Capablilities are set");

			try {
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc1);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Application Launched Successfully ");
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("appium launch excep" + e.getMessage());
		}

	}


	public static void performOrientation() {
		// Get and print current screen orientation.
		System.out.println("*--*--*-- Current screen orientation Is : " + driver.getOrientation());
		System.out.println("*--*--*-- Changing screen Orientation to LANDSCAPE.");
		// Changing screen Orientation to LANDSCAPE.
		driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("*--*--*-- Changing screen Orientation to PORTRAIT.");
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		// Get and print screen orientation after changing It.
		System.out.println("*--*--*-- Now screen orientation Is : " + driver.getOrientation());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
			
			
			
		}
	}
	
	public void takeEScreen()
	{
		try {
			p = Runtime.getRuntime().exec("adb devices");
		
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			System.out.println("Video recording :"+e.getMessage());
		}
	}


}
