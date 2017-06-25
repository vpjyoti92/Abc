//package testScripts;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.junit.Assert;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.thoughtworks.selenium.webdriven.commands.MouseEvent;
//
//import atu.testrecorder.ATUTestRecorder;
//import driverScript.InitializeDriver;
//import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import objectRepository.FlightBook;
//import reusableFunctions.Keywords;
//
//public class ValidateHolidayBooking {
//
//	private AndroidDriver driver;
//	private ATUTestRecorder recorder;
//	static Process process;
//	DateFormat format = new SimpleDateFormat("yy-mm-dd hh-mm-ss");
//	Date date = new Date();
//
//	@Parameters({ "deviceName", "browserName", "versionName", "platformName", "appPackageName", "appActivityName",
//			"url" })
//	@BeforeClass
//	public void launch(String deviceName, String browserName, String versionName, String platformName,
//			String appPackageName, String appActivityName, String url) {
//		try {
//			Keywords.appiumStop();
//			Keywords.appiumStart();
//			recorder = Keywords.startRecorder();
//			recorder.start();
//			driver = InitializeDriver.setUp(deviceName, browserName, versionName, platformName, appPackageName,
//					appActivityName, url);
//		} catch (Exception e) {
//			System.out.println("Exception while launching the driver with the Url :" + e.getMessage());
//			Assert.fail();
//		}
//	}
//
//	@Test
//	public void holidayBooking() {
//		try {
//			// Page1
//			new FlightBook(driver).weImgBackArrow.click();
//			new FlightBook(driver).weBtnOk.click();
//			new objectRepository.HolidayBook(driver).wePage1Hotel.click();
//
//			Dimension size = driver.manage().window().getSize();
//			int width = size.getWidth();
//			int height = size.getHeight();
//			System.out.println("width=" + width + "height=" + height);
//			Thread.sleep(2000);	
//			do {
//				reusableFunctions.Keywords.scrollWindow1(driver);
//			} while (new objectRepository.HolidayBook(driver).wePage1LastScroll.isDisplayed());
//				
//				//reusableFunctions.Keywords.scrollWindow1(driver);
//			System.out.println("in");
//			//reusableFunctions.Keywords.touchAction(driver);
//			System.out.println("Output");
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//			System.out.println("Exception while booking hotel :" + e.getMessage());
//			Assert.fail();
//		}
//	}
//
//	@AfterClass
//	public void close() {
//		try {
//			// ------Stop Recorder and Closing the browser
//			Keywords.stopRecoder(recorder);
//			//driver.quit();
//			Keywords.appiumStop();
//		} catch (Exception e) {
//			System.out.println("Exception while closing the script:" + e.getMessage());
//			Assert.fail();
//		}
//	}
//}
