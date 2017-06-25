package driverScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import io.appium.java_client.android.AndroidDriver;

public class InitializeDriver {

	public static AndroidDriver driver;
	/*
	 * Method to set up the capabilities Launching the Application on Android
	 * Browser Taking
	 * DeviceName,BrowserName,Version,Platform,PackageName,ActivityName,Url //
	 */
	public static void setUp(String deviceName, String browserName, String versionName, String platformName,
			String app,String url) {
		try {
			DesiredCapabilities dc1 = new DesiredCapabilities();
			dc1.setCapability("deviceName", deviceName);
			dc1.setCapability(CapabilityType.BROWSER_NAME, browserName);
			dc1.setCapability(CapabilityType.VERSION, versionName);
			dc1.setCapability("platformName", platformName);
			dc1.setCapability("noReset", true);
			dc1.setCapability("fullReset", false);
//			dc1.setCapability("appPackage", "com.makemytrip");
//			dc1.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
			dc1.setCapability("app", app);
			dc1.setCapability("autoAcceptAlerts", true);
			System.out.println("hello");
			try {
				driver = new AndroidDriver(new URL(url), dc1);
				System.out.println("hello");
				
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
}
