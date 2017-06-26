/**
 * Class - Driver Related Initializations.

 */
package driver_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
			driver = new FirefoxDriver();
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
			sUsername = PropertyFiles.ReadPropertyValue("username");
			sPassword = PropertyFiles.ReadPropertyValue("password");
			sURL = PropertyFiles.ReadPropertyValue("url");
		} catch (Exception e) {
			System.out.println("Error When Setting User Data.");
		}
	}
}
