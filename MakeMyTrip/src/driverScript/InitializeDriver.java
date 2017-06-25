package driverScript;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class InitializeDriver {

	public static AndroidDriver driver;
static String path="C:/Users/You/Downloads/MakeMyTrip Flights Hotels Cabs_v5.6.9_apkpure.com.apk";
	/* Method to set up the capabilities 
	 * Launching the Application on Android Browser
	 * Taking DeviceName,BrowserName,Version,Platform,PackageName,ActivityName,Url 
	 */
	public static void setUp()
	{
		DesiredCapabilities dc1=new DesiredCapabilities();
		dc1.setCapability("deviceName", "192.168.145.101:5555");
//		System.out.println(dc1.getCapability("CapabilityType.BROWSER_NAME"));
//		System.out.println(dc1.getCapability("platformName"));
//		System.out.println(dc1.getCapability("app"));
//		dc1.setCapability(CapabilityType.BROWSER_NAME, "Android");
//		dc1.setCapability(CapabilityType.VERSION, "4.4.4");
//		dc1.setCapability("platformName", "Android");
//		dc1.setCapability("appPackage", "com.makemytrip");
//		dc1.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
		dc1.setCapability("app", path);
		dc1.setCapability("noReset", true);
		dc1.setCapability("fullReset", false);
//	     dc1.setCapability("androidInstallTimeout", "90000");
//	     dc1.setCapability("avdLaunchTimeout", "300000");
//	     System.out.println(dc1.getCapability("app"));
//	     System.out.println(dc1.getCapability("appPackage"));
//	     System.out.println(dc1.getCapability("appActivity"));
		try {
			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc1);
			System.out.println(dc1.getCapability("platformName"));
			System.out.println(dc1.getCapability("appPackage"));
		} catch (MalformedURLException e) {
			System.out.println("Error opening the Url on Browser" + e.getMessage());
            Assert.fail();
		}
		System.out.println("Application Launched Successfully ");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		

	}


}


