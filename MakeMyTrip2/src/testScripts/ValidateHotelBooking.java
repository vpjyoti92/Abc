package testScripts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.FlightBook;
import reusableFunctions.Keywords;

public class ValidateHotelBooking {

	private AndroidDriver driver;
	public ATUTestRecorder recorder;
	static Process process;
	DateFormat format = new SimpleDateFormat("yy-mm-dd hh-mm-ss");
	Date date = new Date();

	// Variables declared for the validations
	private String sPage1Dcity = "Bhopal";
	String sPage1Acity, sPage1DDate, sPage1Adults, sPage1Child, sPage1Rooms, sPage1ADate;
	String sPage2ADate, sPage2DDate, sPage2Rooms, sPage2City;
	int nPage2Traveller;
	String sPage3HotelName, sPage4HotelName, sPage4HotelAddress, sPage3AddressFilter;

	/*
	 * Method to set the driver variable
	 */
	@Parameters({ "deviceName", "browserName", "versionName", "platformName", "app", "url" })
	@BeforeClass
	public void launch(String deviceName, String browserName, String versionName, String platformName, String app,
			String url) {
		try {
			Keywords.appiumStop();
			Keywords.appiumStart();
			recorder = Keywords.startRecorder();
			Thread.sleep(2000);
			recorder.start();
			InitializeDriver.setUp(deviceName, browserName, versionName, platformName, app, url);
			driver = InitializeDriver.driver;
		} catch (Exception e) {
			System.out.println("Exception while launching the driver with the Url :" + e.getMessage());
			Assert.fail();
		}
	}

