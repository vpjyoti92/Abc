package testScripts;

import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;
import driverScript.InitializeDriver;
import io.appium.java_client.android.AndroidDriver;
import objectRepository.SearchingFlights;
import reusableFunctions.ReusableFunctions;

public class Flight {

	//Variables for driver
	private AndroidDriver driver;
	private ATUTestRecorder recorder;
	DateFormat format=new SimpleDateFormat("yy-mm-dd hh-mm-ss");
	Date date=new Date();

	//Variable declaration for validations 

	private String departureCity;
	private String arrivingCity;
	private String deptDate;
	private String arrivalDate;
	private String adults;
	private String deptMonth;
	private String arrivalMonth;
	private String completeDate;
	private String arrivalPrice;
	private String deptPrice;
	private String totalPrice;
	private String stop;
	private String flightType;

	@BeforeClass
	public void launch()
	{
		recorder=ReusableFunctions.startRecorder(recorder);
		try {
			reusableFunctions.AppiumStartAndStop.appiumStop();
			reusableFunctions.AppiumStartAndStop.appiumStart();
			//ReusableFunctions.startAppiumServer(process,APPIUMSERVERSTART);
			InitializeDriver.setUp();
			driver=InitializeDriver.driver;
			Thread.sleep(2000);
			recorder.start();
		} catch (Exception e) {
			System.out.println("Exception occurred while launching "+e.getMessage());
		}
		
		
	}

	@Test(priority=1)
	public void runForFlightSearch() {
	
		//-------Searching Flight----------//
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new SearchingFlights(driver).BACK_ARROW.click();
		//new SearchingFlights(driver).SKIPPING_OFFER.click();
		//new SearchingFlights(driver).BACK_ARROW.click();
		new SearchingFlights(driver).BUTTON_OK.click();
		new SearchingFlights(driver).FLIGHT.click();
		new SearchingFlights(driver).ELEMENT1.click();
		new SearchingFlights(driver).DEPARTURECITY.sendKeys("PNQ");
		new SearchingFlights(driver).SELECTSEARCH.click();  
		new SearchingFlights(driver).ARRIVINGCITY.click();
		new SearchingFlights(driver).SELECTBANGLORE.click();
		new SearchingFlights(driver).DEPARTURE_DATE_SELECTOR.click();
		new SearchingFlights(driver).SELECTING_DATE.click();
		new SearchingFlights(driver).OK_BUTTON.click();
		new SearchingFlights(driver).RETURNDATE_SELECTOR.click();
		new SearchingFlights(driver).RETURN_DATE.click();
		new SearchingFlights(driver).OK_BUTTON2.click();
		new SearchingFlights(driver).ADULT_SELECTOR.click();
		adults=new SearchingFlights(driver).ADULT_COUNT.getText();
		int x=Integer.parseInt(adults);
		System.out.println(x);
		if(x<=1)
		{
			new SearchingFlights(driver).INCREMENT_BUTTON.click();
			System.out.println("Increment clicked");
			new SearchingFlights(driver).OK_BUTTON3.click();
			System.out.println("clicked on okay");
		}
		else
		{
			new SearchingFlights(driver).OK_BUTTON3.click();
			//System.out.println("directly clicked on okay");
		}

		new SearchingFlights(driver).ECONOMY_SELECTOR.click();
		new SearchingFlights(driver).ECONOMY.click();
		
		departureCity=new SearchingFlights(driver).PAGE1_D_CITY.getText();
		arrivingCity=new SearchingFlights(driver).PAGE1_A_CITY.getText();
		deptDate=new SearchingFlights(driver).PAGE1_D_DATE.getText();
		deptMonth=new SearchingFlights(driver).PAGE1_D_MONTH.getText();
		arrivalDate=new SearchingFlights(driver).PAGE1_A_DATE.getText();
		arrivalMonth=new SearchingFlights(driver).PAGE1_A_MONTH.getText();
		completeDate=deptDate+""+deptMonth+"-"+arrivalDate+""+arrivalMonth;
		adults=new SearchingFlights(driver).PAGE1_ADULT_COUNT.getText()+" "+"Adults";
		//System.out.println(departureCity+arrivingCity+completeDate+adults); 
		new SearchingFlights(driver).SEARCH_BUTTON.click();

	}
	
