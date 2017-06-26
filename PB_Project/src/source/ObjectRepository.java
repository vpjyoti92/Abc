package source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {


	public ObjectRepository( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_CPHBody_LoginCtrl_UserName']")
	public static WebElement XPATH_LOGIN_PAGE_USERID;

	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_CPHBody_LoginCtrl_Password']")
	public WebElement XPATH_LOGIN_PAGE_PASSWORD;

	@FindBy(how = How.XPATH, using = "//input[@id='ctl00_CPHBody_LoginCtrl_LoginButton']")
	public WebElement XPATH_LOGIN_PAGE_SUBMIT;

	@FindBy(how = How.XPATH, using = "//a[.='French Door Refrigerato...']")
	public static WebElement XPATH_FRENCHDOOR_FOLDER_TEXT;

	@FindBy(how = How.XPATH, using = "//a[@href='#child_5'][@aria-expanded='false']")
	public static WebElement XPATH_FRENCHDOOR_FOLDER_PLUS;

	@FindBy(how = How.XPATH, using = "//a[@href='#child_5'][@aria-expanded='true']")
	public static WebElement XPATH_FRENCHDOOR_FOLDER_MINUS;

	@FindBy(how = How.XPATH, using = "//a[@href='#child_53'][@aria-expanded='true']")
	public static WebElement XPATH_PRO26_FOLDER_MINUS;

	@FindBy(how = How.XPATH, using = "//a[@href='#child_53'][@aria-expanded='false']")
	public static WebElement XPATH_PRO26_FOLDER_PLUS;

	@FindBy(how = How.XPATH, using = "//a[.='PRO 26-01']")
	public static WebElement XPATH_PRO26;

	@FindBy(how = How.XPATH, using = "//a[.='PRO 26-01']//following-sibling::button[@id='btnOptions']")
	public static WebElement XPATH_THREEBAR_DROPDOWN;

	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Add new PO")
	public static WebElement XPATH_ADDNEWPO_LINK;

	@FindBy(how = How.XPATH, using = "//button[@id='btnNext']")
	public static WebElement XPATH_NEXT_BUTTON;

	@FindBy(how = How.XPATH, using = "//input[@id='txtPOName']")
	public static WebElement XPATH_PO_NAME_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//select[@id='ddlCurrency']")
	public static WebElement XPATH_SELECTCURRENCY_DROP;

	@FindBy(how = How.XPATH, using = "//select[@id='ddlVendor']")
	public static WebElement XPATH_SELECTVENDOR_DROP;

	@FindBy(how = How.XPATH, using = "//select[@id='ddlMgr']")
	public static WebElement XPATH_SELECTMANAGER_DROP;

	@FindBy(how = How.XPATH, using = "//select[@id='ddlVendorContact']")
	public static WebElement XPATH_VENDORCONTACT_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='txtEstimateNo']")
	public static WebElement XPATH_ESTIMATION_TEXAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='txtVendorNo']")
	public static WebElement XPATH_VENDORNUMBER_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='txtPONumber']")
	public static WebElement XPATH_PONUMBER_TEXTAREA1;

	@FindBy(xpath = "//input[@id='txtPONumber']")
	public WebElement XPATH_PONUMBER_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='txtShpCartNo']")
	public static WebElement XPATH_SHOPPINGCART_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='dtpReqStartDt']")
	public static WebElement XPATH_REQUESTSTARTDATE_TEXTAREA;

	@FindBy(how = How.XPATH, using = "//input[@id='dtpReqEndDt']")
	public static WebElement XPATH_REQUESTENDDATE_TEXTAREA;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtEstimateAmnt']")
	public static WebElement XPATH_COMMITAMOUNT_TEXTAREA;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtItemDesc']")
	public static WebElement XPATH_DESCRIPTION_TEXTAREA;
	
	@FindBy(how = How.XPATH, using = "//input[@id='txtPost_Note']")
	public static WebElement XPATH_NOTES_TEXTAREA;
	
	@FindBy(how = How.XPATH, using = "//select[@id='cmbCategory']")
	public static WebElement XPATH_BUDGET_TEXTAREA;
	
	@FindBy(how = How.XPATH, using = "//input[@id='chkAppr']")
	public static WebElement XPATH_APPROVE_CHECKBOX;
	
	
	@FindBy(how = How.XPATH, using="//span[@id='spnShowPostAmnt']//parent::div//child::button[@id='btnSave']")
	public static WebElement XPATH_ADDNEWSAVE_BUTTON;
	
	@FindBy(how = How.XPATH, using="//input[@id='txtDeclineRemark']")
	public static WebElement XPATH_REQUESTDECLINE_TEXTAREA;
	
	@FindBy(how =How.XPATH, using="//th[@class='datepicker-switch'][.='May 2017']")
	public static WebElement XPATH_CALENDER_MONTH;
	
	@FindBy(how=How.XPATH, using="(//div[@class='input-group date datepicker']//child::span[@class='glyphicon glyphicon-calendar'])[3]")
	public static WebElement XPATH_CALENDER_DATE;

	@FindBy(how =How.XPATH, using="(//th[@class='prev'])[2]")
	public static WebElement XPATH_CALENDER_YEARPREVIOUSBUTTON;
	
	@FindBy(how =How.XPATH, using="//span[.='Oct']")
	public static WebElement XPATH_CALENDER_MONTHSELECTOR;
	
	@FindBy(how =How.XPATH, using="//td[.='15']")
	public static WebElement XPATH_CALENDER_DATESELECTOR;
	
	@FindBy(how= How.XPATH, using="//a[.='Testuser2']")
	public static WebElement XPATH_TESTUSER_CREATED;
	
	
	
}
