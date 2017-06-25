package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	//LoginPage xpath
	
		@FindBy(xpath = "//*[@id='userNameTextBox']")
		// Locator For term username on Login Page
		public WebElement weInputboxUsername;
		
		@FindBy(xpath = "//*[@id='ContentPlaceHolder1_passwordTextBox']")
		// Locator For term password on Login Page
		public WebElement weInputboxPassword;
		
		@FindBy(xpath="//*[@id='loginButton']")
		// Locator For login button on Login Page
		public WebElement weBtnLogin;
		
		@FindBy(xpath = "//*[.='Welcome to the App Center']")
		//Locator for WebSite Welcome Note
		public WebElement weWelcomeNote;
		
		public Login(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
	
}
