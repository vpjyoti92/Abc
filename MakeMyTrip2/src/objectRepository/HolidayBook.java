package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class HolidayBook {

	public HolidayBook(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.NAME, using="Holidays")
	//Locator for Hotel on page1
	public WebElement wePage1Hotel;

	@FindBy(how=How.NAME , using="Theme Based Vacation")
	//Locator for the last element
	public WebElement wePage1LastScroll;	

	@FindBy(how=How.NAME , using="Taj Holidays at Flat 30% Cashback")
	//Locator for the first element
	public WebElement wePage1FirstScroll;	


	@FindBy(how=How.NAME , using="//android.widget.RelativeLayout[@index='1']//android.support.v4.view.ViewPager[@index='1']")
	//Locator for the to verify element
	public WebElement wePage1FirstScrollA;	
	
}
