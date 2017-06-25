package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class HotelRepository {


	// ------------ Instantiate Web Elements.
	public HotelRepository(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Flight Booking Welcome Page

	@FindBy(how=How.NAME , using="Hotels")
	//Locator For Hotel Search BUtton
	public WebElement HOTEL_SEARCH;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator For BACk Arrow on Hotel Search 2nd Page
	public WebElement HOTEL_SEARCH_BACK_OFFERS;

	////android.widget.ScrollView[@index='2']//android.widget.RelativeLayout[@index='1']/android.widget.TextView[@text='India']
	@FindBy(how=How.NAME , using="India")
	//Locator for Searching Hotel
	public WebElement HOTEL_SEARCH_CITY;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='1']/android.widget.EditText[@index='0']")
	//Locator for 
	public WebElement HOTEL_SEARCH_CITY_TEXT;


	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='1']//android.widget.RelativeLayout[@index='0']")
	//Locator for Searching Hotel
	public WebElement HOTEL_SEARCH_SELECT_FIRST_OCCURENCE;


	//Hotel cheking date
	@FindBy(how=How.NAME , using="CHECK IN")
	public WebElement HOTEL_CHECKIN;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='4']/android.widget.CheckedTextView[@index='2']")
	public WebElement HOTEL_CHECKIN_DATE;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	public WebElement HOTEL_CHECKIN_MONTH;

	@FindBy(how=How.NAME , using="OK")
	public WebElement OK;

	//hotel number of night selector
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	public WebElement HOTEL_NIGHTSTAY_DURATION;
	//checkout date for hotels
	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']")
	public WebElement HOTEL_CHECKOUT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement HOTEL_CHECKOUT_DATE;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	public WebElement HOTEL_CHECKOUT_MONTH;

	//Text Area for the city to be searched
	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='1']")
	public WebElement HOTEL_SEARCHCITY_TEXTAREA;

	//Select the first occurence of the text typed for city for place
	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@inxed='1']/android.widget.RelativeLayout[@index='0']")
	public WebElement HOTEL_SELECT_CITY;

	@FindBy(how=How.XPATH , using="//android.widget.ListView[@index='1']/android.widget.LinearLayout[@index='3']/android.widget.CheckedTextView[@text='13']")
	public WebElement HOTEL_CHECKIN_DATESELECTOR;

	@FindBy(how=How.NAME , using="OK")
	public WebElement HOTEL_CHECKIN_DATESELECTOR_OK;

	@FindBy(how=How.XPATH , using="//android.widget.ListView[@index='1']/android.widget.LinearLayout[@index='3']/android.widget.CheckedTextView[@text='15']")
	public WebElement HOTEL_CHECKOUT_DATESELECTOR;

	@FindBy(how=How.NAME , using="OK")
	public WebElement HOTEL_CHECKOUT_DATESELECTOR_OK;

	@FindBy(how=How.NAME , using="ROOM")
	public WebElement HOTEL_ROOMS;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement HOTEL_ROOMS_TEXT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement HOTEL_ROOM_ADULTS_COUNT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement HOTEL_ROOM_CHILD_COUNT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']")
	public WebElement HOTEL_ADULTS_DECREMENT;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']")
	public WebElement HOTEL_ADULTS_INCREMENT;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']")
	public WebElement HOTEL_ROOM_CHILD_INCREMENT;

	@FindBy(how=How.XPATH , using="//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='=0']")
	public WebElement HOTEL_ROOM_CHILD_DECREMENT;

	@FindBy(how=How.XPATH , using="//android.view.View[@index='3']")
	public WebElement HOTEL_ROOM_CHILD_SELECTOR;

	@FindBy(how=How.NAME , using="DONE")
	public WebElement HOTEL_ROOM_DONE;

	@FindBy(how=How.NAME , using="Search")
	public WebElement HOTEL_SEARCH_BUTTON;

	@FindBy(how=How.NAME, using="SKIP")
	public WebElement SKIPPING_POPUP;

	@FindBy(how=How.NAME, using="OK, GOT IT")
	public WebElement OK_GOT_IT_BUTTON_POPUP;

	//Locators for the filters --Price

	@FindBy(how=How.NAME, using="PRICE")
	public WebElement FILTER_PRICE;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement FILTER_PRICE_AMOUNT;

	@FindBy(how=How.NAME, using="DONE")
	public WebElement FILTER_DONE;

	//Locators for the filters --Location
	@FindBy(how=How.NAME , using="LOCATION")
	public WebElement FILTER_LOCATION;

	@FindBy(how=How.NAME , using="M.P Nagar")
	public WebElement FILTER_LOCATION_SELECTION;

	//Locators for the filters --Rating
	@FindBy(how=How.NAME , using="Star Rating")
	public WebElement FILTER_RATING;

	@FindBy(how=How.NAME , using="4 STAR")
	public WebElement FILTER_RATING_STARS;

	//Locators for sorting 
	@FindBy(how=How.NAME , using="SORT & FILTER")
	public WebElement SORTING;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='5']")
	public WebElement SORTING_SORT;

	//Locators for selecting the hotel

	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']")
	public WebElement HOTEL_SELECTION;
	
	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']//android.widget.TextView[@index='2']")
	public WebElement HOTEL_SELECTION_NAME;

	//Locator for Photos
	@FindBy(how=How.NAME , using="Photos")
	public WebElement PHOTOS_TAB;

	//Locator for Reviews
	@FindBy(how=How.NAME , using="Reviews")
	public WebElement REVIEWS_TAB;

	//Locator for Summary
	@FindBy(how=How.NAME , using="Summary")
	public WebElement SUMMARY_TAB;

	//Locator for Select Room button
	@FindBy(how=How.NAME , using="Select Room")
	public WebElement SELECT_ROOM_BUTTON;

	//Locator for Continue button
	@FindBy(how=How.NAME , using="CONTINUE")
	public WebElement CONTINUE_BUTTON;

	//Locator for details dropddown on review page
	@FindBy(how=How.NAME , using="DETAILS")
	public WebElement DETAILS_DROPPER;

	//Locators for entering user details 
	@FindBy(how=How.NAME, using="First name")
	public WebElement DETAILS_USER_FIRSTNAME;

	//Locators for entering user details 
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']//android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	public WebElement DETAILS_USER_FIRSTNAME_TEXTAREA;


	//Locators for entering user details 
	@FindBy(how=How.NAME, using="Last name")
	public WebElement DETAILS_USER_LASTNAME;

	//Locators for entering user details 
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']//android.widget.LinearLayout[@index='2']//android.widget.EditText[@index='0']")
	public WebElement DETAILS_USER_LASTNAME_TEXTAREA;


	//Locators for entering email address
	@FindBy(how=How.NAME, using="Email")
	public WebElement DETAILS_USER_EMAIL;

	//Locators for entering email address textarea
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']/android.widget.LinearLayout[@index='1']//android.widget.EditText[@index='0']")
	public WebElement DETAILS_USER_EMAIL_TEXTAREA;

	//Locator for phone number
	@FindBy(how=How.NAME, using="Phone number")
	public WebElement DETAILS_USER_PHONENUMBER;

	//Locator for phone number textarea
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.EditText[@index='0']")
	public WebElement DETAILS_USER_PHONENUMBER_TEXTAREA;

	//Locator for the debit card
	@FindBy(how=How.NAME, using="Debit Card")
	public WebElement CARD_DEBITCARD;

	//Locators for card details 

	//Locator for card number
	@FindBy(how=How.NAME, using="Card Number")
	public WebElement CARD_DEBITCARD_NUMBER;

	//Locator for debit card name
	@FindBy(how=How.NAME, using="Name on Card")
	public WebElement CARD_DEBITCARD_NAME;



	//Locator for Expiry Month
	@FindBy(how=How.NAME, using="Expiry Month")
	public WebElement CARD_EXPIRY_MONTH;

	//Locator for Expiry Month selector
	@FindBy(how=How.NAME, using="April (04)")
	public WebElement CARD_EXPIRY_MONTH_SELECTOR;


	//Locator for  Expiry Year
	@FindBy(how=How.NAME, using="Expiry Year")
	public WebElement CARD_EXPIRY_YEAR;

	//Locator for Year Selector
	@FindBy(how=How.NAME, using="2019")
	public WebElement CARD_EXPIRY_YEAR_SELECTOR;

	//Locator for CVV
	@FindBy(how=How.NAME, using="Enter CVV")
	public WebElement CARD_CVV_NUMBER;


	//Locator for Country
	@FindBy(how=How.NAME, using="Select Country")
	public WebElement CARD_COUNTRY;

	//Locator for Country
	@FindBy(how=How.NAME, using="India")
	public WebElement CARD_COUNTRY_SELECT;

	//Locator for State
	@FindBy(how=How.NAME, using="State")
	public WebElement CARD_STATE;

	//Locator for City
	@FindBy(how=How.NAME, using="City")
	public WebElement CARD_CITY;

	//Locator for Billing Address
	@FindBy(how=How.NAME, using="Billing Address")
	public WebElement CARD_BILLINGADDRESS;

	//Locator for Zip Code
	@FindBy(how=How.NAME, using="Zip Code")
	public WebElement CARD_ZIPCODE;

	//Locators for validations
	
	//Page 1
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.RelativeLayout[@index='1']//android.widget.TextView[@index='0']")
	public WebElement PAGE1_CITY;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE1_D_DATE;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='2']")
	public WebElement PAGE1_D_MONTH;

	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement PAGE1_A_DATE;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	public WebElement PAGE1_A_MONTH;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE1_ROOM_COUNT;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE1_ADULTS_COUNT;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	public WebElement PAGE1_CHILDS_COUNT;
	
	//Page2
	@FindBy(how=How.XPATH, using="//android.view.View[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='1']")
	public WebElement PAGE2_CITY;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='3']")
	public WebElement PAGE2_D_DATE;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='5']")
	public WebElement PAGE2_A_DATE;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='1']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='9']")
	public WebElement PAGE2_N_TRAVELLER;
	
	@FindBy(how=How.XPATH, using="//android.widget.FrameLayout[@index='1']//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE3_HOTELNAME;
	

	@FindBy(how=How.XPATH, using="//android.support.v4.view.ViewPager[@index='3']//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE3_ADDRESS;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='0']")
	public WebElement PAGE4_HOTELNAME;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	public WebElement PAGE4_CITY;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE4_ROOM;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='4']")
	public WebElement PAGE4_GUESTS;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement PAGE4_CHECKINDATE;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement PAGE4_CHECKOUTDATE;
}
