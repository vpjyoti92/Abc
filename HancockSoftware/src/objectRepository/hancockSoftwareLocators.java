package objectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hancockSoftwareLocators {
	
	
	// ------------ Instantiate Web Elements.
		public hancockSoftwareLocators(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	
	
	
	//WelcomePage with MyIncentiveApplication In Focus
	
	@FindBy(xpath="//*[@id='topMenuList']//li//a[.='Incentive Applications']")
	//Locator For IncentiveApplication link on Welcome Page 
	public WebElement weLinkIncentiveApplication;
	
	@FindBy(xpath="//*[@id='SubMenuList']//a[text()='My Incentive Applications']")
	//Locator For MyIncentiveApplication link on IncentiveApplication Page 
	public WebElement weLinkMyIncentiveApplication;
	
	@FindBy(xpath="//*[.='New Application']")
	//Locator For NewApplication link on IncentiveApplication
	public WebElement weBtnNewApplication;
	
	//SelectingApplicationNewWindow
	
	@FindBy(xpath="//*[@id='DropDownListAppType']")
	//Locator For dropdown on SelectIncentiveApplication  
	public WebElement weDropDownSelectIncentiveAplication;
	
	@FindBy(xpath="//*[@id='ButtonSave']")
	//Locator For continue button on SelectIncentiveApplication Window 
	public WebElement weBtnSelectIncentiveAplication;
	
	//NewApplication page
	
	@FindBy(xpath="//*[@id='DropDownListBuildings']")
	//Locator For selecting building on NewApplication Page 
	public WebElement weDropDownSelectBuilding;
	
	@FindBy(xpath="//*[@id='DropDownListIncentiveProgram']")
	//Locator For selecting IncenctiveProgram on NewApplication Page 
	public WebElement weDropDownSelectIncentiveProgram;
	
	@FindBy(xpath="//*[@id='TextBoxApplicationName']")
	//Locator For ApplicationName  on NewApplication Page 
	public WebElement weInputboxApplicationName;
	
	@FindBy(xpath="//*[@id='TextBoxAccountNumber']")
	//Locator For selecting building on NewApplication Page 
	public WebElement weInputboxAccountNumber;
	
	@FindBy(xpath="//tr[@id='tr_0']//input[@value='RadioButtonByBuilding']")
	//Locator For selecting building type under BuildingIncentives on NewApplication Page 
	public WebElement weRadioButtonBuildingIncentives;
	
	@FindBy(xpath="//*[@id='ButtonSave']")
	//Locator For save button on NewApplication Page 
	public WebElement weBtnSave;
	
	@FindBy(xpath="//*[@id='tabs']//a[text()='Client Info']")
	//Locator For ClientInfo Tab on NewApplication Page 
	public WebElement weTabClientInfo;
	
	//ClientInfo page
	
	@FindBy(xpath="//*[@id='TextBoxPhone']")
	//Locator For TelephoneNumber on ClientInfo Page 
	public WebElement weInputBoxTelephoneNumber ;
	
	//IncentiveApplicationPage
	
	@FindAll({@FindBy(xpath="//*[@id='ContentPlaceHolderIndex_grdData']//tr[position()>1]")})
	//Locator For List of NewApplications on IncentiveApplication Page
	public List<WebElement> weListApplications;
	
	@FindBy(xpath="//*[@class='navbar-sub navbar-static-top navbar-dark bg-inverse-sub']//li//a[.='Dashboard Applications']")
	//Locator For DashboardApplication on IncentiveApplication Page 
	public WebElement weLinkDashboardApplication ;
	
	//Dashboard Application -- New And Recently Updated
	
	@FindAll({ @FindBy(xpath = "//*[@class='col-md-4']//a")})
	//Locator For List of All Applications created
	public List<WebElement> weListNewApplicationsCreated ;

    //DashboardApplication -- Review Application Created 
	
	@FindBy(xpath="//*[@id='TextBoxNotes']")
	//Locator For Notes input textarea on ReviewApplication :Your Application Page 
	public WebElement weInputBoxNotes;
	
	@FindBy(xpath="//*[@id='DropDownListStatus']")
	//Locator For Status Dropdown on ReviewApplication :Your Application Page 
	public WebElement weDropDownStatus;
	
	@FindBy(xpath="//*[@class='btn btn-primary'][@type='button']")
	//Locator For Update Button on ReviewApplication :Your Application Page 
	public WebElement weBtnUpdateDashboard;
	
	@FindBy(xpath="//*[@class='nav nav-tabs']//li[2]")
	//Locator For ActiveApplication on Dashboard
	public WebElement weLinkActiveApplications;
	
	//DashBoardApplication --> Comment Window
	
	@FindBy(xpath="//*[@id='ContentPlaceHolderIndex_comment']")
	//Locator For Comment TextArea on Comment Window PopUp 
	public WebElement weInputBoxComments;
	
	@FindBy(xpath="//*[@id='ButtonSave']")
	//Locator For Continue Button on Comment Window PopUp  
	public WebElement weBtnContinue;
	
	//Incentive Applications-- My Application
	
	@FindBy(xpath="//*[@id='tabs']//a[text()='Supporting Files']")
	//Locator For SupportingFiles Tab  on SupportingFiles :MyApplication :Edit Application Page 
	public WebElement weTabSupportingFiles;
	
	@FindBy(xpath="//*[@id='ContentPlaceHolderIndex_DropDownListDocumentType']")
	//Locator For Supporting Document DropDown on on SupportingFiles: MyApplication :Edit Application Page 
	public WebElement weDropDownSupportingDocumentType;
	
	@FindBy(xpath="//*[@id='ContentPlaceHolderIndex_uploadSupportingFile']")
	//Locator For ChooseFile Button on SupportingFiles: MyApplication :Edit Application Page 
	public WebElement weBtnChooseFile;
	
	@FindBy(xpath="//*[@id='//*[@id='ButtonSave']']")
	//Locator For UpdateButton on  SupportingFiles :MyApplication :Edit Application Page 
	public WebElement weBtnUpdateSupportingFile;

	@FindBy(xpath="//*[@id='ButtonSubmitt']")
	//Locator For SubmitButton on  SupportingFiles :MyApplication :Edit Application Page 
	public WebElement weBtnSubmitSupportingFile;
	
	
}
