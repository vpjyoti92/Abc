package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import source.ObjectRepository;
import source.ReusableFunctions;
import source.driver_scripts;

public class TestLogin {
	
	private WebDriver driver;
	private ATUTestRecorder recorder;
	private Properties objectmap;
	private TakesScreenshot ss;
	
	@BeforeTest
	public void setUp()
	{
		ReusableFunctions.initialiseObjectMap("G:/WorkSpace/PB_Project/test-data/ObjectMap1.properties");
		DateFormat format=new SimpleDateFormat("yy-mm-dd hh-mm-ss");
		Date date=new Date();
		driver=new FirefoxDriver();
		driver.get(ReusableFunctions.getObjectValue("URL"));
		try {
			recorder= new ATUTestRecorder("C:/WorkSpace/ATUTestRecorderjar","Test Video-"+format.format(date),false);
			recorder.start();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@AfterMethod
//	public void capture_SS()
//	{
//		ReusableFunctions.captureScreenShot("C:/WorkSpace/ATUTestRecorderjar/Screens");
//	}
	
	@Test
	public void run()
	{
		
		new ObjectRepository(driver).XPATH_LOGIN_PAGE_USERID.sendKeys(ReusableFunctions.getObjectValue("USER_ID"));
		new ObjectRepository(driver).XPATH_LOGIN_PAGE_PASSWORD.sendKeys(ReusableFunctions.getObjectValue("PASSWORD"));
		new ObjectRepository(driver).XPATH_LOGIN_PAGE_SUBMIT.click();
	}
	
	@AfterTest
	public void close()
	{
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}
	

}
