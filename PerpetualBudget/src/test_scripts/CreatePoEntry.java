/**
 * Class Description - 
 */
package test_scripts;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import driver_scripts.InitializeDriver;
import object_repo.AddNewPO;
import object_repo.LocatorsPoEntry;
import reusable.PBActions;
import reusable.PBKeywords;

public class CreatePoEntry {

	private WebDriver driver;
	private InitializeDriver InitializeDriver;
	
	// Test data for Detail and Normal view
	
	private static String sTestDataFilePath = "test-data/TestData.pdf";
	private String sTodayssDate;
	private String sCommitAmount = "100";
	private String sTransAmount = "200";
	private String sBudget = "Energy Efficient";
	private String sAccount = "French Door Refrigerators";
	private String sProject = "PRO 26-01";
	private String sPOName;
	private String sVendor = "From Desk";
	private String sVendorContact = "john@spicer-baer.com";
	private String sManager = "rakesh@gmail.com";
	private String sEstimateNumber = "123";
	private String sPoNumber = "123";
	private String sShoppingCartNo = "123";
	private String sIONumber = "123";

	// Test data for Excel view
	
	private String sExcelVendorValue = "Vendor 01";
	private String sExcelVendorContactValue = "john@spicer-baer.com";
	private String sExcelVendorNumberValue = "V00003";
	private String sExcelPONumberValue = "3456";
	private String sExcelCostCenterIOValue = "4567";
	private String sExcelEstimateValue = "4000";
	private String sExcelTrnAmountValue = "1000";
	private String sExcelManagerValue = "Default Admin";

	// Temporary variables to get data form Excel view form
	
	private String sExcelManager;
	private String sExcelVendor;
	private String sExcelVendorContact;
	private String sExcelPONumber;
	private String sExcelCommitAmount;
	private String sExcelPostedAmount;
	private String sExcelCostCenterIO;
	private String sExcelVendorNumber;

	/**
	 * Launch Driver & Initialize Variables For Production Environment.
	 */
	@BeforeClass
	public void Launch_Driver() {
		InitializeDriver = new InitializeDriver();
		driver = InitializeDriver.driver;
		reusable.PBActions.validLogin(driver, InitializeDriver.sUsername, InitializeDriver.sPassword);
	}
	
