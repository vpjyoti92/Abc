package reusable;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Methods {


	public static void selectByVisibleText(WebElement element, String string)
	{
		Select select=new Select(element);
		select.selectByVisibleText(string);
	}
	
	/**
	 * This method performs click operation using javascript
	 * @param driver
	 * @param we
	 */
	public static void javascriptClick(WebDriver driver, WebElement we) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", we);
		} catch (Exception e) {
			System.out.println("Exception occured in javascriptClick " + e.getMessage());
		}
	}
	
	/**
	 * This method performs uploading of the required files from the desktop
	 * @param driver
	 * @param we
	 */
	public static void runUploading(String sFilePath)
	{
		
		StringSelection stringSelection = new StringSelection(sFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(200);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * This method is for selecting the specific element using from list of webelements
	 * @param driver
	 * @param we
	 */
	
	public static WebElement selectWebElementFromList(String sValue, List<WebElement> list)
	{
		WebElement weTempElement=null;
		int iSize=list.size();
		for(int i=0; i<iSize; i++)
		{
			String str=list.get(i).getText();
			System.out.println("Applications :"+str);
			if(str.equals(sValue))
			{
				System.out.println("Sucessfully found"+sValue);
			     weTempElement=list.get(i);
			}
           		
		}
		return weTempElement;
	}
	
	/**
	 * This method performs recording of the script
	 * @param driver
	 * @param we
	 */
	public static void testRecoder(ATUTestRecorder recor)
	{
	DateFormat format=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
	Date date=new Date();
	try {
		recor=new ATUTestRecorder("C:/WorkSpace/ATUTestRecorderjar","Test Suit"+format.format(date),false);
		recor.start();
	} catch (ATUTestRecorderException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
}
