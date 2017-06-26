package testScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import atu.testrecorder.ATUTestRecorder;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import reusableFunctions.Keywords;

public class AutomationSetUp {
	
	// Variables for driver
	private AndroidDriver driver;
	public ATUTestRecorder recorder;
	static Process process;
	DateFormat format = new SimpleDateFormat("yy-mm-dd hh-mm-ss");
	Date date = new Date();
	
	/*
	 * Method to Initialize the driver and launch the Application by taking the parameters from xml file
	 */
	@Parameters({ "deviceName", "browserName", "versionName", "platformName", "app","url" })
	@BeforeSuite
	public void launch(String deviceName, String browserName, String versionName, String platformName,
			String app, String url) {
		try {
			Keywords.appiumStop();
			Keywords.appiumStart();
			recorder = Keywords.startRecorder();
			Thread.sleep(2000);
			recorder.start();
			InitializeDriver.setUp(deviceName, browserName, versionName, platformName, app, url);
			driver=InitializeDriver.driver;
		} catch (Exception e) {
			System.out.println("Exception while launching the driver with the Url :" + e.getMessage());
			Assert.fail();
		}
	}
	
	@AfterSuite
	public void close2()
	{
		try{
			//------Stop Recorder and Closing the browser
			Keywords.stopRecoder(recorder);
			driver.quit();
			Keywords.appiumStop();	

		}
		catch(Exception e)
		{
			System.out.println("Exception while closing the script:"+e.getMessage());
			Assert.fail();
		}

	}
}
