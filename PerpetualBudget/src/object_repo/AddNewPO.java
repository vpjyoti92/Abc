package object_repo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPO {

	@FindBy(xpath = "//*[@id='Div2']//*[@id='txtBudget']")
	public WebElement weInputBudget;

	@FindBy(xpath = "//*[@id='Div2']//*[@id='txtAccount']")
	public WebElement weInputAccount;
	
	@FindBy(xpath = "//*[@id='Div2']//*[@id='txtProject']")
	public WebElement weInputProject;

	@FindBy(xpath = "//div[@id='Div2']//h4[@id='formTitle'][text()='Add New']")
	public WebElement weAddNewHeader;
	
	public AddNewPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}