package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class HotelBook {


	// ------------ Instantiate Web Elements.
	public HotelBook(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Flight Booking Welcome Page

	@FindBy(how=How.NAME , using="Hotels")
	//Locator For Hotel Search BUtton
	public WebElement weLinkHotels;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator For BACk Arrow on Hotel Search 2nd Page
	public WebElement weImgBack;

	@FindBy(how=How.NAME , using="India")
	//Locator for Searching Hotel
	public WebElement weTextSearchLocation;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='1']/android.widget.EditText[@index='0']")
	//Locator for 
	public WebElement weInputSearchCityText;

	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='1']//android.widget.RelativeLayout[@index='0']")
	//Locator for Searching Hotel
	public WebElement weLinkFirstOccurenceCity;
	
	@FindBy(how=How.NAME , using="CHECK IN")
	//Locator for checkin date selector
	public WebElement weLinkCheckIn;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='4']/android.widget.CheckedTextView[@index='2']")
	//Locator for checkin date
	public WebElement weLinkCheckInDate;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	//Locator for checkin month
	public WebElement weLinkCheckInMonth;

	@FindBy(how=How.NAME , using="OK")
	//Locator for OK
	public WebElement weBtnOk;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='0']")
	//Locator for Nights Selector
	public WebElement weLinkNightSelector;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']")
	//checkout date for hotels
	public WebElement weLinkCheckOut;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	//Locator for checkout date
	public WebElement weLinkCheckOutDate;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	//Locator for checkout month
	public WebElement weLinkCheckOutMonth;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='1']")
	//Locator for text area for the city to be searched
	public WebElement weInputSearchCity;
	
	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@inxed='1']/android.widget.RelativeLayout[@index='0']")
	//Locator for the first occurrence of the city 
	public WebElement weLinkSelectCity;

	@FindBy(how=How.XPATH , using="//android.widget.ListView[@index='1']/android.widget.LinearLayout[@index='3']/android.widget.CheckedTextView[@text='13']")
	//Locator for check-in date selector on calendar
	public WebElement weLinkCheckInDateSelector;

	@FindBy(how=How.NAME , using="OK")
	//Locator for OK
	public WebElement weBtnCheckinOk;

	@FindBy(how=How.XPATH , using="//android.widget.ListView[@index='1']/android.widget.LinearLayout[@index='3']/android.widget.CheckedTextView[@text='15']")
	//Locator for check-out date selector on calendar
	public WebElement weLinkChcekoutDateSelector;

	@FindBy(how=How.NAME , using="OK")
	//Locator for OK
	public WebElement weBtnCheckoutOk;

	@FindBy(how=How.NAME , using="ROOM")
	//Locator for selecting room
	public WebElement weLinkRoom;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	//Locator for getting hotel room text
	public WebElement weTextRooms;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	//Locator for hotel room adults count
	public WebElement weTextAdultCount;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	//Locator for hotel room child count
	public WebElement weTextChildCount;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='0']")
	//Locator for  adults count increment
	public WebElement weImgAdultIncrement;

	@FindBy(how=How.XPATH , using="//android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']")
	//Locator for  adults count decrement
	public WebElement weImgAdultDecrement;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='1']//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='2']")
	//Locator for  child count increment
	public WebElement weImgChildIncrement;

	@FindBy(how=How.XPATH , using="//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.ImageView[@index='=0']")
	//Locator for  child count decrement
	public WebElement weImgChildDecrement;
	
	@FindBy(how=How.XPATH , using="//android.view.View[@index='3']")
	//Locator for child selector for the hotel room
	public WebElement weLinkChildSelector;

	@FindBy(how=How.NAME , using="DONE")
	//Locator for done button on hotel booking
	public WebElement weBtnDone;

	@FindBy(how=How.NAME , using="Search")
	//Locator for search button 
	public WebElement weBtnSearch;

	@FindBy(how=How.NAME, using="SKIP")
	//Locator for skip button on pop up 
	public WebElement weLinkSkip;

	@FindBy(how=How.NAME, using="OK, GOT IT")
	//Locator for ok got it button on pop up
	public WebElement weBtnOkGotIt;
	
	@FindBy(how=How.NAME, using="OK GOT IT")
	//Locator for ok got it button on pop up
	public WebElement weBtnOkGotIt1;

	//Locators for the filters --Price

	@FindBy(how=How.NAME, using="PRICE")
	//Locator for price filter
	public WebElement weLinkFilter;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	//Locator for price amount on filter
	public WebElement weLinkFilterPriceAmount;

	@FindBy(how=How.NAME, using="DONE")
	//Locator for done button
	public WebElement weBtnFilterDone;

	@FindBy(how=How.NAME , using="LOCATION")
	//Locators for the filters --Location
	public WebElement weLinkFilterLocation;

	@FindBy(how=How.NAME , using="M.P Nagar")
	//Locators for the place selector for filter
	public WebElement weLinkFilterLocationSelector;
	
	@FindBy(how=How.NAME , using="Star Rating")
	//Locators for the filters -- Star Rating
	public WebElement weLinkFilterRating;

	@FindBy(how=How.NAME , using="4 STAR")
	//Locators for the filters --Star Rating
	public WebElement weLinkFilterRatingStars;

	@FindBy(how=How.NAME , using="SORT & FILTER")
	//Locators for the sorting
	public WebElement weLinkSorting;

	@FindBy(how=How.XPATH , using="//android.widget.RelativeLayout[@index='5']")
	//Locators for the sorting 
	public WebElement weLinkSortingType;

	//Locators for selecting the hotel

	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']")
	//Locators for the Hotel Selector
	public WebElement weLinkHotelSelection;
	
	@FindBy(how=How.XPATH , using="//android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout[@index='1']//android.widget.TextView[@index='2']")
	//Locators for text if hotel name
	public WebElement weTextHotelName;
	
	@FindBy(how=How.NAME , using="Photos")
	//Locator for Photos
	public WebElement weTabPhotos;
	
	@FindBy(how=How.NAME , using="Reviews")
	//Locator for Reviews
	public WebElement weTabReviews;
	
	@FindBy(how=How.NAME , using="Summary")
	//Locator for Summary
	public WebElement weTabSummary;

	@FindBy(how=How.NAME , using="Select Room")
	//Locator for Select Room button
	public WebElement weBtnSelectRoom;
	
	@FindBy(how=How.NAME , using="CONTINUE")
	//Locator for Continue button
	public WebElement weBtnContinue;
	
	@FindBy(how=How.NAME , using="DETAILS")
	//Locator for details dropddown on review page
	public WebElement weLinkDetailsDropper;
	
	@FindBy(how=How.NAME, using="First name")
	//Locators for entering first name
	public WebElement weInputFirstName;
	 
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']//android.widget.FrameLayout[@index='0']/android.widget.EditText[@index='0']")
	//Locators for entering user details
	public WebElement weTextFirstName;

	@FindBy(how=How.NAME, using="Last name")
	//Locators for entering last name
	public WebElement weInputLastName;
	
	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']//android.widget.LinearLayout[@index='2']//android.widget.EditText[@index='0']")
	//Locators for last name text area
	public WebElement weTextLastName;

	@FindBy(how=How.NAME, using="Email")
	//Locators for entering email address
	public WebElement weInputEmail;

	@FindBy(how=How.XPATH, using="//android.widget.RelativeLayout[@index='8']/android.widget.LinearLayout[@index='1']//android.widget.EditText[@index='0']")
	//Locators for entering email address textarea
	public WebElement weTextEmail;

	@FindBy(how=How.NAME, using="Phone number")
	//Locator for phone number
	public WebElement weInputPhoneNumber;

	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.EditText[@index='0']")
	//Locator for phone number textarea
	public WebElement weTextPhoneNumber;
	
	@FindBy(how=How.NAME, using="Debit Card")
	//Locator for the debit card
	public WebElement weInputCreditCard;

	//Locators for card details 

	@FindBy(how=How.NAME, using="Card Number")
	//Locator for card number
	public WebElement weInputCreditCardNumber;
	
	@FindBy(how=How.NAME, using="Name on Card")
	//Locator for debit card name
	public WebElement weInputCreditCardName;

	@FindBy(how=How.NAME, using="Expiry Month")
	//Locator for Expiry Month
	public WebElement weLinkCreditCardExpMonth;

	@FindBy(how=How.NAME, using="April (04)")
	//Locator for Expiry Month selector
	public WebElement weDropDownCreditCardExpMonth;
	
	@FindBy(how=How.NAME, using="Expiry Year")
	//Locator for  Expiry Year
	public WebElement weLinkCreditCardExpYear;
	
	@FindBy(how=How.NAME, using="2019")
	//Locator for Year Selector
	public WebElement weDropDownCreditCardExpYear;
	
	@FindBy(how=How.NAME, using="Enter CVV")
	//Locator for CVV
	public WebElement weInputCvvNumber;

	@FindBy(how=How.NAME, using="Select Country")
	//Locator for Country
	public WebElement weLinkCardCountry;
	
	@FindBy(how=How.NAME, using="India")
	//Locator for Country
	public WebElement weDropDownCardCountry;
	
	@FindBy(how=How.NAME, using="State")
	//Locator for State
	public WebElement weDropDownCardState;
	
	@FindBy(how=How.NAME, using="City")
	//Locator for City
	public WebElement weDropDownCardCity;
	
	@FindBy(how=How.NAME, using="Billing Address")
	//Locator for Billing Address
	public WebElement weInputBillingAddress;
	
	@FindBy(how=How.NAME, using="Zip Code")
	//Locator for Zip Code
	public WebElement weInputBillingZipCode;

	//Locators for validations
	
	//Page 1
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.RelativeLayout[@index='1']//android.widget.TextView[@index='0']")
	public WebElement weTextPage1City;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage1DDate;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='2']")
	public WebElement weTextPage1DMonth;

	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement weTextPage1ADate;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='2']//android.widget.LinearLayout[@index='2']/android.widget.RelativeLayout[@index='2']/android.widget.TextView[@index='2']")
	public WebElement weTextPage1AMonth;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage1RoomCount;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage1AdultCount;
	
	@FindBy(how=How.XPATH, using="//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='1']/android.widget.TextView[@index='1']")
	public WebElement weTextPage1ChildCount;
	
	//Page2
	@FindBy(how=How.XPATH, using="//android.view.View[@index='0']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='1']")
	public WebElement weTextPage2City;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='0']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='3']")
	public WebElement weTextPage2DDate;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='0']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='5']")
	public WebElement weTextPage2ADate;
	
	@FindBy(how=How.XPATH, using="//android.view.View[@index='0']//android.widget.RelativeLayout[@index='0']//android.widget.TextView[@index='9']")
	public WebElement weTextPage2ATraveller;
	
	@FindBy(how=How.XPATH, using="//android.widget.FrameLayout[@index='1']//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage3HotelName;
	
	@FindBy(how=How.XPATH, using="//android.support.v4.view.ViewPager[@index='3']//android.widget.RelativeLayout[@index='1']/android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage3Address;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='0']")
	public WebElement weTextPage4HotelName;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='2']")
	public WebElement weTextPage4City;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage4Room;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.RelativeLayout[@index='0']/android.widget.TextView[@index='4']")
	public WebElement weTextPage4Guest;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='0']/android.widget.TextView[@index='1']")
	public WebElement weTextPage4CheckInDate;
	
	@FindBy(how=How.XPATH, using="//android.widget.ScrollView[@index='3']//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='2']/android.widget.TextView[@index='1']")
	public WebElement weTextPage4CheckOutDate;
}
