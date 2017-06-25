//package Demo1;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
//import io.appium.java_client.android.AndroidDriver;
//
//public class Login {
//	
//	AndroidDriver driver;
//	Dimension size;
//	static ATUTestRecorder record;
//	
//	
//	@BeforeTest
//    public void setUp()
//    {
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
//		try {
//			
//			record=new ATUTestRecorder("G:/WorkSpace/ATUTestRecorderjar/CWorkSpaceATUTestRecorderjaScreens","MyTrip"+format.format(date), false);
//	         record.start();	
//		} catch (ATUTestRecorderException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		DesiredCapabilities dc=new DesiredCapabilities();
//		dc.setCapability("deviceName", "192.168.145.104:5555");
//		dc.setCapability(CapabilityType.BROWSER_NAME, "Android");
//		dc.setCapability(CapabilityType.VERSION, "4.2.2");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("appPackage", "com.makemytrip");
//		dc.setCapability("appActivity", "com.mmt.travel.app.home.ui.ShowGrowthHack");
//    
//		try {
//			driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),dc);
//			System.out.println("Application Launched Successfully ");
//			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			e.getMessage();
//		}
//		
//    }
//	
//	@Test
//	public void run()
//	{
//		driver.findElement(By.name("CONTINUE")).click();
//		driver.findElement(By.name("SKIP")).click();
//		driver.findElement(By.className("android.widget.ImageView")).click();
//		//Clicking OK on the pop up for PlayStore
//		driver.findElement(By.name("OK")).click();
//		//Selecting Flights
//		driver.findElement(By.name("Flights")).click();
//        //Selecting the From Location 
//		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
//		//Enter the Departure City
//     	driver.findElement(By.name("Enter Departure City")).sendKeys("PNQ");
////		driver.findElement(By.className("android.widget.ImageView")).click();
//		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
//		driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='5']")).click();
//		driver.findElement(By.name("Bangalore")).click();
//		
//		
//	//	driver.findElement(By.xpath("android.widget.ImageView//[@index='4']")).click();
//		//SElecting Departure Date and clicking on OKay
//		
//	   driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='1']")).click();
// 	   driver.findElement(By.xpath("//android.widget.LinearLayout[@index=0]/android.widget.LinearLayout[@index='1']/android.widget.CheckedTextView[@index='2']")).click();
// 	   driver.findElement(By.name("OK")).click();
// 	   //swipe down to up
// 	   
//// 	   size=driver.manage().window().getSize();
//// 	   int starty = (int) (size.height * 0.80);
//// 	   int endy = (int) (size.height * 0.20);
//// 	  int startx = size.width / 2;
//// 	  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
//// 	  driver.swipe(startx,starty,startx,endy,250);
// 	   
// 	   
//// 	  driver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).click();
//// 	  System.out.println("Date Selected");
// 	  
// 	 
// 	 //SElecting Return Date and OKay
// 	 driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='7']/android.widget.RelativeLayout[@index='2']")).click();
// 	 driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.CheckedTextView[@index='0']")).click();
// 	 driver.findElement(By.name("OK")).click();
// 	 
// 	 //SElecting the Adults
// 	 driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='8']/android.widget.RelativeLayout[@index='0']")).click();
// 	 driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.RelativeLayout[@index='2']")).click();
// 	 driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='6']")).click();
// 	 
// 	 driver.findElement(By.xpath("//android.widget.TextView[@text='ECONOMY']")).click();
// 	 driver.findElement(By.name("premium economy")).click();
// 	 
// 	 
// 	 driver.findElement(By.name("search")).click();
// 	 
// 			 
// 	  
// 	   
//    //Applying Filters to filter the type of flight
// 	 driver.findElement(By.name("FILTER")).click();
// 	 //Scrolling between filters
// 	 //stops
// 	 driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='0']")).click();
// 	 driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']")).click();
// 	 //time
// 	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='1']")).click();
// 	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']/android.widget.RelativeLayout[@index='0']")).click();
// 	//aireline
// 	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='2']")).click();
//	driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']/android.widget.ImageView[@index='4']")).click();
//		//more
//	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']/android.widget.RelativeLayout[@index='3']")).click();
//	
//	driver.findElement(By.name("Apply")).click();
//	
//	
//	
//	//return flight select
//	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='1']")).click();
//	driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).click();
//	//Going flight
//	driver.findElement(By.xpath("//android.widget.FrameLayout[@index='0']")).click();
//	driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='0']")).click();
//	
//	driver.findElement(By.name("BOOK")).click();
//	
//	
//	
//	}
//	@AfterTest
//	public void close()
//	{
//		try {
//			record.stop();
//		} catch (ATUTestRecorderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
