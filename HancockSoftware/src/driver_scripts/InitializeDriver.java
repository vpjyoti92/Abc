package driver_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import reusable.PropertyFiles;

public class InitializeDriver {

	
	public WebDriver driver;
	public String sURL;
	public String sUsername;
	public String sPassword;
	
	public InitializeDriver() {
		try {
			setUserData();
			launchDriver();
		} catch (Exception e) {
			System.out.println("Exception Occured While Initializing Driver. Reason - " + e.getMessage());
		}
	}
	
	/**
	 * This Method Initializes the Selenium WebDriver.
	 */
	public void launchDriver() {
		
		try {
			String path="C:/Program Files (x86)/Google/Chrome/Application/Chrome.exe";
			System.setProperty("webdriver.chrome.driver", path);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(sURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Exception Occured While Launching Driver. Reason - " + e.getMessage());
			System.out.println("Execution Terminated");
			System.exit(0);
		}
	}
	
	/**
	 * This Method sets the data required - baseurl, username, password to be used.
	 */
	public void setUserData() {
		try {
			sUsername = PropertyFiles.readPropertyValue("username");
			sPassword = PropertyFiles.readPropertyValue("password");
			sURL = PropertyFiles.readPropertyValue("url");
		} catch (Exception e) {
			System.out.println("Error When Setting User Data.");
		}
	}
	
}
