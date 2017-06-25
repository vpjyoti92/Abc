
package testScripts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.FlightBook;
import reusableFunctions.Keywords;

public class ValidateFlightBooking {

	// Variables for driver
	private AndroidDriver driver;
	public ATUTestRecorder recorder;
	static Process process;
	DateFormat format = new SimpleDateFormat("yy-mm-dd hh-mm-ss");
	Date date = new Date();
	

	// Variable declaration for validations

	private String sdepartureCity;
	private String sarrivingCity;
	private String sdeptDate;
	private String sarrivalDate;
	private String sadults;
	private String sdeptMonth;
	private String sarrivalMonth;
	private String scompleteDate;
	private String sarrivalPrice;
	private String sdeptPrice;
	private String stotalPrice;
	private String sstop;
	private String sflightType;
	private String sAdultFName="Hello";
	private String sAdultLName="User";
	private String sEmailAddress="abc@as.in";
	private String sPhoneNumber="7854236599";

	/*
	 * Method to set the driver variable
	 */
	
	@Parameters({ "deviceName", "browserName", "versionName", "platformName", "app","url" })
	@BeforeClass
	public void launch(String deviceName, String browserName, String versionName, String platformName,
			String app, String url) {
		try {
			Keywords.appiumStop();
			Keywords.appiumStart();
			recorder = Keywords.startRecorder();
			Thread.sleep(2000);
			recorder.start();
			InitializeDriver.setUp(deviceName, browserName, versionName, platformName, app, url);
			driver=InitializeDriver.driver;
			
		} catch (Exception e) {
			System.out.println("Exception while launching the driver with the Url :" + e.getMessage());
			Assert.fail();
		}
	}
	
	/*
	 * Method for booking the flight
	 */

