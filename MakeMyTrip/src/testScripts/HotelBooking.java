package testScripts;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.SearchingFlights;
import objectRepository.HotelRepository;
import reusableFunctions.ReusableFunctions;

public class HotelBooking {


	private  AndroidDriver driver;
	private  ATUTestRecorder recorder;
	
	//Varaibles
	
	String p1_dcity="Bhopal";
	String p1_adate, p1_ddate, p1_adults, p1_child, p1_rooms;
	String p2_adate,p2_ddate,p2_rooms,p2_city;
	int p2_travellers;
	String p3_hotelName,p4_hotelName,p4_hotelAddress,p3_addressFilter;
	
	@BeforeClass
	public void launch()
	{
		System.out.println("Hello");
	    ReusableFunctions.startRecorder(recorder);
		try {
			// ReusableFunctions.startAppiumServer(process,APPIUMSERVERSTART);
			Thread.sleep(2000);
			//recorder.start();
			InitializeDriver.setUp();
		} catch (Exception e) {
			System.out.println("Exception occurred while recording script"+e.getMessage());
		}
		driver=InitializeDriver.driver;
				InitializeDriver.setUp();
	}
	
	@Test()
	public void hotelBooking()
	{

		new SearchingFlights(driver).BACK_ARROW.click();
		new SearchingFlights(driver).BUTTON_OK.click();
		new objectRepository.HotelRepository(driver).HOTEL_SEARCH.click();
		
		new objectRepository.HotelRepository(driver).HOTEL_SEARCH_CITY.click();
		//Entering text in text area
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		new objectRepository.HotelRepository(driver).HOTEL_SEARCH_CITY_TEXT.sendKeys(p1_dcity);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		//Selecting the first option
		new objectRepository.HotelRepository(driver).HOTEL_SEARCH_SELECT_FIRST_OCCURENCE.click();
		
		//Selecting the Check-In tab
		new objectRepository.HotelRepository(driver).HOTEL_CHECKIN.click();
		//Selecting the relevant date
		String dtemp1=new objectRepository.HotelRepository(driver).HOTEL_CHECKIN_DATE.getText();
		//String dtemp2=new objectRepository.HotelRepository(driver).HOTEL_CHECKIN_MONTH.getText();
		new objectRepository.HotelRepository(driver).HOTEL_CHECKIN_DATE.click();
		//clicking on ok
		new objectRepository.HotelRepository(driver).OK.click();
		//selecting the rooms tab
		new objectRepository.HotelRepository(driver).HOTEL_ROOMS.click();
		//validating and entering the adults
		String x=new objectRepository.HotelRepository(driver).HOTEL_ROOM_ADULTS_COUNT.getText();
		int x1=Integer.parseInt(x);
		//System.out.println(x1);
		
		String y=new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_COUNT.getText();
		int y2=Integer.parseInt(y);
		//System.out.println(y2);
		
		if(x1>=2)
		{
			//decrementing the adults
			new objectRepository.HotelRepository(driver).HOTEL_ADULTS_DECREMENT.click();
			if(y2>1)
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_DECREMENT.click();
			}
			else if(y2<=0)
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_INCREMENT.click();
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_SELECTOR.click();
			}
			else
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_SELECTOR.click();
			}
		}
		else
		{
			if(y2>1)
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_DECREMENT.click();
			}
			else if(y2<=0)
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_INCREMENT.click();
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_SELECTOR.click();
			}
			else
			{
				new objectRepository.HotelRepository(driver).HOTEL_ROOM_CHILD_SELECTOR.click();
			}
		}
		//selecting done
		new objectRepository.HotelRepository(driver).HOTEL_ROOM_DONE.click();
		//Printing all the values
		
		System.out.println("\n-------------------------------------------------Page 1------------------------------------------------");
		//System.out.println("City Selected :"+p1_dcity);
		
		
		String dtemp2=new objectRepository.HotelRepository(driver).PAGE1_D_MONTH.getText();
		p1_ddate=dtemp1+" "+dtemp2;
