package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class FlightBook {

	// ------------ Instantiate Web Elements.
	public FlightBook(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID , using= "com.makemytrip:id/layout_onboarding_right_img_vw")
	//Locator for Back Image
	public WebElement weImgBackInsPage;
	
	@FindBy(how=How.NAME , using= "Refer Now")
	//Locator for Back Image
	public WebElement weLinkReferNow;
	
    @FindBy(how=How.XPATH, using="//android.view.View[@index='0']/android.widget.ImageButton[@index='0']")
    //locator for back on First Installation pages
    public WebElement weImgBackArrowInsPage;

	@FindBy(how = How.NAME, using = "CONTINUE")
	// Locator for Continue Button
	public WebElement weBtnContinue;

	@FindBy(how = How.NAME, using = "SKIP")
	// Locator for Skipping Offer
	public WebElement weLinkSkip;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']")
	// Locator for Back Arrow
	public WebElement weImgBackArrow;

	@FindBy(how = How.NAME, using = "OK")
	// Locator for Continue button on Pop Up
	public WebElement weBtnOk;

	@FindBy(how = How.NAME, using = "Flights")
	// Locator for selecting Flight
	public WebElement weLinkFlight;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']")
	// Locator for selecting Element1
	public WebElement weElement1;

	
	@FindBy(how=How.NAME, using="No matching results found")
	//Locator for the no flights found case
	public WebElement weTextFlights;
	
	@FindBy(how = How.NAME, using = "Enter Departure City")
	// Locator for Departure City
	public WebElement weLinkDepartureCity;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']")
	// Locator for entering the City to be searched
	public WebElement weSearchArea;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='5']")
	// Locator for Arrival city
	public WebElement weLinkArrivalCity;

	@FindBy(how = How.NAME, using = "Bangalore")
	// Locator for Continue Button
	public WebElement weTabBanglore;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']")
	// Locator for Departure Date
	public WebElement weLinkDepartureDateSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index=5]/android.widget.CheckedTextView[@index='2']")
	// Locator for Date Selection
	public WebElement weCalSelectingDate;

	@FindBy(how = How.NAME, using = "OK")
	// Locator for OK on Date Selector
	public WebElement weBtnOk1;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']")
	// Locator for Arrival Date
	public WebElement weLinkReturnDateSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index=5]/android.widget.CheckedTextView[@index='3']")
	// Locator for Date Selection for return
	public WebElement weCalReturnDate;

	@FindBy(how = How.NAME, using = "OK")
	// Locator for OK on Date Selector
	public WebElement weBtnOK2;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	// Locator for Adult text
	public WebElement weTxtAdultCount;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='0']")
	// Locator for Adult selector window
	public WebElement weWindowAdultSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='2']")
	// Locator for Increment
	public WebElement weLinkIncrement;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']")
	// Locator for Decrement
	public WebElement weLinkDecrement;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='6']")
	// Locator for OK on Adult Selector Box
	public WebElement weBtnOk3;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='ECONOMY']")
	// Locator for Economy Selector
	public WebElement weSelectEconomy;

	@FindBy(how = How.NAME, using = "premium economy")
	// Locator for selecting Economy Type
	public WebElement weSelectEconomyType;

	@FindBy(how = How.NAME, using = "search")
	// Locator for Search Button
	public WebElement weBtnSearch;

	@FindBy(how = How.NAME, using = "No Flights Found!")
	// Locator for No Flights Found text
	public WebElement weTextNoFlightsFound;

	@FindBy(how = How.NAME, using = "FILTER")
	// Locator Filter Selector
	public WebElement weLinkFilterSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']")
	// Locator for Stop Selector on Filter Box
	public WebElement weLinkStopSElector;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']")
	// Locator for Stop Amount Selector
	public WebElement weLinkStop;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	// Locator for Stop Number text
	public WebElement weTextStopNumber;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='1']")
	// Locator for Time Selector
	public WebElement weLinkTimeSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']")
	// Locator for Time Amount Selector
	public WebElement weLinkTime;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='2']")
	// Locator for Airline Type Selector
	public WebElement weLinkAirlineSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[@index='4']")
	// Locator for Airline Type Checkbox
	public WebElement weLinkAirline;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='3']")
	// Locator for More Tab on Filter Box
	public WebElement weLinkMore;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[@index='2']")
	// Locator for More Feature Selector
	public WebElement weLinkMoreSelector;

	@FindBy(how = How.NAME, using = "Apply")
	// Locator for Apply Button
	public WebElement weBtnApply;

	@FindBy(how = How.XPATH, using = "//com.mmt.travel.app.flight.customviews.CustomSlidingPanelLayout[@index='0']/android.widget.LinearLayout[@index='1']")
	// Locator for Return Flight selector Window
	public WebElement weLinkReturnFlightSelector;

	@FindBy(how = How.XPATH, using = "//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']")
	// Locator for specific Return Flight
	public WebElement weLinkReturnFlight;

	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@index='0']")
	// Locator for Boarding Flight Selector
	public WebElement weLinkBoardingFlightSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']")
	// Locator for specific Boarding Flight
	public WebElement weLinkBoardingFlight;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']")
	// Locator for Booking button
	public WebElement weBtnBooking;

	@FindBy(how = How.NAME, using = "CONTINUE")
	// Locator for Continue to booking button
	public WebElement weBtnContinueForBooking;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[@index='4']")
	// Locator for Details DropDown
	public WebElement weLinkDetailsDropdown;

	@FindBy(how = How.NAME, using = "ADD NEW ADULT")
	// Locator for Add New Adult
	public WebElement weLinkAddNewAdults;

	@FindBy(how = How.NAME, using = "First Name (& middle name if any)")
	// Locator for First Name text area
	public WebElement weInputboxFirstName;

	@FindBy(how = How.NAME, using = "Last Name")
	// Locator for Last Name text area
	public WebElement weInputboxLastName;

	@FindBy(how = How.NAME, using = "Female")
	// Locator for Gender Selection box
	public WebElement weBtnFemaleSelector;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@index='2']")
	// Locator for Done Button
	public WebElement weBtnDone;

	@FindBy(how = How.NAME, using = "Adult")
	// Locator for Done Button
	public WebElement weTextHeading;
	
	@FindBy(how = How.NAME, using = "See all Adults")
	// Locator for See All Adults Link
	public WebElement weLinkSeeAllAdults;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']")
	// Locator for selecting the specific adult from check box
	public WebElement weCheckboxSelectAdults;
	
	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']")
	// Locator for selecting the specific adult from check box
	public WebElement weCheckboxSelectAdults2;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']//android.widget.EditText[@index='0']")
	// Locator for Contact email address text area
	public WebElement weInputBoxEmailAddress;

	@FindBy(how = How.NAME, using = "Phone Number")
	// Locator for Phone Number text area
	public WebElement weInputboxPhoneNumber;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	// Locator for Terms and Conditions check box
	public WebElement weLinkTermsConditions;

	@FindBy(how = How.NAME, using = "BOOK FLIGHT")
	// Locator for Book Flight button
	public WebElement weBtnBookFlight;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	// Locator for Departure City text
	public WebElement weTextPage1DepartCity;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='0']")
	// Locator for Arrival City text
	public WebElement weTextPage1ArrivalCity;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	// Locator for Departure Date text
	public WebElement weTextPage1DepartDate;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='2']")
	// Locator for Departure Month text
	public WebElement weTextPage1DeaprtMonth;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	// Locator for Arrival Date text
	public WebElement weTextPage1ArrivalDate;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	// Locator for Arrival Month text
	public WebElement weTextPage1ArrivalMonth;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	// Locator for Adult count text
	public WebElement weTextPage1AdultsCount;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	// Locator for Economy type text
	public WebElement weTextPage1EconomyType;

	// Locators for Page 2

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='0']")
	// Locator for Departure City text
	public WebElement weTextPage2DepartCity;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='2']")
	// Locator for Arrival City text
	public WebElement weTextPage2ArrivalCity;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")
	// Locator for Travel Dates text
	public WebElement weTextPage2Date;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='3']")
	// Locator for Number of Adults text
	public WebElement weTextPage2Adults;

	// Locators for Page 3

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='1']")
	// Locator for Boarding Amount text
	public WebElement weTextPage3BoardingAmount;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='1']")
	// Locator for Arrival Amount text
	public WebElement weTextPage3ArrivingAmount;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='0']//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='0']")
	// Locator for Total Amount text
	public WebElement weTextPage3TotalAmount;

	@FindBy(how = How.NAME, using = "Vistara")
	// Locator for Flight Type text
	public WebElement weTextFlightType;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='1Stop']")
	// Locator for number of Stops
	public WebElement weTextPage3Stop;

	// xpath

	@FindBy(how = How.NAME, using = "1 Stop")
	// Locator for Continue Button
	public WebElement weTextPage4Stop;

	@FindBy(how = How.NAME, using = "Vistara")
	// Locator for Continue Button
	public WebElement weTextPage4FlightType;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@index='4']")
	// Locator for Select Another Flight on Error pop up
	public WebElement weBtnSelectAnotherFlight;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']")
	// Locator for Back Arrow on first page
	public WebElement weImgBack1;

	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	// Locator for Back Arrow on Second Back page
	public WebElement weImgBack2;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.ImageView[@index='0']")
	// Locator for Back Arrow on Third Back page
	public WebElement weImgBack3;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']")
	// Locator for OK Pop Up while going back
	public WebElement weBtnOk2;
	
	@FindBy(how=How.ID, using="com.makemytrip:id/nav_icon")
	//Locator for back arrow image
	public WebElement weImgLastBackArrow;

}
