package source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.*;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class ReusableFunctions {
	
	static Properties ObjectMapPros;
	static WebDriver driver;
	static WebElement element1;
	static TakesScreenshot ss;
	
	public static void initialiseObjectMap(String configpath)
	{
		ObjectMapPros=new Properties();
		InputStream fis;
		try {
			fis=new FileInputStream(configpath);
			ObjectMapPros.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getObjectValue(String objectName)
	{
		return ObjectMapPros.getProperty(objectName);
	}
	
	public static void sendKeysByXpath(String element, String value)
	{
		String location_xpath=ObjectMapPros.getProperty(element);
		System.out.println(location_xpath);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		element1=driver.findElement(By.xpath(location_xpath));
		System.out.println("element found");
		element1.sendKeys(value);
	}
	
	public static void clickByXpath(String element)
	{
		driver.findElement(By.xpath(ObjectMapPros.getProperty(element))).click();;
	}
	
	public static void selectElement(WebElement element, String value)
	{
		Select select1=new Select(element);
		select1.selectByVisibleText(value);
	}
  
	public static void hoverElement(WebElement element, WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void captureScreenShot(String configpath)
	{		
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(configpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	