	@Test(priority=2)
	public void filterApply()
	{
		//-------Selecting the filters------------
		
		System.out.println("***************Validation 1************************");
		if(arrivingCity.equals((new SearchingFlights(driver).PAGE2_A_CITY).getText()))
			System.out.println("Correct Arrival City Displayed : "+arrivingCity);
		if(departureCity.equals((new SearchingFlights(driver).PAGE2_D_CITY).getText()))
			System.out.println("Correct Departure City Displayed : "+departureCity);
		if(completeDate.equals((new SearchingFlights(driver).PAGE2_DATES).getText()))
			System.out.println("Correct Dates displayed : "+completeDate);
		if(adults.equals(new SearchingFlights(driver).PAGE2_ADULTS.getText()))
			System.out.println("Correct number of Adults displayed : "+adults);
		System.out.println("*****************************************************");
		new SearchingFlights(driver).FILTER_SELECTOR.click();
		System.out.println("Filter Selected");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		new SearchingFlights(driver).STOP_SELECTOR.click();
		//System.out.println("Stop tab selected");
		new SearchingFlights(driver).STOP.click();
		//System.out.println("1 stop selected");
		stop=new SearchingFlights(driver).STOP_NUMBER.getText();
		new SearchingFlights(driver).TIME_SELECTOR.click();
		//System.out.println("Time selector");
		new SearchingFlights(driver).TIME.click();
		//System.out.println("Time selected of morning");
		new SearchingFlights(driver).AIRLINE_SELECTOR.click();
		//System.out.println("Airline selector");
		new SearchingFlights(driver).AIRLINE.click();
		//System.out.println("Airline tyoe selected");
		new SearchingFlights(driver).MORE.click();
		//System.out.println("More selected");
		new SearchingFlights(driver).MORE_SELECTION.click();
		//System.out.println("More selction done");
		new SearchingFlights(driver).APPLY_BUTTON.click();
		//System.out.println("Clicked on Apply");
	}

	@Test(priority=3)
	public void selectFlight()
	{
		//-----Selecting the Boarding and Arriving Flight 
		
		new SearchingFlights(driver).BOARDINGFLIGHT_SELECTOR.click();
		System.out.println("SElected bpoarding");
		new SearchingFlights(driver).BOARDINGFLIGHT.click();
		System.out.println("Selected Flight"); 
		flightType=new SearchingFlights(driver).PAGE3_FLIGHT_TYPE.getText();
		//			 new SearchingFlights(driver).RETURNFLIGHT_SELECTOR.click();
		//			 System.out.println("selected Return");
		//			 new SearchingFlights(driver).RETURNFLIGHT.click();
		//			 System.out.println("selected boarding");
		arrivalPrice=new SearchingFlights(driver).PAGE3_ARRIVING_AMOUNT.getText();
		deptPrice=new SearchingFlights(driver).PAGE3_BOARDING_AMOUNT.getText();
		totalPrice=new SearchingFlights(driver).PAGE3_TOTAL_AMOUNT.getText();
		System.out.println("***********Validation 2*********************");
		String temp=stop+"Stop";
		// System.out.println(temp);
		if(temp.equals(new SearchingFlights(driver).PAGE3_STOP.getText()))
		{
			System.out.println("Correct Stop Displayed and Selected :"+temp);
		}
		System.out.println("*********************************************");
		new SearchingFlights(driver).BOOKING.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("**************Validation 3*************************");
		//			 System.out.println(new SearchingFlights(driver).PAGE4_STOP.getText());
		//			 System.out.println(new SearchingFlights(driver).PAGE4_FLIGHTTYPE.getText());
		// System.out.println(flightType);
		String temp2=stop+""+"Stop";
		if(temp2.equals(new SearchingFlights(driver).PAGE4_STOP.getText()))
		{
			System.out.println("Correct Number of stops selected :"+stop);
		}
		if(flightType.equals(new SearchingFlights(driver).PAGE4_FLIGHTTYPE.getText()))
		{
			System.out.println("Correct Flight Type displayed :"+flightType);
		}
		System.out.println("*************************************************************");
		//               int temp1 =Integer.parseInt(deptPrice.substring(1, deptPrice.length()));
		//               int temp2=Integer.parseInt(arrivalPrice.substring(1,arrivalPrice.length()));
		//               int temp3=Integer.parseInt(totalPrice.substring(1,totalPrice.length()));

		//System.out.println(arrivalPrice+deptPrice+totalPrice);
		//			 if(temp3==temp1+temp2)
		//			 {
		//				 System.out.println("Total Price displayed correctly :"+temp3+"="+temp1+"+"+temp2);
		//			 }
	}

