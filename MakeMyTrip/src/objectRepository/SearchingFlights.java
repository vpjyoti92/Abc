package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class SearchingFlights {

	// ------------ Instantiate Web Elements.
	public SearchingFlights(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "CONTINUE")
	//Locator for Continue Button
	public  WebElement LAUNCH_CONTINUE;

	@FindBy(how = How.NAME, using = "SKIP")
	//Locator for Skipping Offer 
	public  WebElement SKIPPING_OFFER;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator for Back Arrow
	public  WebElement BACK_ARROW;

	@FindBy(how = How.NAME, using = "OK")
	//Locator for Continue button on Pop Up
	public  WebElement BUTTON_OK;

	@FindBy(how = How.NAME, using = "Flights")
	//Locator for selecting Flight
	public  WebElement FLIGHT;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']")
	//Locator for selecting Element1
	public  WebElement ELEMENT1;

	@FindBy(how = How.NAME, using = "Enter Departure City")
	//Locator for Departure City
	public  WebElement DEPARTURECITY;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='1']")
	//Locator for entering the City to be searched
	public  WebElement SELECTSEARCH;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='5']")
	//Locator for Arrival city
	public  WebElement ARRIVINGCITY;

	@FindBy(how = How.NAME, using = "Bangalore")
	//Locator for Continue Button
	public  WebElement SELECTBANGLORE;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']")
	//Locator for Departure Date
	public  WebElement DEPARTURE_DATE_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index=5]/android.widget.CheckedTextView[@index='2']")
	//Locator for Date Selection
	public  WebElement SELECTING_DATE;

	@FindBy(how = How.NAME, using = "OK")
	//Locator for OK on Date Selector
	public  WebElement OK_BUTTON;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']")
	//Locator for Arrival Date
	public  WebElement RETURNDATE_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index=5]/android.widget.CheckedTextView[@index='3']")
	//Locator for Date Selection for return
	public  WebElement RETURN_DATE;

	@FindBy(how = How.NAME, using = "OK")
	//Locator for OK on Date Selector
	public  WebElement OK_BUTTON2;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	//Locator for Adult text
	public WebElement ADULT_COUNT;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='0']")
	//Locator for Adult selector window
	public  WebElement ADULT_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='2']")
	//Locator for Increment 
	public  WebElement INCREMENT_BUTTON;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='0']")
	//Locator for Decrement
	public WebElement DECREMENT_BUTTON;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='6']")
	//Locator for OK on Adult Selector Box
	public  WebElement OK_BUTTON3;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='ECONOMY']")
	//Locator for Economy Selector
	public  WebElement ECONOMY_SELECTOR;

	@FindBy(how = How.NAME, using = "premium economy")
	//Locator for selecting Economy Type
	public  WebElement ECONOMY;

	@FindBy(how = How.NAME, using = "search")
	//Locator for Search Button
	public  WebElement SEARCH_BUTTON;

	
	@FindBy(how=How.NAME, using="No Flights Found!")
	//Locator for No Flights Found text
	public WebElement NOFLIGHTFOUND_OBJECT;

	@FindBy(how = How.NAME, using = "FILTER")
	//Locator Filter Selector
	public  WebElement FILTER_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']")
	//Locator for Stop Selector on Filter Box
	public  WebElement STOP_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']")
	//Locator for Stop Amount Selector
	public  WebElement STOP;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	//Locator for Stop Number text
	public  WebElement STOP_NUMBER;


	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='1']")
	//Locator for Time Selector
	public  WebElement TIME_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']")
	//Locator for Time Amount Selector
	public  WebElement TIME;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='2']")
	//Locator for Airline Type Selector
	public  WebElement AIRLINE_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[@index='4']")
	//Locator for Airline Type Checkbox
	public  WebElement AIRLINE;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='3']")
	//Locator for More Tab on Filter Box
	public  WebElement MORE;

	@FindBy(how=How.XPATH , using="//android.widget.ImageView[@index='2']")
	//Locator for More Feature Selector
	public  WebElement MORE_SELECTION;

	@FindBy(how = How.NAME, using = "Apply")
	//Locator for Apply Button
	public  WebElement APPLY_BUTTON;

	@FindBy(how = How.XPATH, using = "//com.mmt.travel.app.flight.customviews.CustomSlidingPanelLayout[@index='0']/android.widget.LinearLayout[@index='1']")
	//Locator for Return Flight selector Window
	public  WebElement RETURNFLIGHT_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.support.v7.widget.RecyclerView[@index='1']/android.widget.RelativeLayout[@index='0']")
	//Locator for specific Return Flight
	public  WebElement RETURNFLIGHT;

	@FindBy(how = How.XPATH, using = "//android.widget.FrameLayout[@index='0']")
	//Locator for Boarding Flight Selector
	public  WebElement BOARDINGFLIGHT_SELECTOR;

	@FindBy(how = How.XPATH, using = "//android.widget.RelativeLayout[@index='0']")
	//Locator for specific Boarding Flight
	public  WebElement BOARDINGFLIGHT;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='3']/android.widget.TextView[@index='0']")
	//Locator for Booking button
	public  WebElement BOOKING;

	@FindBy(how=How.NAME, using="CONTINUE")
	//Locator for Continue to booking button
	public  WebElement CONTINUE_FOR_BOOKING;

	@FindBy(how=How.XPATH , using="//android.widget.ImageView[@index='4']")
	//Locator for Details DropDown
	public  WebElement DETAILS_DROPDOWN;

	@FindBy(how=How.NAME , using="ADD NEW ADULT")
	//Locator for Add New Adult 
	public  WebElement ADD_NEW_ADULT;

	@FindBy(how=How.NAME , using="First Name (& middle name if any)")
	//Locator for First Name text area
	public  WebElement ENTER_FIRSTNAME_ADULT;

	@FindBy(how=How.NAME , using="Last Name")
	//Locator for Last Name text area
	public  WebElement ENTER_LASTNAME_ADULT;

	@FindBy(how=How.NAME , using="Female")
	//Locator for Gender Selection box
	public  WebElement SELECT_FEMALEGENDER_ADULT;

	@FindBy(how=How.XPATH, using="//android.widget.Button[@index='2']")
	//Locator for Done Button
	public WebElement DONE;

	@FindBy(how=How.NAME, using="See all Adults")
	//Locator for See All Adults Link
	public WebElement SEE_ALL_ADULTS;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']")
	//Locator for selecting the specific adult from check box
	public  WebElement SELECTING_ADULT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']//android.widget.EditText[@index='0']")
	//Locator for Contact email address text area
	public  WebElement ENTER_CONTACT_EMAILADDRESS;

	@FindBy(how=How.NAME , using="Phone Number")
	//Locator for Phone Number text area
	public  WebElement ENTER_CONTACT_PHONENUMBER;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator for Terms and Conditions check box
	public  WebElement SELECT_CONTACT_TERMSCONDITIONS;

	@FindBy(how=How.NAME , using="BOOK FLIGHT")
	//Locator for Book Flight button
	public  WebElement BOOK_FLIGHT;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	//Locator for Departure City text 
	public WebElement PAGE1_D_CITY;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='5']/android.widget.TextView[@index='0']")
	//Locator for Arrival City text 
	public WebElement PAGE1_A_CITY;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	//Locator for  Departure Date text 
	public WebElement PAGE1_D_DATE;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='2']")
	//Locator for  Departure Month text 
	public WebElement PAGE1_D_MONTH;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	//Locator for Arrival Date text 
	public WebElement PAGE1_A_DATE;

	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	//Locator for Arrival Month text 
	public WebElement PAGE1_A_MONTH;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	//Locator for Adult count text
	public WebElement PAGE1_ADULT_COUNT;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	//Locator for Economy type text
	public WebElement PAGE1_ECONOMY_TYPE;


	//Locators for Page 2 

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='0']")
	//Locator for Departure City text
	public  WebElement PAGE2_D_CITY;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='2']")
	//Locator for Arrival City text
	public  WebElement PAGE2_A_CITY;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='1']")
	//Locator for Travel Dates text
	public  WebElement PAGE2_DATES;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.TextView[@index='3']")
	//Locator for Number of Adults text
	public  WebElement PAGE2_ADULTS;

	//Locators for Page 3

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='1']")
	//Locator for Boarding Amount text
	public  WebElement PAGE3_BOARDING_AMOUNT;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='1']//android.widget.TextView[@index='1']")
	//Locator for Arrival Amount text
	public  WebElement PAGE3_ARRIVING_AMOUNT;

	@FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='0']//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='0']")
	//Locator for Total Amount text
	public  WebElement PAGE3_TOTAL_AMOUNT;

	@FindBy(how = How.NAME, using = "Vistara")
	//Locator for Flight Type text
	public  WebElement PAGE3_FLIGHT_TYPE;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[@text='1Stop']")
	//Locator for number of Stops
	public  WebElement PAGE3_STOP;

	//xpath

	@FindBy(how=How.NAME, using="1 Stop")
	//Locator for Continue Button
	public WebElement PAGE4_STOP;

	@FindBy(how=How.NAME, using="Vistara")
	//Locator for Continue Button
	public WebElement PAGE4_FLIGHTTYPE;

	
	@FindBy(how=How.XPATH, using="//android.widget.Button[@index='4']")
	//Locator for Select Another Flight on Error pop up
	public WebElement SELECT_ANOTHER_FLIGHT_POPUP;

	//Back First on Searching Flights
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='1']")
	//Locator for Back Arrow on first page 
	public WebElement SELECT_FIRST_BACK_BUTTON;

	//Back button on Second Flights
	@FindBy(how=How.XPATH, using="//android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator for Back Arrow on Second Back page
	public WebElement SELECT_SECOND_BACK_BUTTON;

	//Back button on Search Flights page
	@FindBy(how=How.XPATH ,using="//android.widget.LinearLayout[@index='1']/android.widget.ImageView[@index='0']")
	//Locator for Back Arrow on Third Back page
	public WebElement SELECT_THIRD_BACK_BUTTON;

	//OK button
	@FindBy(how=How.XPATH ,using="//android.widget.RelativeLayout[@index='0']/android.widget.LinearLayout[@index='0']")
	//Locator for OK Pop Up while going back
	public WebElement SELECT_OK_POPUP;




}
