package Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
	static AndroidDriver driver;
	static Process p;
	AppiumDriverLocalService adls;
	String appiumServiceUrl;
	static String node="C:/Program Files (x86)/Appium/node.exe";
	static String js="C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
	static String cmd = node + " " + js;

	public static void main(String[] args) throws MalformedURLException {
    
		stopServer();
		startServer();
		DesiredCapabilities dc1=new DesiredCapabilities();
		dc1.setCapability("deviceName", "192.168.145.102:5555");
		dc1.setCapability(CapabilityType.BROWSER_NAME, "Android");
		dc1.setCapability(CapabilityType.VERSION, "4.2.2");
		dc1.setCapability("platformName", "Android");
		dc1.setCapability("appPackage", "com.makemytrip");
		dc1.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc1);
		
	}
	
	
	
	public static void startServer()
	{
		try {
			p=Runtime.getRuntime().exec(cmd);
		 if(p!=null)
		 {
			 System.out.println("Application started successfully");
		 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void stopServer()
	{
		if(p!=null)
			p.destroy();
	}
	
	
//		public void setUp() throws MalformedURLException
//		{
//			adls=AppiumDriverLocalService.buildDefaultService();
//			adls.start();
//			appiumServiceUrl=adls.getUrl().toString();
//			System.out.println("Appium service url"+appiumServiceUrl);
//			
//			//setting capablilities
//			
//			DesiredCapabilities dc1=new DesiredCapabilities();
//			dc1.setCapability("deviceName", "192.168.145.102:5555");
//			dc1.setCapability(CapabilityType.BROWSER_NAME, "Android");
//			dc1.setCapability(CapabilityType.VERSION, "4.2.2");
//			dc1.setCapability("platformName", "Android");
//			dc1.setCapability("appPackage", "com.makemytrip");
//			dc1.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
//			
//			driver = new AndroidDriver<>(new URL(appiumServiceUrl), dc1);
//
//			
//		}
//		
		
	

}