	@Test(priority=4)
	public void booking()
	{   
		//-----Updating the information needed for flight booking-----
		
		new SearchingFlights(driver).CONTINUE_FOR_BOOKING.click();
		new SearchingFlights(driver).DETAILS_DROPDOWN.click();
		new SearchingFlights(driver).DETAILS_DROPDOWN.click();
		new SearchingFlights(driver).ADD_NEW_ADULT.click();
		new SearchingFlights(driver).ENTER_FIRSTNAME_ADULT.sendKeys("user1");
		new SearchingFlights(driver).ENTER_LASTNAME_ADULT.sendKeys("Hello");
		new SearchingFlights(driver).SELECT_FEMALEGENDER_ADULT.click();
		new SearchingFlights(driver).DONE.click();
		// new SearchingFlights(driver).SEE_ALL_ADULTS.click();
		// System.out.println("All adultd display");
		new SearchingFlights(driver).SELECTING_ADULT.click();
		System.out.println("Selected specific adult");
		ReusableFunctions.scrollWindow(80, driver);
		System.out.println("scrolled");
		new SearchingFlights(driver).ENTER_CONTACT_EMAILADDRESS.clear();
		// System.out.println("Ëmail Cleared");
		new SearchingFlights(driver).ENTER_CONTACT_EMAILADDRESS.sendKeys("abc@g.com");
		System.out.println("Email Entered");
		//new SearchingFlights(driver).ENTER_CONTACT_PHONENUMBER.clear();
		//System.out.println("Phone Number Cleared");
		new SearchingFlights(driver).ENTER_CONTACT_PHONENUMBER.sendKeys("7878787877");
		System.out.println("Phone Number Entered");
		//ReusableFunctions.scrollWindow(70, driver);
		//			 new SearchingFlights(driver).SELECT_CONTACT_TERMSCONDITIONS.click();
		//			 System.out.println("Selected Terms ");
		new SearchingFlights(driver).BOOK_FLIGHT.click();
		System.err.println("Clicked on book flight");
		//Search another flight
		new SearchingFlights(driver).SELECT_ANOTHER_FLIGHT_POPUP.click(); 
		//moving out using back button
		new SearchingFlights(driver).SELECT_FIRST_BACK_BUTTON.click();
		//moving out using second back button
		new SearchingFlights(driver).SELECT_SECOND_BACK_BUTTON.click();
		//moving out using third back button
		new SearchingFlights(driver).SELECT_THIRD_BACK_BUTTON.click();
} 
	@AfterClass
	public void close()
	{
		//------Stop Recorder and Closing the browser
		reusableFunctions.AppiumStartAndStop.appiumStop();
		ReusableFunctions.stopRecoder(recorder);
		driver.quit();
	}

	
}