//		System.out.println(dtemp1);
//		System.out.println(dtemp2);
		System.out.println("Departure date :"+p1_ddate); 
		
		String atemp1=new objectRepository.HotelRepository(driver).PAGE1_A_DATE.getText();
		String atemp2=new objectRepository.HotelRepository(driver).PAGE1_A_MONTH.getText();
		p1_adate=atemp1+" "+atemp2;
		System.out.println("Arrival Date :"+p1_adate);
		
		p1_adults=new objectRepository.HotelRepository(driver).PAGE1_ADULTS_COUNT.getText();
		System.out.println("Adults Selected :"+p1_adults);
		int i=Integer.parseInt(p1_adults);
		
		p1_child=new objectRepository.HotelRepository(driver).PAGE1_CHILDS_COUNT.getText();
		System.out.println("Childs Selected :"+p1_child);
		
		int j=Integer.parseInt(p1_child);
		int p1_traveller=i+j;
		
		p1_rooms=new objectRepository.HotelRepository(driver).PAGE1_ROOM_COUNT.getText();
		System.out.println("Rooms Selected :"+p1_rooms);
		
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		
		//Selecting search hotels on page 1
		new objectRepository.HotelRepository(driver).HOTEL_SEARCH_BUTTON.click();
	    //Accepting the pop up button
		try{
		new objectRepository.HotelRepository(driver).OK_GOT_IT_BUTTON_POPUP.click();
		new objectRepository.HotelRepository(driver).SKIPPING_POPUP.click();
		}
		catch(Exception e)
		{
			System.out.println("Not visible "+"OK GOT IT");
			System.out.println("Not visible "+"SKIP");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assigning values
		p2_adate=new objectRepository.HotelRepository(driver).PAGE2_A_DATE.getText().trim();
		p2_ddate=new objectRepository.HotelRepository(driver).PAGE2_D_DATE.getText().trim();
		String p2_travel=new objectRepository.HotelRepository(driver).PAGE2_N_TRAVELLER.getText();
		p2_travellers=Integer.parseInt(p2_travel);
		p2_city=new objectRepository.HotelRepository(driver).PAGE2_CITY.getText();
//		System.out.println("Page2 :"+p2_adate);
		
		System.out.println("----------------------------------------------Validation1----------------------------------------");
		if(p1_adate.equalsIgnoreCase(p2_adate))
			System.out.println("Arrival Date Validated "+p2_adate);
		if(p1_dcity.equalsIgnoreCase(p1_dcity))
			System.out.println("City Validated "+p2_city);
		if(p1_traveller==p2_travellers)
			System.out.println("Travellers validated "+p2_travellers);
		
		
		System.out.println("-------------------------------------------------------------------------------------------------");
		
		//Selecting the Price filter
		new objectRepository.HotelRepository(driver).FILTER_PRICE.click();
		//Selecting from the filter
		//new objectRepository.HotelRepository(driver).FILTER_PRICE_AMOUNT.click();
		//selecting done
		new objectRepository.HotelRepository(driver).FILTER_DONE.click();
		//selecting the location
		new objectRepository.HotelRepository(driver).FILTER_LOCATION.click();
		//storing the location filter
		
		p3_addressFilter=new objectRepository.HotelRepository(driver).FILTER_LOCATION_SELECTION.getText();
		//System.out.println(p3_addressFilter);
		//selecting the location area
		new objectRepository.HotelRepository(driver).FILTER_LOCATION_SELECTION.click();
		//clicking on done
		new objectRepository.HotelRepository(driver).FILTER_DONE.click();
		//Selecting the rating filter
		new objectRepository.HotelRepository(driver).FILTER_RATING.click();
		//SElecting the stars
		new objectRepository.HotelRepository(driver).FILTER_RATING_STARS.click();
		//selecting done
		new objectRepository.HotelRepository(driver).FILTER_DONE.click();
		//Sorting the hotels
		new objectRepository.HotelRepository(driver).SORTING.click();
		//sorting as per the rating
		new objectRepository.HotelRepository(driver).SORTING_SORT.click();
		//storing the selected hotel name
		p3_hotelName=new objectRepository.HotelRepository(driver).HOTEL_SELECTION_NAME.getText();
		//selecting the specific hotel
		new objectRepository.HotelRepository(driver).HOTEL_SELECTION.click();
		//selecting the photos tab
		new objectRepository.HotelRepository(driver).PHOTOS_TAB.click();
		//selecting the reviews tab
		new objectRepository.HotelRepository(driver).REVIEWS_TAB.click();
		//selecting the Summary Tab
		new objectRepository.HotelRepository(driver).SUMMARY_TAB.click();
		p4_hotelName=new objectRepository.HotelRepository(driver).PAGE3_HOTELNAME.getText();
		p4_hotelAddress=new objectRepository.HotelRepository(driver).PAGE3_ADDRESS.getText();
		//System.out.println(p4_hotelAddress);
		System.out.println("\n--------------------------------------Validation 2------------------------------------------");
//		if(p4_hotelAddress.contains(p3_addressFilter))
//			System.out.println("Hotel displayed correctly as per the filter "+p4_hotelAddress);
		if(p4_hotelName.equalsIgnoreCase(p3_hotelName))
			System.out.println("Hotel is correctly selected and displyed "+p4_hotelName);
		System.out.println("-----------------------------------------------------------------------------------------------");
		//clicks on select the room button
		new objectRepository.HotelRepository(driver).SELECT_ROOM_BUTTON.click();
		//click on continue button
		new objectRepository.HotelRepository(driver).CONTINUE_BUTTON.click();
		//click on details dropper on the review page
		new objectRepository.HotelRepository(driver).DETAILS_DROPPER.click();
		
		//page 4 contents
		String p4_cindate=new objectRepository.HotelRepository(driver).PAGE4_CHECKINDATE.getText();
		//System.out.println(p4_cindate);
		String p4_cooutdate=new objectRepository.HotelRepository(driver).PAGE4_CHECKOUTDATE.getText();
		//System.out.println(p4_cooutdate);
		String p4_rooms=new objectRepository.HotelRepository(driver).PAGE4_ROOM.getText();
		//System.out.println(p4_rooms);
		String p4_city=new objectRepository.HotelRepository(driver).PAGE4_CITY.getText();
		//System.out.println(p4_city);
		String p4_hotelname=new objectRepository.HotelRepository(driver).PAGE4_HOTELNAME.getText();
		//System.out.println(p4_hotelname);
		String p4_guests=new objectRepository.HotelRepository(driver).PAGE4_GUESTS.getText();
		//System.out.println(p4_guests);
		
		//System.out.println("p4_cindate="+p4_cindate+"p4_cooutdate"+p4_cooutdate+"p4_rooms"+p4_rooms+"p4_city"+p4_city+"p4_hotelname"+p4_hotelname+"p4_guests"+p4_guests);
		System.out.println("----------------------------------------------------Validation 3------------------------------------------");
		
//		String temp1=p4_cindate.substring(0, 5).toLowerCase();
//		System.out.println(temp1);
//		System.out.println(p2_ddate);
//		if(p2_ddate.equalsIgnoreCase(temp1))
//			System.out.println("Check-in date validated "+p2_ddate);
//		
//		
//		String temp2=p4_cooutdate.substring(0, 5).toLowerCase();
//		System.out.println(temp2);
//		System.out.println(p2_adate);
//		if(p2_adate.equalsIgnoreCase(temp2))
//			System.out.println("Check-out date validated "+p2_adate);
		
		String temp3=p4_rooms.substring(0,1);
		if(p1_rooms.equals(temp3))
			System.out.println("Rooms correctly displyed :"+ temp3);
		
		if(p3_hotelName.equals(p4_hotelname))
			System.out.println("Hotel name correctly displayed :"+p4_hotelname);
		
		String temp6=p4_city.substring(0, 6);
		if(p1_dcity.equals(temp6))
			System.out.println("City correctly displayed :"+p4_city);
		
		String temp4=p4_guests.substring(0, 1);
		int temp5=Integer.parseInt(temp4);
		if(p2_travellers==temp5)
			System.out.println("Correct number of travellers selected :"+temp5);
		
		System.out.println("-------------------------------------------------------------------------------------------------");
	  
		
		//again click on details dropper to close it
		new objectRepository.HotelRepository(driver).DETAILS_DROPPER.click();
		//Scrolling down to up in horizontal type
		
		reusableFunctions.ReusableFunctions.scrollWindow(65, driver);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //entering data into first user textarea
			//new objectRepository.HotelRepository(driver).DETAILS_USER_FIRSTNAME_TEXTAREA.clear();
			new objectRepository.HotelRepository(driver).DETAILS_USER_FIRSTNAME.sendKeys("Hello");
			//enetering data into second user
			//new objectRepository.HotelRepository(driver).DETAILS_USER_LASTNAME_TEXTAREA.clear();
			new objectRepository.HotelRepository(driver).DETAILS_USER_LASTNAME.sendKeys("User");
			
			String text=new objectRepository.HotelRepository(driver).DETAILS_USER_EMAIL_TEXTAREA.getText();
           // System.out.println(text);
			if(text!=null)
			{
			 System.out.println("Älready Entered Email ");
			}
			else
			{
				//entering the email address
				new objectRepository.HotelRepository(driver).DETAILS_USER_EMAIL.sendKeys("ABC@adb.in");
			}
			//entering the phone number
			//new objectRepository.HotelRepository(driver).DETAILS_USER_PHONENUMBER_TEXTAREA.clear();
			new objectRepository.HotelRepository(driver).DETAILS_USER_PHONENUMBER.sendKeys("8905642375");
			//clicking on continue
			new objectRepository.HotelRepository(driver).CONTINUE_BUTTON.click();
	
		//clicking on details drop down
		new objectRepository.HotelRepository(driver).DETAILS_DROPPER.click();
		//clicking back the details dropdown
		new objectRepository.HotelRepository(driver).DETAILS_DROPPER.click();
		//clicking on payment method to be as a debit card
		new objectRepository.HotelRepository(driver).CARD_DEBITCARD.click();
		//entering eth card number
		new objectRepository.HotelRepository(driver).CARD_DEBITCARD_NUMBER.sendKeys("4704560886077336");
		//entering the name on th card
		new objectRepository.HotelRepository(driver).CARD_DEBITCARD_NAME.sendKeys("USERNAME HELLO");
		//entering the expiry month
		new objectRepository.HotelRepository(driver).CARD_EXPIRY_MONTH.click();
		//selecting the month
		new objectRepository.HotelRepository(driver).CARD_EXPIRY_MONTH_SELECTOR.click();
		//selecting the expiry year
		new objectRepository.HotelRepository(driver).CARD_EXPIRY_YEAR.click();
		//selecting the year specifically
		new objectRepository.HotelRepository(driver).CARD_EXPIRY_YEAR_SELECTOR.click();
		//selecting the cvv
		new objectRepository.HotelRepository(driver).CARD_CVV_NUMBER.sendKeys("365");
		//clicking on continue
		new objectRepository.HotelRepository(driver).CONTINUE_BUTTON.click();
		//scroll by amount
		reusableFunctions.ReusableFunctions.scrollWindow(60, driver);
		//Selecting the country tab
		new objectRepository.HotelRepository(driver).CARD_COUNTRY.click();
		//selecting the country type
		new objectRepository.HotelRepository(driver).CARD_COUNTRY_SELECT.click();
		//selecting the state
		new objectRepository.HotelRepository(driver).CARD_STATE.clear();
		new objectRepository.HotelRepository(driver).CARD_STATE.sendKeys("MADHYA PRADESH");
		//entering the city
		new objectRepository.HotelRepository(driver).CARD_CITY.sendKeys("BHOPAL");
		//entering the address
		new objectRepository.HotelRepository(driver).CARD_ZIPCODE.clear();
		new objectRepository.HotelRepository(driver).CARD_ZIPCODE.sendKeys("462026");
		//entering the address
		new objectRepository.HotelRepository(driver).CARD_BILLINGADDRESS.clear();
		new objectRepository.HotelRepository(driver).CARD_BILLINGADDRESS.sendKeys("3452, shdfashgfghfgfgfg");
		try{
		//clicking on continue
		new objectRepository.HotelRepository(driver).CONTINUE_BUTTON.click();
		}
		catch(Exception e)
		{
			System.out.println("Continue is not clickable as dummy card details ");
		}
		
		
		
		
		
	}
	@AfterClass
	public void close()
	{
		//------Stop Recorder and Closing the browser
		//ReusableFunctions.stopRecoder(recorder);
		driver.quit();
	}
	
	
	

}
