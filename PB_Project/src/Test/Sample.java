package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Sample {

	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		String exepath="G:/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exepath);
        
        //Chrome Option
        ChromeOptions option=new ChromeOptions();
        option.addArguments("disable-infobars");
        option.addArguments("--start-maximized");
        
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://toolsqa.com/iframe-practice-page/");
		
		
		
//		Actions action=new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys(String.valueOf('\u006E')).perform();
//		driver.get("http://toolsqa.com/iframe-practice-page/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.id("reset-profile-settings-dismiss")).click();
//       System.out.println(driver.getCurrentUrl());
		
//		driver.switchTo().window(set.get(0));
		DateFormat format=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		Date date=new Date();
		try {
			ATUTestRecorder recor=new ATUTestRecorder("C:/WorkSpace/ATUTestRecorderjar","Test Suit"+format.format(date),false);
			recor.start();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);");
		
		//driver.manage().window().maximize();
		driver.switchTo().frame("iframe1");
		driver.findElement(By.name("firstname")).sendKeys("Jyoti");
		driver.findElement(By.name("lastname")).sendKeys("Pareek");
		driver.findElement(By.id("sex-1")).click();
		js.executeScript("window.scrollBy(0,300);");
		driver.findElement(By.id("exp-1")).click();
		driver.findElement(By.id("datepicker")).sendKeys("Hello user");
		driver.findElement(By.id("profession-0")).click();
		driver.findElement(By.id("photo")).sendKeys("G:/abc.txt");
		js.executeScript("window.scrollBy(0,300);");
		driver.findElement(By.id("tool-1")).click();
		
		driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		driver.findElement(By.linkText("Test File to Download")).click();
		
	     Select select=new Select(driver.findElement(By.id("continents")));
	     select.selectByVisibleText("Africa");
		
	     Select select2=new Select(driver.findElement(By.id("selenium_commands")));
	     select2.selectByVisibleText("Wait Commands");
	     js.executeScript("window.scrollBy(0,300);"); 
	     
	     driver.findElement(By.id("submit")).click();
	    
	     
		driver.close();
	}

}
