package test_scripts;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import driver_scripts.*;
import reusable.Methods;

public class CreatingApplication {

	private InitializeDriver InitializeDriver;
	private WebDriver driver;
	private ATUTestRecorder record;
	
	//Instance variables with the values
	
	public String sApplicationType = "National Grid";
	public String sBuildingName = "KalpeshBuilding1/SA-1";
	public String sIncentiveName = "Performance Lighting PLUS (PL+)";
	private String sTodaysDate;
	private String sApplicationName = "KalpeshApplication";
	private String sAccountNumber = "1234567890";
	private String sTelephoneNumber = "5874623145";
	private String sNotes = "Application requires floorplan image.";
	private String sStatus_First = "Awaiting";
	private String sComment_First = "Application requires floorplan image2.";
	private String sSupportingFileName = "Electrical plans showing lighting layouts";
	private String sFilePath = " ";
	private String sStatus_Second = "Approved";
	private String sComment_Second = "Approved with image";

	/**
	 * Launch Driver & Initialize Variables For Production Environment.
	 */
	@BeforeTest
	public void Launch_Driver() {
	
		reusable.Methods.testRecoder(record);
		InitializeDriver = new InitializeDriver();
		driver = InitializeDriver.driver;
		reusable.Actions.validhancockSoftwareLocators(driver, InitializeDriver.sUsername, InitializeDriver.sPassword);
		
	}

	/**
	 * Create new Incentive Application .
	 * Enter all the required information including project name , building , incentive type and save .
	 * Update the notes in the Dashboard and update the status to Awaiting .
	 * Upload the supporting files and click on save .
	 * Update the status to be Approved .
	 * Validate the status on the Incentive Dashboard.
	 */

