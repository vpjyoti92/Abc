/**
 * Locators Specific to Login and Its Successful Validation.
 */
package object_repo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(xpath = "//*[@id='ctl00_CPHBody_LoginCtrl_UserName']")
	public WebElement weInputboxUsername;

	@FindBy(xpath = "//*[@id='ctl00_CPHBody_LoginCtrl_Password']")
	public WebElement weInputboxPassword;

	@FindBy(xpath = "//*[@id='ctl00_CPHBody_LoginCtrl_LoginButton']")
	public WebElement weBtnLogin;
	
	@FindBy(xpath = "//*[@id='ctl00_lblUser']")
	public WebElement weUserIconText;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}