	/*
	 * Method to book the flight
	 */
	@Test
	public void hotelBooking() {

		try {
			try {
				new FlightBook(driver).weImgBackInsPage.click();
				System.out.println("1");
				new FlightBook(driver).weImgBackInsPage.click();
				Thread.sleep(5000);
				System.out.println("2");
				new FlightBook(driver).weLinkSkip.click();
				Thread.sleep(2000);
				System.out.println("3");
				new FlightBook(driver).weLinkReferNow.click();
				new FlightBook(driver).weImgBackArrowInsPage.click();
				new FlightBook(driver).weBtnOk.click();
				new FlightBook(driver).weBtnOk.click();
				new FlightBook(driver).weImgBackArrow.click();

			} catch (Exception e) {
				System.out.println("Application already downloaded");
			}

			try{
				new FlightBook(driver).weLinkReferNow.click();
				new FlightBook(driver).weImgBackArrowInsPage.click();			
				new FlightBook(driver).weBtnOk.click();
			}
			catch(Exception e)
			{
				System.out.println("Refer Now does not displayed");
			}
			new FlightBook(driver).weBtnOk.click();
			new objectRepository.HotelBook(driver).weLinkHotels.click();

			new objectRepository.HotelBook(driver).weTextSearchLocation.click();
			// Entering text in text area
			Thread.sleep(2000);
			new objectRepository.HotelBook(driver).weInputSearchCityText.sendKeys(sPage1Dcity);
			Thread.sleep(2000);
			// Selecting the first option
			new objectRepository.HotelBook(driver).weLinkFirstOccurenceCity.click();
			// Selecting the Check-In tab
			new objectRepository.HotelBook(driver).weLinkCheckIn.click();
			// Selecting the relevant date
			String dtemp1 = new objectRepository.HotelBook(driver).weLinkCheckInDate.getText();
			// String dtemp2=new
			// objectRepository.HotelBook(driver).HOTEL_CHECKIN_MONTH.getText();
			new objectRepository.HotelBook(driver).weLinkCheckInDate.click();
			// clicking on ok
			new objectRepository.HotelBook(driver).weBtnOk.click();
			// selecting the rooms tab
			new objectRepository.HotelBook(driver).weLinkRoom.click();
			// validating and entering the adults
			String x = new objectRepository.HotelBook(driver).weTextAdultCount.getText();
			int x1 = Integer.parseInt(x);
			// System.out.println(x1);
			String y = new objectRepository.HotelBook(driver).weTextChildCount.getText();
			int y2 = Integer.parseInt(y);
			// System.out.println(y2);
			if (x1 >= 2) {
				// decrementing the adults
				new objectRepository.HotelBook(driver).weImgAdultIncrement.click();
				if (y2 > 1) {
					new objectRepository.HotelBook(driver).weImgChildDecrement.click();
				} else if (y2 <= 0) {
					new objectRepository.HotelBook(driver).weImgChildIncrement.click();
					new objectRepository.HotelBook(driver).weLinkChildSelector.click();
				} else {
					new objectRepository.HotelBook(driver).weLinkChildSelector.click();
				}
			} else {
				if (y2 > 1) {
					new objectRepository.HotelBook(driver).weImgChildDecrement.click();
				} else if (y2 <= 0) {
					new objectRepository.HotelBook(driver).weImgChildIncrement.click();
					new objectRepository.HotelBook(driver).weLinkChildSelector.click();
				} else {
					new objectRepository.HotelBook(driver).weLinkChildSelector.click();
				}
			}
			// selecting done
			new objectRepository.HotelBook(driver).weBtnDone.click();
			// Printing all the values

			System.out.println(
					"\n-------------------------------------------------Page 1------------------------------------------------");
			// System.out.println("City Selected :"+p1_dcity);
			String dtemp2 = new objectRepository.HotelBook(driver).weTextPage1DMonth.getText();
			sPage1DDate = dtemp1 + " " + dtemp2;
			// System.out.println(dtemp1);
			// System.out.println(dtemp2);
			System.out.println("Departure date :" + sPage1DDate);

			String atemp1 = new objectRepository.HotelBook(driver).weTextPage1ADate.getText();
			String atemp2 = new objectRepository.HotelBook(driver).weTextPage1AMonth.getText();
			sPage1ADate = atemp1 + " " + atemp2;
			System.out.println("Arrival Date :" + sPage1ADate);

			sPage1Adults = new objectRepository.HotelBook(driver).weTextPage1AdultCount.getText();
			System.out.println("Adults Selected :" + sPage1Adults);
			int i = Integer.parseInt(sPage1Adults);

			sPage1Child = new objectRepository.HotelBook(driver).weTextPage1ChildCount.getText();
			System.out.println("Childs Selected :" + sPage1Child);

			int j = Integer.parseInt(sPage1Child);
			int p1_traveller = i + j;

			sPage1Rooms = new objectRepository.HotelBook(driver).weTextPage1RoomCount.getText();
			System.out.println("Rooms Selected :" + sPage1Rooms);

			System.out.println(
					"--------------------------------------------------------------------------------------------------");
			// Selecting search hotels on page 1
			new objectRepository.HotelBook(driver).weBtnSearch.click();
			// Accepting the pop up button
			try {
				new objectRepository.HotelBook(driver).weBtnOkGotIt.click();
			}
			catch(Exception e)
			{
				System.out.println("OK Got it is not present");
			}
			//second okay got it
			try {
				new objectRepository.HotelBook(driver).weBtnOkGotIt.click();
			}
			catch(Exception e)
			{
				System.out.println("OK Got it is not present");
			}
			//skip pop up
				try{
				new objectRepository.HotelBook(driver).weLinkSkip.click();
			} catch (Exception e) {
				System.out.println("Skip is not present");
			}
			Thread.sleep(3000);
			// assigning values
//			sPage2ADate = new objectRepository.HotelBook(driver).weTextPage2ADate.getText().trim();
//			sPage2DDate = new objectRepository.HotelBook(driver).weTextPage2DDate.getText().trim();
			String p2_travel = new objectRepository.HotelBook(driver).weTextPage2ATraveller.getText();
			System.out.println(p2_travel);
			nPage2Traveller = Integer.parseInt(p2_travel);
			System.out.println(nPage2Traveller);
			sPage2City = new objectRepository.HotelBook(driver).weTextPage2City.getText();
			System.out.println(sPage2City);
			// System.out.println("Page2 :"+p2_adate);
			System.out.println(
					"----------------------------------------------Validation1----------------------------------------");
			if (sPage1Dcity.equalsIgnoreCase(sPage1Dcity) && p1_traveller == nPage2Traveller) {
				System.out.println("\nValidation1 completed with correct Arrival Date , City and Number of Travellers");
			} else {
				System.out.println("Validation1 including Arrival Date , City and Number of Travellers is failed");
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			new objectRepository.HotelBook(driver).weLinkFilter.click();
			new objectRepository.HotelBook(driver).weBtnFilterDone.click();
			// selecting the location
			new objectRepository.HotelBook(driver).weLinkFilterLocation.click();
			// storing the location filter
			sPage3AddressFilter = new objectRepository.HotelBook(driver).weLinkFilterLocationSelector.getText();
			// System.out.println(p3_addressFilter);
			// selecting the location area
			new objectRepository.HotelBook(driver).weLinkFilterLocationSelector.click();
			// clicking on done
			new objectRepository.HotelBook(driver).weBtnFilterDone.click();
			// Selecting the rating filter
			new objectRepository.HotelBook(driver).weLinkFilterRating.click();
			// SElecting the stars
			new objectRepository.HotelBook(driver).weLinkFilterRatingStars.click();
			// selecting done
			new objectRepository.HotelBook(driver).weBtnFilterDone.click();
			// Sorting the hotels
			new objectRepository.HotelBook(driver).weLinkSorting.click();
			// sorting as per the rating
			new objectRepository.HotelBook(driver).weLinkSortingType.click();
			// storing the selected hotel name
			sPage3HotelName = new objectRepository.HotelBook(driver).weTextHotelName.getText();
			// selecting the specific hotel
			new objectRepository.HotelBook(driver).weLinkHotelSelection.click();
			// selecting the photos tab
			new objectRepository.HotelBook(driver).weTabPhotos.click();
			// selecting the reviews tab
			new objectRepository.HotelBook(driver).weTabReviews.click();
			// selecting the Summary Tab
			new objectRepository.HotelBook(driver).weTabSummary.click();
			sPage4HotelName = new objectRepository.HotelBook(driver).weTextPage3HotelName.getText();
			sPage4HotelAddress = new objectRepository.HotelBook(driver).weTextPage3Address.getText();
			// System.out.println(p4_hotelAddress);
			System.out.println(
					"\n--------------------------------------Validation 2------------------------------------------");
			if (sPage4HotelName.equalsIgnoreCase(sPage3HotelName)) {
				System.out.println("validation 2 completed with hotel is correctly displayed " + sPage4HotelName);
			} else {
				System.out.println("Validation 2 of hotel name s failed");
			}
			System.out.println(
					"-----------------------------------------------------------------------------------------------");
			// clicks on select the room button
			new objectRepository.HotelBook(driver).weBtnSelectRoom.click();
			// click on continue button
			new objectRepository.HotelBook(driver).weBtnContinue.click();
			// click on details dropper on the review page
			new objectRepository.HotelBook(driver).weLinkDetailsDropper.click();
			// page 4 contents
			String p4_cindate = new objectRepository.HotelBook(driver).weTextPage4CheckInDate.getText();
			// System.out.println(p4_cindate);
			String p4_cooutdate = new objectRepository.HotelBook(driver).weTextPage4CheckOutDate.getText();
			// System.out.println(p4_cooutdate);
			String p4_rooms = new objectRepository.HotelBook(driver).weTextPage4Room.getText();
			// System.out.println(p4_rooms);
			String p4_city = new objectRepository.HotelBook(driver).weTextPage4City.getText();
			// System.out.println(p4_city);
			String p4_hotelname = new objectRepository.HotelBook(driver).weTextPage4HotelName.getText();
			// System.out.println(p4_hotelname);
			String p4_guests = new objectRepository.HotelBook(driver).weTextPage4Guest.getText();
			// System.out.println(p4_guests);
			// System.out.println("p4_cindate="+p4_cindate+"p4_cooutdate"+p4_cooutdate+"p4_rooms"+p4_rooms+"p4_city"+p4_city+"p4_hotelname"+p4_hotelname+"p4_guests"+p4_guests);
			System.out.println(
					"----------------------------------------------------Validation 3------------------------------------------");
			// String temp1=p4_cindate.substring(0, 5).toLowerCase();
			// System.out.println(temp1);
			// System.out.println(p2_ddate);
			// if(p2_ddate.equalsIgnoreCase(temp1))
			// System.out.println("Check-in date validated "+p2_ddate);
			//
			//
			// String temp2=p4_cooutdate.substring(0, 5).toLowerCase();
			// System.out.println(temp2);
			// System.out.println(p2_adate);
			// if(p2_adate.equalsIgnoreCase(temp2))
			// System.out.println("Check-out date validated "+p2_adate);

			String temp3 = p4_rooms.substring(0, 1);
			String temp6 = p4_city.substring(0, 6);
			String temp4 = p4_guests.substring(0, 1);
			int temp5 = Integer.parseInt(temp4);
			if (sPage1Rooms.equals(temp3) && sPage3HotelName.equals(p4_hotelname) && sPage1Dcity.equals(temp6)
					&& nPage2Traveller == temp5) {
				System.out.println("Validation 3 completed with Rooms , City and Guests validated ");
			} else {
				System.out.println("Validation 3 including validation of City , Rooms and Guests failed");
			}
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			// again click on details dropper to close it
			new objectRepository.HotelBook(driver).weLinkDetailsDropper.click();
			// Scrolling down to up in horizontal type
			reusableFunctions.Keywords.scrollWindow(65, driver);
			Thread.sleep(5000);
			// entering data into first user text area
//			new objectRepository.HotelBook(driver).weTextFirstName.clear();
			new objectRepository.HotelBook(driver).weInputFirstName.sendKeys("Hello");
			// entering data into second user
//			new objectRepository.HotelBook(driver).weTextLastName.clear();
			new objectRepository.HotelBook(driver).weInputLastName.sendKeys("User");
			String text = new objectRepository.HotelBook(driver).weTextEmail.getText();
			System.out.println(text);
			if (!(text.length()==0)) {
				System.out.println("Already Entered Email ");
			} else {
				// entering the email address
				new objectRepository.HotelBook(driver).weInputEmail.sendKeys("ABC@adb.in");
			}
			// entering the phone number
			// new
			// objectRepository.HotelBook(driver).DETAILS_USER_PHONENUMBER_TEXTAREA.clear();
			new objectRepository.HotelBook(driver).weInputPhoneNumber.sendKeys("8905642375");
			// clicking on continue
			new objectRepository.HotelBook(driver).weBtnContinue.click();
			// clicking on details drop down
			new objectRepository.HotelBook(driver).weLinkDetailsDropper.click();
			// clicking back the details dropdown
			new objectRepository.HotelBook(driver).weLinkDetailsDropper.click();
			// clicking on payment method to be as a debit card
			new objectRepository.HotelBook(driver).weInputCreditCard.click();
			// entering eth card number
			new objectRepository.HotelBook(driver).weInputCreditCardNumber.sendKeys("4704560886077336");
			// entering the name on th card
			new objectRepository.HotelBook(driver).weInputCreditCardName.sendKeys("USERNAME HELLO");
			// entering the expiry month
			new objectRepository.HotelBook(driver).weLinkCreditCardExpMonth.click();
			// selecting the month
			new objectRepository.HotelBook(driver).weDropDownCreditCardExpMonth.click();
			// selecting the expiry year
			new objectRepository.HotelBook(driver).weLinkCreditCardExpYear.click();
			// selecting the year specifically
			new objectRepository.HotelBook(driver).weDropDownCreditCardExpYear.click();
			// selecting the cvv
			new objectRepository.HotelBook(driver).weInputCvvNumber.sendKeys("365");
			try {
				// clicking on continue
				new objectRepository.HotelBook(driver).weBtnContinue.click();
			} catch (Exception e3) {
				System.out.println("Card details are dummy");
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while doing the hotel booking" + e.getMessage());
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
			driver.quit();
			Keywords.appiumStop();
		} catch (Exception e) {
			System.out.println("Exception while closing the script:" + e.getMessage());
			Assert.fail();
		}

	}
}
