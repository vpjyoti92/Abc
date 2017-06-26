package reusable;

import org.openqa.selenium.WebDriver;
import objectRepository.Login;
public class Actions {

	
	/**
	 * Method - Logs In to the Application
	 * @param driver
	 * @param user_name
	 * @param password
	 * @return
	 */
	public static boolean validhancockSoftwareLocators(WebDriver driver, String username, String password) {
		try {
			Login objhancockSoftwareLocatorsPage = new Login(driver); 
			objhancockSoftwareLocatorsPage.weInputboxUsername.click();
			objhancockSoftwareLocatorsPage.weInputboxUsername.sendKeys(username);
			objhancockSoftwareLocatorsPage.weInputboxPassword.click();
			objhancockSoftwareLocatorsPage.weInputboxPassword.sendKeys(password);
			objhancockSoftwareLocatorsPage.weBtnLogin.click();
			if (new Login(driver).weWelcomeNote.isDisplayed()) {
				return true;
			} else {
				System.out.println("Could Not Confirm hancockSoftwareLocators");
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Could Not hancockSoftwareLocators Into Application. Reason: " + e.getMessage());
			return false;
		}
	}
}