	@Test
	public void createApplication() {
		try {

			sTodaysDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String sAppName = sApplicationName + sTodaysDate;

			new objectRepository.hancockSoftwareLocators(driver).weLinkIncentiveApplication.click();
			new objectRepository.hancockSoftwareLocators(driver).weLinkMyIncentiveApplication.click();
			new objectRepository.hancockSoftwareLocators(driver).weBtnNewApplication.click();

			// click on new Application button
			// new
			// objectRepository.hancockSoftwareLocators(driver).weBtnNewApplication.click();

			// selecting the Application Type and clicking on Continue
			WebElement weIncentiveApplication = new objectRepository.hancockSoftwareLocators(
					driver).weDropDownSelectIncentiveAplication;
			reusable.Methods.selectByVisibleText(weIncentiveApplication, sApplicationType);
			new objectRepository.hancockSoftwareLocators(driver).weBtnSelectIncentiveAplication.click();

			// selecting the Building
			WebElement weBuilding = new objectRepository.hancockSoftwareLocators(driver).weDropDownSelectBuilding;
			reusable.Methods.selectByVisibleText(weBuilding, sBuildingName);

			// selecting Incentive program
			WebElement weIncentive = new objectRepository.hancockSoftwareLocators(
					driver).weDropDownSelectIncentiveProgram;
			reusable.Methods.selectByVisibleText(weIncentive, sIncentiveName);

			// entering Application Name
			new objectRepository.hancockSoftwareLocators(driver).weInputboxApplicationName.sendKeys(sAppName);

			// entering Account Number
			new objectRepository.hancockSoftwareLocators(driver).weInputboxAccountNumber.sendKeys(sAccountNumber);

			// clicking on Save
			// new
			// objectRepository.hancockSoftwareLocators(driver).weBtnSave.click();

			Methods.javascriptClick(driver, new objectRepository.hancockSoftwareLocators(driver).weBtnSave);
			Thread.sleep(2000);

			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
			}
			Thread.sleep(2000);
			// Error msg validation

			// clicking on ClientTab
			Methods.javascriptClick(driver, new objectRepository.hancockSoftwareLocators(driver).weTabClientInfo);
//			new objectRepository.hancockSoftwareLocators(driver).weTabClientInfo.click();

			// entering Telephone Number
			new objectRepository.hancockSoftwareLocators(driver).weInputBoxTelephoneNumber.sendKeys(sTelephoneNumber);

			// clicking on Save
			new objectRepository.hancockSoftwareLocators(driver).weBtnSave.click();

			// clicking on Incentive Application on top menu
			new objectRepository.hancockSoftwareLocators(driver).weLinkIncentiveApplication.click();

			// clicking on DashBoard Link
			new objectRepository.hancockSoftwareLocators(driver).weLinkDashboardApplication.click();

			// clicking on the new Application created
			WebElement weElement = reusable.Methods.selectWebElementFromList(sAppName,
					new objectRepository.hancockSoftwareLocators(driver).weListNewApplicationsCreated);
			if (weElement == null)
				System.out.println("Element is not found Matching");
			else
				weElement.click();

			// entering text in notes of the New Application Created
			new objectRepository.hancockSoftwareLocators(driver).weInputBoxNotes.sendKeys(sNotes);

			// selecting the status to be Awaiting in the dropdown of Edit
			// Application Page
			WebElement weStatus1 = new objectRepository.hancockSoftwareLocators(driver).weDropDownStatus;
			reusable.Methods.selectByVisibleText(weStatus1, sStatus_First);

			// selecting the Update Button
			new objectRepository.hancockSoftwareLocators(driver).weBtnUpdateDashboard.click();

			// updating the comments in the Comment box
			new objectRepository.hancockSoftwareLocators(driver).weInputBoxComments.sendKeys(sComment_First);

			// clicking on the continue button to save the comment
			new objectRepository.hancockSoftwareLocators(driver).weBtnContinue.click();

			// clicking onIncentive Application on top-menu
			new objectRepository.hancockSoftwareLocators(driver).weLinkIncentiveApplication.click();

			// clicking the Application name we are working upon
			WebElement weElement2 = reusable.Methods.selectWebElementFromList(sAppName,
					new objectRepository.hancockSoftwareLocators(driver).weListApplications);
			if (weElement == null)
				System.out.println("Element is not found Matching");
			else
				weElement2.click();

			// clicking on Supporting File tab
			new objectRepository.hancockSoftwareLocators(driver).weTabSupportingFiles.click();

			// select SupportingFile type from dropdown
			WebElement sSupporting = new objectRepository.hancockSoftwareLocators(
					driver).weDropDownSupportingDocumentType;
			reusable.Methods.selectByVisibleText(sSupporting, sSupportingFileName);

			// clicking on Choose File button
			new objectRepository.hancockSoftwareLocators(driver).weBtnChooseFile.click();

			// selecting the file and uploading it
			reusable.Methods.runUploading(sFilePath);

			// click on Update Button on Supporting Files
			new objectRepository.hancockSoftwareLocators(driver).weBtnUpdateSupportingFile.click();

			// click on Submit Button on Supporting Files
			new objectRepository.hancockSoftwareLocators(driver).weBtnSubmitSupportingFile.click();

			// clicking on DashBoard Application
			new objectRepository.hancockSoftwareLocators(driver).weLinkDashboardApplication.click();

			// clicking on the Application been worked upon created

			WebElement weElement3 = reusable.Methods.selectWebElementFromList(sAppName,
					new objectRepository.hancockSoftwareLocators(driver).weListNewApplicationsCreated);
			if (weElement == null)
				System.out.println("Element is not found Matching");
			else
				weElement3.click();

			//
			// int iSize3=new
			// objectRepository.hancockSoftwareLocators(driver).weListNewApplicationsCreated.size();
			// List<WebElement> lList3=new
			// objectRepository.hancockSoftwareLocators(driver).weListNewApplicationsCreated;
			// for(int i=0; i<iSize3; i++)
			// {
			// String str=lList1.get(i).getText();
			// System.out.println("Applications :"+str);
			// if(str.equals(sAppName))
			// {
			// lList1.get(i).click();
			// break;
			// }
			//
			// }

			// selecting Approved from the dropdown
			WebElement weStatus2 = new objectRepository.hancockSoftwareLocators(driver).weDropDownStatus;
			reusable.Methods.selectByVisibleText(weStatus2, sStatus_Second);

			// clicking on Update button
			new objectRepository.hancockSoftwareLocators(driver).weBtnUpdateDashboard.click();

			// entering final Comments in the Comment window
			new objectRepository.hancockSoftwareLocators(driver).weInputBoxComments.sendKeys(sComment_Second);

			// clicking on the Continue button
			new objectRepository.hancockSoftwareLocators(driver).weBtnContinue.click();

		} catch (Exception e) {
			System.out.println("Failed beacuse of some element" + e.getMessage());
		}

	}
	/**
	 * Close the driver.
	 */
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
