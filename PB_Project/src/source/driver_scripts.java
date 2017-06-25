package source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver_scripts {

	private static WebDriver driver;

	public static void launchURL(String url,WebDriver driver) {
		 driver = new FirefoxDriver();
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