	@Test
	public void runForFlightSearch() {

		
		driver=driverScript.InitializeDriver.driver;
		// -------Searching Flight----------//
		try {
			Thread.sleep(2000);
			try{
			new FlightBook(driver).weImgBackInsPage.click();
//			System.out.println("1");
			new FlightBook(driver).weImgBackInsPage.click();
			Thread.sleep(5000);
//			System.out.println("2");
			new FlightBook(driver).weLinkSkip.click();
			Thread.sleep(2000);
//			System.out.println("3");
			
			new FlightBook(driver).weLinkReferNow.click();
			new FlightBook(driver).weImgBackArrowInsPage.click();			
			new FlightBook(driver).weBtnOk.click();
			//new FlightBook(driver).weBtnOk.click();
			}
			catch(Exception e)
			{
				System.out.println("Application already installed");
			}
			try{
				new FlightBook(driver).weLinkReferNow.click();
				new FlightBook(driver).weImgBackArrowInsPage.click();			
				//new FlightBook(driver).weBtnOk.click();
			}
			catch(Exception e){
		     System.out.println("Application doesn't show the refer pop up");
			}
						
			new FlightBook(driver).weBtnOk.click();
			new FlightBook(driver).weLinkFlight.click();
			new FlightBook(driver).weElement1.click();
			Thread.sleep(2000);
			new FlightBook(driver).weLinkDepartureCity.sendKeys("PNQ");
			Thread.sleep(2000);
//			try{	
//			new FlightBook(driver).weTextFlights.isDisplayed();
//			}
//			catch(Exception e)
//			{
//				System.out.println("Departure city is not displayed :"+e.getMessage());
//				Assert.fail();
//			}
			try{
			new FlightBook(driver).weSearchArea.click();
			}
			catch (Exception e) {
            System.out.println("City selected is not getting displayed");
			}
			new FlightBook(driver).weLinkArrivalCity.click();
			new FlightBook(driver).weTabBanglore.click();
			new FlightBook(driver).weLinkDepartureDateSelector.click();
			new FlightBook(driver).weCalSelectingDate.click();
			new FlightBook(driver).weBtnOk1.click();
			new FlightBook(driver).weLinkReturnDateSelector.click();
			new FlightBook(driver).weCalReturnDate.click();
			new FlightBook(driver).weBtnOK2.click();
			new FlightBook(driver).weWindowAdultSelector.click();
			sadults = new FlightBook(driver).weTxtAdultCount.getText();
			int x = Integer.parseInt(sadults);
			System.out.println(x);
			if (x <= 1) {
				new FlightBook(driver).weLinkIncrement.click();
				System.out.println("Increment clicked");
				new FlightBook(driver).weBtnOk3.click();
				System.out.println("clicked on okay");
			} else {
				new FlightBook(driver).weBtnOk3.click();
			}
			new FlightBook(driver).weSelectEconomy.click();
			new FlightBook(driver).weSelectEconomyType.click();
			sdepartureCity = new FlightBook(driver).weTextPage1DepartCity.getText();
			sarrivingCity = new FlightBook(driver).weTextPage1ArrivalCity.getText();
			sdeptDate = new FlightBook(driver).weTextPage1DepartDate.getText();
			sdeptMonth = new FlightBook(driver).weTextPage1DeaprtMonth.getText();
			sarrivalDate = new FlightBook(driver).weTextPage1ArrivalDate.getText();
			sarrivalMonth = new FlightBook(driver).weTextPage1ArrivalMonth.getText();
			scompleteDate = sdeptDate + "" + sdeptMonth + "-" + sarrivalDate + "" + sarrivalMonth;
			sadults = new FlightBook(driver).weTextPage1AdultsCount.getText() + " " + "Adults";
			new FlightBook(driver).weBtnSearch.click();
 
		// -------Selecting the filters------------
	
			System.out.println("------------------------------Validation 1--------------------------------");
			if (sarrivingCity.equals((new FlightBook(driver).weTextPage2ArrivalCity).getText())
					&& sdepartureCity.equals((new FlightBook(driver).weTextPage2DepartCity).getText())
					&& sadults.equals(new FlightBook(driver).weTextPage2Adults.getText())) {
				System.out.println("Validated arriving city,departure city and Adults count ");
			}
			else{
				System.out.println("Validation 1 including arrival city, departure city , adults count is failed");
			}
			System.out.println("-----------------------------------------------------------------------------");
			Thread.sleep(2000);
			new FlightBook(driver).weLinkFilterSelector.click();
//			System.out.println("Filter Selected");
			Thread.sleep(2000);
			new FlightBook(driver).weLinkStopSElector.click();
			// System.out.println("Stop tab selected");
			new FlightBook(driver).weLinkStop.click();
			// System.out.println("1 stop selected");
			sstop = new FlightBook(driver).weTextStopNumber.getText();
			new FlightBook(driver).weLinkTimeSelector.click();
			// System.out.println("Time selector");
			new FlightBook(driver).weLinkTime.click();
			// System.out.println("Time selected of morning");
			new FlightBook(driver).weLinkAirlineSelector.click();
			// System.out.println("Airline selector");
			new FlightBook(driver).weLinkAirline.click();
			// System.out.println("Airline tyoe selected");
			new FlightBook(driver).weLinkMore.click();
			// System.out.println("More selected");
			new FlightBook(driver).weLinkMoreSelector.click();
			// System.out.println("More selection done");
			new FlightBook(driver).weBtnApply.click();
			// System.out.println("Clicked on Apply");
	
			// -----Selecting the Boarding and Arriving Flight-------------

			new FlightBook(driver).weLinkBoardingFlightSelector.click();
			//System.out.println("SElected bpoarding");
			new FlightBook(driver).weLinkBoardingFlight.click();
			//System.out.println("Selected Flight");
			sflightType = new FlightBook(driver).weTextFlightType.getText();
			sarrivalPrice = new FlightBook(driver).weTextPage3ArrivingAmount.getText();
			sdeptPrice = new FlightBook(driver).weTextPage3BoardingAmount.getText();
			stotalPrice = new FlightBook(driver).weTextPage3TotalAmount.getText();
			System.out.println("\n------------------------------Validation 2------------------------------");
			String temp = sstop + "Stop";
			if (temp.equals(new FlightBook(driver).weTextPage3Stop.getText())) {
				System.out.println("Validation2 completed as the correct number of stops selected:" + temp);
			}
			else
			{
				System.out.println("Validation 2 including number of stops to be validated is failed");
			}
			System.out.println("--------------------------------------------------------------------------");
			new FlightBook(driver).weBtnBooking.click();
				Thread.sleep(2000);
			System.out.println("\n------------------------------Validation 3------------------------------");
			String temp2 = sstop + " " + "Stop";
			if ((temp2.equals(new FlightBook(driver).weTextPage4Stop.getText()))
					&& (sflightType.equals(new FlightBook(driver).weTextPage4FlightType.getText()))) {
				System.out.println("Validation 3 completed with correct number of stops and flight type selected :" + sstop);
			}
			else
			{
				System.out.println("Validation 3 including the validation of stops and flight type are failed ");
			}
			System.out.println("-----------------------------------------------------------------------------");

			// -----Updating the information needed for flight booking-----

			new FlightBook(driver).weBtnContinueForBooking.click();
			new FlightBook(driver).weLinkDetailsDropdown.click();
			System.out.println("Detailed dropdwon clicked 1");
			new FlightBook(driver).weLinkDetailsDropdown.click();
			System.out.println("Detailed dropdwon clicked 2");
			new FlightBook(driver).weLinkAddNewAdults.click();
			System.out.println("Clicked on add new adults");
			new FlightBook(driver).weInputboxFirstName.sendKeys(sAdultFName);
			System.out.println("Entered first name");
			new FlightBook(driver).weInputboxLastName.sendKeys(sAdultLName);
			System.out.println("Entered last  name");
			new FlightBook(driver).weBtnFemaleSelector.click();
			System.out.println("SElected Female selector");
			new FlightBook(driver).weBtnDone.click();
			System.out.println("Clicked on Done Button");
            try{
			if(!new FlightBook(driver).weCheckboxSelectAdults.isSelected())
			{
				new FlightBook(driver).weCheckboxSelectAdults.click();
				System.out.println("Clicked on the checkbox for another alert if it is not checked");
			}
            }
            catch (Exception e) {

            System.out.println("Checkbox is already selected for adults selection");
            }
			
			try{
			if(new FlightBook(driver).weTextHeading.isDisplayed())
			{
				System.out.println("If  add  one more adult is displayed");
				new FlightBook(driver).weInputboxFirstName.sendKeys(sAdultFName);
				new FlightBook(driver).weInputboxLastName.sendKeys(sAdultLName);
				new FlightBook(driver).weBtnFemaleSelector.click();
				new FlightBook(driver).weBtnDone.click();
				Thread.sleep(2000);
			}
			
			}
			catch(Exception e)
			{
				System.out.println("Already the details of adults exist");

			}
//			Thread.sleep(1000);
			System.out.println("Selected specific adult");
			Keywords.scrollWindow(80, driver);
			//System.out.println("scrolled");
//			new FlightBook(driver).weInputBoxEmailAddress.clear();
			new FlightBook(driver).weInputBoxEmailAddress.sendKeys(sEmailAddress);
			//System.out.println("Email Entered");
			new FlightBook(driver).weInputboxPhoneNumber.sendKeys(sPhoneNumber);
			//System.out.println("Phone Number Entered");
			new FlightBook(driver).weBtnBookFlight.click();
			//System.err.println("Clicked on book flight");
			// Search another flight
			new FlightBook(driver).weBtnSelectAnotherFlight.click();
			// moving out using back button
			new FlightBook(driver).weImgBack1.click();
			// moving out using second back button
			new FlightBook(driver).weImgBack2.click();
			// moving out using third back button
			Thread.sleep(2000);
			new FlightBook(driver).weImgBack3.click();
			//moving back to the start page
			
			Thread.sleep(2000);
			//new FlightBook(driver).weImgLastBackArrow.click();
			System.out.println("Flight Booking flow completed");
		 
	}
		catch(Exception e)
		{
			System.out.println("Exception occurred reserving teh flight"+e.getMessage());
			Assert.fail();
		}
	}
	
	/*
	 * Method to close the recorder, stop driver and stop Appium server
	 */
	@AfterClass
	public void close() {
		try {
			// ------Stop Recorder and Closing the browser
			Keywords.stopRecoder(recorder);
//			driver.close();
			Keywords.appiumStop();

		} catch (Exception e) {
			System.out.println("Exception while closing the script:" + e.getMessage());
		//	Assert.fail();
		}

	}

}
