package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsPoEntry {

	private static final String sProjectName = "PRO 26-01";
	
	// Locator For Button Options In Left Panel
	public String weBtnOptionsLeftPanel = "./..//button[@id='btnOptions']";
	
	@FindBy(xpath = "//div[@class='btn-group open']//li/a[text()=' Edit']")
	// Locator For Edit In Option Button Of Left Panel
	public WebElement weBtnEditOptionsLeftPanel;
	
	@FindBy(xpath = "//div[@class='btn-group open']//li/a[text()=' Delete']")
	// Locator For Delete In Option Button Of Left Panel
	public WebElement weBtnDeleteOptionsLeftPanel;
	
	@FindBy(xpath = "//*[@class='modal-body'][contains(.,'Hey Dude,')]/following-sibling::div//button[text()='Yes']")
	// Locator For Yes Btn In Delete Confirmation
	public WebElement weBtnDeleteConfirmationYes;
	
	@FindBy(xpath = "//*[@class='col-sm-3']//button")
	// Locator For Toggle dropdown
	public WebElement weDropdownToggle;

	@FindBy(xpath = "//*[@id='ulTreeLevel']//a[text()=' Account']")
	// Locator For Account dropdown option
	public WebElement weDropdownAccount;

	@FindBy(xpath = "//*[@id='ulTreeLevel']//a[text()=' Project']")
	// Locator For Project dropdown option
	public WebElement weDropdownProject;
	
	@FindBy(xpath = "//*[@id='ulTreeLevel']//a[text()=' Purchase Order']")
	// Locator For Purchase Order dropdown option
	public WebElement weDropdownPurchaseOrder;

	@FindBy(xpath = "//*[@class='btn-group']//a[contains(.,'" + sProjectName + "')]")
	// Locator For Project
	public WebElement weBtnTreeProject;

	@FindBy(xpath = "//a[contains(.,'" + sProjectName + "')]//..//span[2]")
	// Locator For Options
	public WebElement weBtnTreeOptions;

	@FindBy(xpath = "//a[contains(.,'" + sProjectName + "')]/../../../..//i")
	// Locator For expand button
	public WebElement weBtnExpandProject;
	
	@FindAll({ @FindBy(xpath = "//*[@class='btn-group']/a") })
	// Locator For list of ALL Label Links In Left Panel
	public List<WebElement> weListLeftPanelItems;
	
	@FindBy(xpath = "//a[contains(.,'" + sProjectName + "')]//..//a[text()='Add new PO']")
	// Locator For Add new PO
	public WebElement weDropDownAddNewPO;

	@FindBy(xpath = "//*[@id='Div2']//button[@id='btnAddFile']")
	// Locator For list of PO lines
	public WebElement weBtnAddFiles;

	@FindBy(xpath = "//*[@id='txtPOName']")
	// Locator For "Po Name" field
	public WebElement weInputBoxPOName;

	@FindBy(xpath = "//*[@id='ddlVendor']")
	// Locator For Vendor
	public WebElement weDropDownVendor;

	@FindBy(xpath = "//*[@id='ddlVendorContact']")
	// Locator For Vendor contact
	public WebElement weDropDownVendorContact;

	@FindBy(xpath = "//*[@id='txtVendorNo']")
	// Locator For Vendor number
	public WebElement weInputBoxVendorNumber;

	@FindBy(xpath = "//*[@id='ddlMgr']")
	// Locator For manager
	public WebElement weDropDownManager;

	@FindBy(xpath = "//*[@id='txtEstimateNo']")
	// Locator For estimate number
	public WebElement weInputBoxEstimateNumber;

	@FindBy(xpath = "//*[@id='txtPONumber']")
	// Locator For PO number
	public WebElement weInputBoxPONumber;

	@FindBy(xpath = "//*[@id='txtShpCartNo']")
	// Locator For shopping cart number
	public WebElement weInputBoxShoppingCartNumber;

	@FindBy(xpath = "//*[@id='dtpReqStartDt']")
	// Locator For request start date
	public WebElement weDateRequestStart;

	@FindBy(xpath = "//*[@id='dtpReqEndDt']")
	// Locator For request end date
	public WebElement weDateRequestEnd;

	@FindBy(xpath = "//*[@id='txtIO']")
	// Locator For IO number
	public WebElement weInputBoxIONumber;

	@FindAll({ @FindBy(xpath = "//*[@class='panel panel-primary']//tbody//tr") })
	// Locator For list of PO lines
	public List<WebElement> weListPOLines;

	@FindBy(xpath = "//*[@id='btnAddPOLine']")
	// Locator For Add button detail view
	public WebElement weBtnAdd;

	@FindBy(xpath = "//*[@id='chkShowPostAmnt']")
	// Locator For Show all
	public WebElement weCheckBoxShowAll;

	@FindBy(xpath = "//*[@id='txtPosted']")
	// Locator For Trans amount
	public WebElement weInputBoxTransAmountPOHeader;

	@FindBy(xpath = "//*[@id='txtCommit']")
	// Locator For Commit amount
	public WebElement weInputBoxCommitAmountPOHeader;

	@FindBy(xpath = "//*[@id='txtTransAmnt']")
	// Locator For Trans amount
	public WebElement weInputBoxTransAmountPOLine;
	
	@FindBy(xpath = "//*[@id='tdPostedAmnt']")
	// Locator For Trans amount Posted Text
	public WebElement weTextTransAmountPosted;
	
	@FindBy(xpath = "//*[@id='txtEstimateAmnt']")
	// Locator For Commit amount
	public WebElement weInputBoxCommitAmountPOLine;
	
	@FindBy(xpath = "//*[@id='txtCommit']")
	// Locator For Commit amount
	public WebElement weInputBoxCommitAmount;

	@FindBy(xpath = "//div[@id='modalEntryFormPO']//button[@id='btnSave']")
	// Locator For Save button
	public WebElement weBtnSave;

	@FindBy(xpath = "//div[@id='modalEntryFormPO']//button[@id='btnCancel']")
	// Locator For Cancel button
	public WebElement weBtnCancel;

	@FindBy(xpath = "//*[@class='modal-footer']//button[text()='Next']")
	// Locator For next button
	public WebElement weBtnNext;

	@FindBy(xpath = "//*[@id='btnDetailV']")
	// Locator For Detail view
	public WebElement weBtnDetailView;

	@FindBy(xpath = "//*[@id='btnNormalV']")
	// Locator For Normal view
	public WebElement weBtnNormalView;

	@FindAll({ @FindBy(xpath = "//*[@class='table-condensed']//td") })
	// Locator For all day
	public List<WebElement> weBtnCalenderCurrentDate;

	// ***** Locators for Excel view ******

	@FindBy(xpath = "//*[@id='aPOEntryExcel']")
	// Locator For Tab PO Entry
	public WebElement weTabPOEntry;
	
	@FindAll({ @FindBy(xpath = "//*[@id='Job_Name']") })
	// Locator For Excel View PO Name
	public List<WebElement> weInputBoxExcelPONames;

	@FindAll({ @FindBy(xpath = "//*[@id='Vendors_ID']") })
	// Locator For Excel View Vendor ID
	public List<WebElement> weListExcelVendors;

	@FindBy(xpath = "//tr[1]//select[@id='Vendor_Contact_ID']")
	// Locator For Excel View Vendor Contact
	public WebElement weInputBoxExcelVendorContact;

	@FindBy(xpath = "//tr[1]//input[@id='Vendor_Number']")
	// Locator For Excel View Vendor Number
	public WebElement weInputBoxExcelVendorNumber;

	@FindAll({ @FindBy(xpath = "//*[@id='UsersData_ID']") })
	// Locator For Excel View Manager
	public List<WebElement> weListExcelManager;
	
	@FindBy(xpath = "//tr[@id='trPOExcelHeader']/th[text()='PO Name']")
	// Locator For Excel View text PO Name
	public WebElement weTextPOName;

	@FindBy(xpath = "//tr[1]//input[@id='PO_Number']")
	// Locator For Excel View Vendor PO Id
	public WebElement weInputBoxExcelPONumber;

	@FindBy(xpath = "//tr[1]//input[@id='CostCenter_IO']")
	// Locator For Excel View Cost center IO
	public WebElement weInputBoxExcelCostCenterIO;

	@FindBy(xpath = "//tr[2]//*[@id='tblPOLines']//td[3]//input")
	// Locator For Excel View Estimate
	public WebElement weInputBoxExcelEstimate;

	@FindBy(xpath = "//tr[2]//*[@id='tblPOLines']//td[4]//input")
	// Locator For Excel View Transaction Amount
	public WebElement weInputBoxExcelExcelTxnAmount;

	@FindBy(xpath = "//tr[3]//td[1]//button[2]")
	// Locator For Delete excel entry
	public WebElement weBtnDeleteExcelEntry;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='UsersData_ID']")
	// Locator For Excel manager
	public WebElement weInputBoxFormExcelManager;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='Vendors_ID']")
	// Locator For Excel Vendor
	public WebElement weInputBoxFormExcelVendor;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='Vendor_Contact_ID']")
	// Locator For Excel Contact
	public WebElement weInputBoxFormExcelVendorContact;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='PO_Number']")
	// Locator For Excel Po number
	public WebElement weInputBoxFormExcelPONumber;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='PO_Commit']")
	// Locator For Excel Commit amount
	public WebElement weInputBoxFormExcelCommit;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='PO_Posted']")
	// Locator For Excel Posted amount
	public WebElement weInputBoxFormExcelPosted;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='CostCenter_IO']")
	// Locator For Excel CostCenterIO
	public WebElement weInputBoxFormExcelCostCenterIO;

	@FindBy(xpath = "//tr[3]/td[4]//..//*[@id='Vendor_Number']")
	// Locator For Excel Vendor number
	public WebElement weInputBoxFormExcelVendorNumber;

	// --------------- Instantiating Web Elements Here

	public LocatorsPoEntry(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