	/**
	 * Select Project From Left Panel Menu List
	 * Click Add New PO
	 * Verify Budget, Project & Account Information.
	 * Upload a File
	 * Fill Up the Detail View Form
	 * Verify Transaction Amount & Commit Amount.
	 * Save the Form.
	 * Open The PO in Edit Mode. Verify All Fields That Were Entered While Creating the PO.
	 * Delete the PO
	 * Verify PO Deleted  
	 */
	@Test(priority=0)
	public void Create_Po_Entry_Detail_View() {
		try {
			
			PBActions.waitForLoading(driver);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownProject.click();
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			PBKeywords.hoverToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			new LocatorsPoEntry(driver).weBtnTreeOptions.click();
			new LocatorsPoEntry(driver).weDropDownAddNewPO.click();
			
			//--- Wait for Add New Window
			
			PBKeywords.waitForElementToBeVisible(new AddNewPO(driver).weAddNewHeader, driver);
			Thread.sleep(1000); // --- Delay - Values Do not pop up instantly.
			
			//--- Verify Budget, Project & Account Information.
			
			AddNewPO objAddNewPO = new AddNewPO(driver);
			if (PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputBudget, driver).equals(sBudget) && PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputAccount, driver).equals(sAccount) && PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputProject, driver).equals(sProject)) {
				System.out.println("Verified Budget, Account & Project Information");
			} else {
				System.out.println("Could not verify Budget, Account & Project Information");
				Assert.fail();
			}
			new LocatorsPoEntry(driver).weBtnAddFiles.click();
			PBKeywords.uploadFile(sTestDataFilePath);
			new LocatorsPoEntry(driver).weBtnNext.click();
			
			// --- Fill Detail View Form
			
			new LocatorsPoEntry(driver).weBtnDetailView.click();
			sTodayssDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()).toString();
			new LocatorsPoEntry(driver).weInputBoxPOName.click();
			sPOName = "PODV" + sTodayssDate;
			new LocatorsPoEntry(driver).weInputBoxPOName.sendKeys(sPOName);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weDropDownVendor);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weDropDownVendor, sVendor);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weDropDownManager);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weDropDownManager, sManager);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxEstimateNumber);
			new LocatorsPoEntry(driver).weInputBoxEstimateNumber.clear();
			new LocatorsPoEntry(driver).weInputBoxEstimateNumber.sendKeys(sEstimateNumber);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxPONumber);
			new LocatorsPoEntry(driver).weInputBoxPONumber.clear();
			new LocatorsPoEntry(driver).weInputBoxPONumber.sendKeys(sPoNumber);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxShoppingCartNumber);
			new LocatorsPoEntry(driver).weInputBoxShoppingCartNumber.clear();
			new LocatorsPoEntry(driver).weInputBoxShoppingCartNumber.sendKeys(sShoppingCartNo);
			
			// --- Handle Date Pickers
			
			new LocatorsPoEntry(driver).weDateRequestStart.clear();
			new LocatorsPoEntry(driver).weDateRequestStart.click();
			PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weBtnCalenderCurrentDate, "22").click();
			new LocatorsPoEntry(driver).weDateRequestEnd.clear();
			new LocatorsPoEntry(driver).weDateRequestEnd.click();
			PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weBtnCalenderCurrentDate, "22").click();
			
			// --- Fill Rest of the Form
			
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxIONumber);
			new LocatorsPoEntry(driver).weInputBoxIONumber.clear();
			new LocatorsPoEntry(driver).weInputBoxIONumber.sendKeys(sIONumber);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weCheckBoxShowAll);
			new LocatorsPoEntry(driver).weCheckBoxShowAll.click();
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxTransAmountPOLine);
			new LocatorsPoEntry(driver).weInputBoxTransAmountPOLine.clear();
			new LocatorsPoEntry(driver).weInputBoxTransAmountPOLine.click();
			new LocatorsPoEntry(driver).weInputBoxTransAmountPOLine.sendKeys(sTransAmount);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weTextTransAmountPosted);
			new LocatorsPoEntry(driver).weTextTransAmountPosted.click();
			new LocatorsPoEntry(driver).weInputBoxCommitAmountPOLine.clear();
			new LocatorsPoEntry(driver).weInputBoxCommitAmountPOLine.click();
			new LocatorsPoEntry(driver).weInputBoxCommitAmountPOLine.sendKeys(sCommitAmount);
			new LocatorsPoEntry(driver).weTextTransAmountPosted.click();
			
			String TransAmountPOheader = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxTransAmountPOHeader, driver);
			String CommitAmountPOheader = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxCommitAmountPOHeader, driver);
			if (TransAmountPOheader.equals(sTransAmount) && CommitAmountPOheader.equals(sCommitAmount)) {
				System.out.println("Verified Transaction and Commit Amount in PO header and PO lines ");
			} else {
				System.out.println("Error in verifing Transaction and Commit Amount in PO header and PO lines Amount");
				Assert.fail();
			}
			PBKeywords.scrollToAndClick(driver, new LocatorsPoEntry(driver).weBtnSave);
			PBActions.waitForLoading(driver);
			
			// --- Select PO From Left Panel 
			
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			WebElement wePurchaseOrder = PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName);
			PBKeywords.scrollToElement(driver, wePurchaseOrder);
			PBKeywords.hoverToElement(driver, wePurchaseOrder);
			WebElement weButtonOptions = wePurchaseOrder.findElement(By.xpath(new LocatorsPoEntry(driver).weBtnOptionsLeftPanel));
			weButtonOptions.click();
			Thread.sleep(1000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weBtnEditOptionsLeftPanel);
			new LocatorsPoEntry(driver).weBtnNext.click();
			
			Thread.sleep(3000); // --- Delay for Validation - Values Do Not Pop Up Instantly
			
			String sActualPOName = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxPOName, driver);
			String sActualVendorName = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownVendor, driver);
			String sActualVendorContact = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownVendorContact, driver);
			String sActualManager = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownManager, driver);
			String sActualEstimateNumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxEstimateNumber, driver);
			String sActualPoNumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxPONumber, driver);
			String sActualShoppingCartNo = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxShoppingCartNumber, driver);
			String sActualIONumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxIONumber, driver);
			System.out.println("LOG: " +sActualPOName +" " +sActualVendorName +" " +sActualVendorContact +" " +sActualManager +" " +sActualEstimateNumber 
					+" " +sActualPoNumber +" " +sActualShoppingCartNo +" " +sActualIONumber);
			if (sActualPOName.equals(sPOName) && sActualVendorName.contains(sVendor) && sActualVendorContact.equals(sVendorContact)
					&& sActualManager.equals(sManager) && sActualEstimateNumber.equals(sEstimateNumber) && sActualPoNumber.equals(sPoNumber)
					&& sActualShoppingCartNo.equals(sShoppingCartNo) && sActualIONumber.equals(sIONumber)) {
				System.out.println("Verified Fields of form in Detail View");
			} else {
				System.out.println("Error In Verifing Fields of form in Detail View");
				Assert.fail();
			}
			PBKeywords.scrollToAndClick(driver, new LocatorsPoEntry(driver).weBtnCancel);
			
			// ----- Delete PO
			
			Thread.sleep(1000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			wePurchaseOrder = PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName);
			PBKeywords.scrollToElement(driver, wePurchaseOrder);
			PBKeywords.hoverToElement(driver, wePurchaseOrder);
			weButtonOptions = wePurchaseOrder.findElement(By.xpath(new LocatorsPoEntry(driver).weBtnOptionsLeftPanel));
			weButtonOptions.click();
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weBtnDeleteOptionsLeftPanel);
			Thread.sleep(1000);
			new LocatorsPoEntry(driver).weBtnDeleteConfirmationYes.click();
			
			// ----- Verify If PO Deleted
			
			Thread.sleep(1000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			if(!PBKeywords.isWebelementExistInList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName)){
				System.out.println("Deleted Successfully Purchase Order - " +sPOName);
			}else {
				System.out.println("Failed to Delete Purchase Order - " +sPOName);
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while creating PO entry in Detail View  " + e.getMessage());
			Assert.fail();
		}
	}
	
	/**
	 * Select Project From Left Panel Menu List
	 * Click Add New PO
	 * Verify Budget, Project & Account Information.
	 * Fill Up the Normal View Form
	 * Save the Form.
	 * Open The PO in Edit Mode. Verify All Fields That Were Entered While Creating the PO.
	 * Delete the PO
	 * Verify PO Deleted
	 */
	@Test
	public void Create_Po_Entry_Normal_View() {
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			PBActions.waitForLoading(driver);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownProject.click();
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			PBKeywords.hoverToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			new LocatorsPoEntry(driver).weBtnTreeOptions.click();
			new LocatorsPoEntry(driver).weDropDownAddNewPO.click();
			
			//--- Wait for Add New Window
			
			PBKeywords.waitForElementToBeVisible(new AddNewPO(driver).weAddNewHeader, driver);
			Thread.sleep(1000); // --- Delay - Values Do not pop up instantly.
			
			//--- Verify Budget, Project & Account Information.
			
			AddNewPO objAddNewPO = new AddNewPO(driver);
			if (PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputBudget, driver).equals(sBudget) && PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputAccount, driver).equals(sAccount) && PBKeywords.javascriptGetValueOfElement(objAddNewPO.weInputProject, driver).equals(sProject)) {
				System.out.println("Verified Budget, Account & Project Information");
			} else {
				System.out.println("Could not verify Budget, Account & Project Information");
				Assert.fail();
			}
			new LocatorsPoEntry(driver).weBtnNext.click();
			
			// ----- Fill Up Normal View Form 
			
			new LocatorsPoEntry(driver).weBtnNormalView.click();
			sTodayssDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()).toString();
			new LocatorsPoEntry(driver).weInputBoxPOName.click();
			sPOName = "PONV" + sTodayssDate;
			new LocatorsPoEntry(driver).weInputBoxPOName.sendKeys(sPOName);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weDropDownVendor);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weDropDownVendor, sVendor);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weDropDownManager);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weDropDownManager, sManager);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxEstimateNumber);
			new LocatorsPoEntry(driver).weInputBoxEstimateNumber.clear();
			new LocatorsPoEntry(driver).weInputBoxEstimateNumber.sendKeys(sEstimateNumber);
			
			// --- Handle Date Pickers
			
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weDateRequestStart);
			new LocatorsPoEntry(driver).weDateRequestStart.clear();
			new LocatorsPoEntry(driver).weDateRequestStart.click();
			PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weBtnCalenderCurrentDate, "22").click();
			new LocatorsPoEntry(driver).weDateRequestEnd.clear();
			new LocatorsPoEntry(driver).weDateRequestEnd.click();
			PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weBtnCalenderCurrentDate, "22").click();

			// --- Fill Rest of the Form
			
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxIONumber);
			new LocatorsPoEntry(driver).weInputBoxIONumber.clear();
			new LocatorsPoEntry(driver).weInputBoxIONumber.sendKeys(sIONumber);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weInputBoxCommitAmount);
			new LocatorsPoEntry(driver).weInputBoxCommitAmount.clear();
			new LocatorsPoEntry(driver).weInputBoxCommitAmount.sendKeys(sCommitAmount);
			PBKeywords.scrollToAndClick(driver, new LocatorsPoEntry(driver).weBtnSave);
			PBActions.waitForLoading(driver);
			
			// --- Select PO From Left Panel 
			
			Thread.sleep(2000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			WebElement wePurchaseOrder = PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName);
			PBKeywords.scrollToElement(driver, wePurchaseOrder);
			PBKeywords.hoverToElement(driver, wePurchaseOrder);
			WebElement weButtonOptions = wePurchaseOrder.findElement(By.xpath(new LocatorsPoEntry(driver).weBtnOptionsLeftPanel));
			weButtonOptions.click();
			new LocatorsPoEntry(driver).weBtnEditOptionsLeftPanel.click();
			new LocatorsPoEntry(driver).weBtnNext.click();
			
			Thread.sleep(3000); // --- Delay for Validation - Values Do Not Pop Up Instantly
			
			String sActualPOName = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxPOName, driver);
			String sActualVendorName = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownVendor, driver);
			String sActualVendorContact = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownVendorContact, driver);
			String sActualManager = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weDropDownManager, driver);
			String sActualEstimateNumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxEstimateNumber, driver);
			String sActualIONumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxIONumber, driver);
			String sActualCommitAmount = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxCommitAmount, driver);
			
			System.out.println( "LOG: " +sActualPOName +" " +sActualVendorName +" " +sActualVendorContact +" " +sActualManager +" " +sActualEstimateNumber +" " +sActualIONumber +" " +sActualCommitAmount);
			
			if (sActualPOName.equals(sPOName) && sActualVendorName.contains(sVendor) && sActualVendorContact.equals(sVendorContact)
					&& sActualManager.equals(sManager) && sActualEstimateNumber.equals(sEstimateNumber) && sActualCommitAmount.equals(sCommitAmount)
					&& sActualIONumber.equals(sIONumber)) {
				System.out.println("Verified Fields of form in Normal View");
			} else {
				System.out.println("Error In Verifing Fields of form in Normal View");
				Assert.fail();
			}
			PBKeywords.scrollToAndClick(driver, new LocatorsPoEntry(driver).weBtnCancel);
			
			// ----- Delete PO
			
			Thread.sleep(1000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			wePurchaseOrder = PBKeywords.getWebelementFromList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName);
			PBKeywords.scrollToElement(driver, wePurchaseOrder);
			PBKeywords.hoverToElement(driver, wePurchaseOrder);
			weButtonOptions = wePurchaseOrder.findElement(By.xpath(new LocatorsPoEntry(driver).weBtnOptionsLeftPanel));
			weButtonOptions.click();
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weBtnDeleteOptionsLeftPanel);
			Thread.sleep(1000);
			new LocatorsPoEntry(driver).weBtnDeleteConfirmationYes.click();
			
			// ----- Verify If PO Deleted
			
			Thread.sleep(1000);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownPurchaseOrder.click();
			if(!PBKeywords.isWebelementExistInList(new LocatorsPoEntry(driver).weListLeftPanelItems, sPOName)){
				System.out.println("Deleted Successfully Purchase Order - " +sPOName);
			}else {
				System.out.println("Failed to Delete Purchase Order - " +sPOName);
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while creating PO entry in Normal view " + e.getMessage());
			Assert.fail();
		}
	}

	/**
	 * Select Project From Left Panel Menu List
	 * Click PO ENTRY Tab
	 * Fill Up the Excel View Form. It should be auto Saved.
	 * Refresh the tree list and Verify the PO Details that were Saved 
	 * Delete the PO
	 * Verify PO Deleted
	 */
	@Test
	public void Create_Po_Entry_Excel_View() {
		Boolean bFlag = false;
		try {
			driver.navigate().refresh();
			Thread.sleep(2000);
			PBActions.waitForLoading(driver);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownProject.click();
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			new LocatorsPoEntry(driver).weBtnTreeProject.click();
			Thread.sleep(2000);
			sTodayssDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date()).toString();
			sPOName = "POEV" + sTodayssDate;
			
			// Entering PO Name in Excel format.
			
			new LocatorsPoEntry(driver).weTabPOEntry.click();
			new LocatorsPoEntry(driver).weInputBoxExcelPONames.get(0).sendKeys(sPOName);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weListExcelVendors.get(0), sExcelVendorValue);
			PBActions.waitForLoading(driver);
			Thread.sleep(1000);

			// --- Verification of Vendor Contact
			
			String sActualVendorContact = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weInputBoxExcelVendorContact, driver);
			if (sActualVendorContact.equalsIgnoreCase(sExcelVendorContactValue)) {
				System.out.println("Correct - Vendor contact information");
			} else {
				System.out.println("Incorrect - Vendor contact information");
			}
			Thread.sleep(1000);
			PBKeywords.dropdownSelectByVisibleText(new LocatorsPoEntry(driver).weListExcelManager.get(0), sExcelManagerValue);
			Thread.sleep(1000);
			new LocatorsPoEntry(driver).weInputBoxExcelPONumber.sendKeys(sExcelPONumberValue);
			new LocatorsPoEntry(driver).weInputBoxExcelCostCenterIO.sendKeys(sExcelCostCenterIOValue);
			new LocatorsPoEntry(driver).weInputBoxExcelEstimate.sendKeys(sExcelEstimateValue);
			new LocatorsPoEntry(driver).weInputBoxExcelExcelTxnAmount.sendKeys(sExcelTrnAmountValue);
			Thread.sleep(1000);
			new LocatorsPoEntry(driver).weTextPOName.click();
			PBActions.waitForLoading(driver);
			
			// --- Select PO & Verify the PO Form In Excel View
			
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weDropdownToggle);
			new LocatorsPoEntry(driver).weDropdownProject.click();
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weBtnTreeProject);
			new LocatorsPoEntry(driver).weBtnTreeProject.click();
			Thread.sleep(2000);
			List<WebElement> listItems = new LocatorsPoEntry(driver).weInputBoxExcelPONames;
			for (int i = 0; i < listItems.size(); i++) {
				WebElement we = new LocatorsPoEntry(driver).weInputBoxExcelPONames.get(i);
				Thread.sleep(250);
				String SPOName = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", we);
				if (sPOName.equals(SPOName)) {
					bFlag = true;
					PBKeywords.scrollToElement(driver, we);
					break;
				}
			}
			
			sExcelManager = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weInputBoxFormExcelManager, driver);
			System.out.println(sExcelManager);
			/*sExcelVendor = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weInputBoxFormExcelVendor, driver);
			System.out.println(sExcelVendor);*/
			/*sExcelVendorContact = PBKeywords.javascriptGetValueOfDropDown(new LocatorsPoEntry(driver).weInputBoxFormExcelVendorContact, driver);
			System.out.println(sExcelVendorContact);*/
			sExcelPONumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxFormExcelPONumber, driver);
			System.out.println(sExcelPONumber);
			sExcelCommitAmount = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxFormExcelCommit, driver);
			System.out.println(sExcelCommitAmount);
			sExcelPostedAmount = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxFormExcelPosted, driver);
			System.out.println(sExcelPostedAmount);
			sExcelCostCenterIO = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxFormExcelCostCenterIO, driver);
			System.out.println(sExcelCostCenterIO);
			sExcelVendorNumber = PBKeywords.javascriptGetValueOfElement(new LocatorsPoEntry(driver).weInputBoxFormExcelVendorNumber, driver);
			System.out.println(sExcelVendorNumber);
			
			Thread.sleep(1000);
			new LocatorsPoEntry(driver).weBtnTreeProject.click();
			Thread.sleep(1000);
			PBKeywords.scrollToElement(driver, new LocatorsPoEntry(driver).weBtnDeleteExcelEntry);
			PBKeywords.javascriptClick(driver, new LocatorsPoEntry(driver).weBtnDeleteExcelEntry);
			new LocatorsPoEntry(driver).weBtnDeleteConfirmationYes.click();
			
			if (bFlag && sExcelManager.equals(sExcelManagerValue) && sExcelPONumber.equals(sExcelPONumberValue)
					&& sExcelCommitAmount.equals(sExcelEstimateValue) && sExcelPostedAmount.equals(sExcelTrnAmountValue)
					&& sExcelCostCenterIO.equals(sExcelCostCenterIOValue) /*&& sExcelVendor.equals(sExcelVendorValue)*/
					/*&& sExcelVendorContact.equals(sExcelVendorContactValue)*/
					&& sExcelVendorNumber.equals(sExcelVendorNumberValue)) {
				System.out.println("Verified Form In Excel View");
			} else {
				System.out.println("Error in verifing fields of form in Excel View");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while creating PO entry in Excel View  " + e.getMessage());
			Assert.fail();
		}
	}

	/**
	 * Close the driver.
	 */
	@AfterClass
	public void Close_Driver() {
		driver.close();
	}

}