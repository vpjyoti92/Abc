package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import reusableFunctions.Keywords;

public class ValidateLaunching {
	
	
		AndroidDriver driver;
	/*
	 * Method to Initialize the driver and launch the Application by taking the parameters from xml file .
	 */
	@Parameters({"deviceName", "browserName", "versionName", "platformName", "app", "url"})
	@BeforeClass
	public void launch(String deviceName,String browserName,String versionName,String platformName, String appPath, String url)
	{
		try{
			Keywords.appiumStop();;
			Keywords.appiumStart();
			//recorder=Keywords.startRecorder();
			Thread.sleep(2000);
			//recorder.start();
			try {
				DesiredCapabilities dc1 = new DesiredCapabilities();
				dc1.setCapability("deviceName", deviceName);
				dc1.setCapability(CapabilityType.BROWSER_NAME, browserName);
				dc1.setCapability(CapabilityType.VERSION, versionName);
				dc1.setCapability("platformName", platformName);
				dc1.setCapability("noReset", "true");
				dc1.setCapability("fullReset", "false");
				dc1.setCapability("app", appPath);
				
				/*dc1.setCapability("appActivity", appActivityName);*/

				try {
					Thread.sleep(5000);
					driver = new AndroidDriver(new URL(url), dc1);
				} catch (MalformedURLException e) {
					System.out.println("Error opening the Url on Browser" + e.getMessage());
					Assert.fail();
				}
				System.out.println("Application Launched Successfully ");
				driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
				
			} catch (Exception e) {
				System.out.println("Exeception on set up operation " + e.getMessage());
				Assert.fail();
			
			}
		}
		catch(Exception e)
		{
			System.out.println("Not loaded");
		}
	}
	/*
	 * Method includes the hotel search as per the requirements and booking it entering the required details .
	 */
	@Test
	public void hotelBooking()
	{
		System.out.println("Hello");
}
}
