package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice16 {
	 
	
	public static void main(String args[])
	{
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		runUploading(driver);
		takeScreen(driver);
		
		  String host ="pop.gmail.com";// change accordingly
	      String mailStoreType ="pop3";
	      String username ="vpjyoti92@gmail.com";// change accordingly
	      String password ="Jyoti@123";// change accordingly
	      
	      sendEmail(host ,mailStoreType, username,password);
		
		driver.close();
	}
	
	public static void runUploading(WebDriver driver)
	{
           driver.findElement(By.xpath("//*[@id='photo']")).click();
		
		StringSelection stringSelection = new StringSelection("AppPackageActivity");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
			
			 robot.keyPress(KeyEvent.VK_ENTER);
			 robot.delay(200);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void takeScreen(WebDriver driver)
	{
		
		TakesScreenshot scr=(TakesScreenshot)driver;
		File file=scr.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file,new File("G:/WorkSpace/PB_Project/test-output/Screen.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendEmail(String hostname , String storeType, String userId, String passwrd)
	{
		//Creating properties filed with mail hostname , port and starting tls server (telegence)
		
		Properties prop=new Properties();
		prop.put("mail.smtp.host", hostname);
		prop.put("mail.smtp.port", "995");
		prop.put("mail.smtp.starttls.enable","true");
	   // Authenticator auth = new SMTPAuthenticator();
		Session emailSession=Session.getDefaultInstance(prop);
		
		//create pop store object and connect with server
		 try {
			Store store=emailSession.getStore();
			//create folder object and store it
			Folder folder=store.getFolder("INBOX");
			folder.open(folder.READ_ONLY);
			Message[] message=folder.getMessages();
			System.out.println("Message Length"+message.length);
			
			for(int i=0; i<message.length; i++)
			{  
				Message message1 = message[i];
				System.out.println("Email Number"+(i+1));
				System.out.println("Subject"+message1.getSubject());
				System.out.println("REcepients"+message1.getAllRecipients());
				System.out.println("Content"+message1.getContent().toString());
				
			}
			
			folder.close(false);
		      store.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		
		
		
	}

	
	
}
