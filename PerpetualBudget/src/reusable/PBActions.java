package reusable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import object_repo.Login;

public class PBActions {

	/**
	 * Method - Logs In to the Application
	 * @param driver
	 * @param user_name
	 * @param password
	 * @return
	 */
	public static boolean validLogin(WebDriver driver, String user_name, String password) {
		try {
			Login objLoginPage = new Login(driver); 
			objLoginPage.weInputboxUsername.click();
			objLoginPage.weInputboxUsername.sendKeys(user_name);
			objLoginPage.weInputboxPassword.click();
			objLoginPage.weInputboxPassword.sendKeys(password);
			objLoginPage.weBtnLogin.click();
			if (new Login(driver).weUserIconText.isDisplayed()) {
				return true;
			} else {
				System.out.println("Could Not Confirm Login");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Could Not Login Into Application. Reason: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * Waits Until the Page Loading is Complete Or 25 Seconds
	 * @param driver
	 */
	public static void waitForLoading(WebDriver driver) {
		try {
			Thread.sleep(1000);
			for(int i=0;i<15;i++){
				WebElement we = driver.findElement(By.xpath("//div[@id='overlay']"));
				if (we.getCssValue("display").equalsIgnoreCase("none")){
					break;
				}
				System.out.println("Page Loading ... ");
				Thread.sleep(1500);
			}
		} catch (Exception e) {
			System.out.println("Page Loading Issue. Reason: " + e.getMessage());
		}
	}
	
	
	/**
	 * Get Todays Date
	 * @param driver
	 */
	public static String getTodaysDate() {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").format(new Date()).toString();
		} catch (Exception e) {
			System.out.println("Exception Occured In getTodaysDate" + e.getMessage());
			return "02/20/2019";
		}
	}
	
	/**
	 * Get Todays Day
	 * @param driver
	 */
	public static String getTodaysDay() {
		try {
			return new SimpleDateFormat("d").format(new Date()).toString();
		} catch (Exception e) {
			System.out.println("Exception Occured In getTodaysDate" + e.getMessage());
			return "28";
		}
	}
	
	/**
	 * Get Later Date Than Todays
	 * @param driver
	 */
	public static String getLaterDate(int nLaterDays) {
		try {
			Calendar objCalendar = Calendar.getInstance();
			objCalendar.setTime(new Date());
			objCalendar.add(Calendar.DATE, nLaterDays);  // Adding nLaterDays Days
			return new SimpleDateFormat("MM/dd/yyyy").format(objCalendar.getTime()).toString();
		} catch (Exception e) {
			System.out.println("Exception Occured In getLaterDate" + e.getMessage());
			return "02/25/2019";
		}
	}
}
