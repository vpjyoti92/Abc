package Test;

import java.io.File;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;
import javax.mail.internet.InternetAddress;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Email {
	
	static Properties properties;
	private Session session = null;
	private String storeType="ïmaps";
	private Store store = null;
	private Folder inbox = null;
	private String host="imap.gmail.com";
	private String userName = "neovaqa.jyoti@gmail.com";// provide user name
	private String password ="may@2017";// provide password
    // Calling checkMail method to check received emails
	
	public static void main(String args[])
	{
		//Set mail properties and configure accordingly
		
		Email email=new Email();
		String str=email.readMails();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(str);
		Email.takeScreen(driver);
		
			}
	
	
	//email parsing without port number for imap protocol
	public void emailParsing()
	{
		properties.getProperty("mail.store.protocol", storeType);
		 session=Session.getInstance(properties);
	     try {
			store=session.getStore();
			store.connect(host, userName, password);
			Folder folder=store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			
			//reading message
			Message message=folder.getMessage(folder.getMessageCount());
			Multipart part=(Multipart) message.getContent();
			BodyPart bp=part.getBodyPart(0);
			String value=(String) bp.getContent();
			
			
			//seraching sender and getting the value
			
			SearchTerm sender = new FromTerm(new InternetAddress("jyoti_pareek@neovasolutions.com"));
			Message messages[]=inbox.search(sender);
			   System.out.println("Number of mails = " + messages.length);
			   for (int i = 0; i < messages.length; i++) 
			   { 
			   Message message1 = messages[i];
			   Address[] from = message.getFrom();
			   System.out.println("-------------------------------");
			   System.out.println("Date : " + message.getSentDate()); 
			   System.out.println("From : " + from[0]); 
			   System.out.println("Subject: " + message.getSubject()); 
			   System.out.println("Content :"+message.getContentType().length());
			   System.out.println("Description:"+message.getContent());
			   System.out.println("Get From :"+message.getFrom());
			   System.out.println("Reply to: "+message.getReplyTo());
			  // System.out.println(""+message.);
			
			   
		}
	}
	     		catch(Exception e)
	     {
	     				System.out.println(e.getMessage());
	     }
		
	
	}
	
	
	//email for parsing with port number for protocol imap
	 public String readMails() {
		   
		   String str="";
		   //settting properties
		   properties = new Properties();
		   properties.setProperty("mail.host", "imap.gmail.com");
		   properties.setProperty("mail.port", "587");
		   properties.setProperty("mail.transport.protocol", "imaps");
		   session = Session.getInstance(properties,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication(userName, password);
		   }
		   });
		   
		   System.out.println("one step completed");
		   try {
		   store = session.getStore("imaps");
		   store.connect();
		   inbox = store.getFolder("INBOX");
		   inbox.open(Folder.READ_ONLY);
		   
		   SearchTerm sender = new FromTerm(new InternetAddress("jyoti_pareek@neovasolutions.com"));
//		   Message messages[] = inbox.search(new FlagTerm(
//		   new Flags(Flag.SEEN), true));
		   
		   Message messages[]=inbox.search(sender);
		   System.out.println("Number of mails = " + messages.length);
		   for (int i = 0; i < messages.length; i++) 
		   { 
		   Message message = messages[i];
		   Address[] from = message.getFrom();
		   System.out.println("-------------------------------");
		   System.out.println("Date : " + message.getSentDate()); 
		   System.out.println("From : " + from[0]); 
		   System.out.println("Subject: " + message.getSubject()); 
		   System.out.println("Content :"+message.getContentType().length());
		   System.out.println("Description:"+message.getContent());
		   System.out.println("Address To be replied :"+message.getReplyTo().getClass());
		   System.out.println("From email sender :"+message.getFrom().toString());
		
		   // reply to email
		   // from email
		   //from name 
		  
		   //Displaying the content of the email 
		   Message msg = inbox.getMessage(inbox.getMessageCount());
		   Multipart mp = (Multipart) msg.getContent();
		   BodyPart bp = mp.getBodyPart(0);
		   String sgetPass = (String) bp.getContent();
		   System.out.println(sgetPass);
		   String temp="http://us4.campaign-archive1.com/?u=345d3eb5cefbe06c776f61bee&id=b6060c2ecf&e=89de56382";
		  int y=sgetPass.indexOf("http://us4.campaign-archive1.com/?u=345d3eb5cefbe06c776f61bee&id=b6060c2ecf&e=89de56382");
		  System.out.println(y); 
		  int x=temp.length();
		  System.out.println(x);
		   str=sgetPass.substring(y, y+x);
		   System.out.println(str);
		
		   System.out.println("--------------------------------");
		   
		   } 
		  
		   inbox.close(true);
		   
		   store.close();
			     }
		   catch (Exception e) 
		   { 
			  System.out.println("Exception"+e.getMessage());
			   } 
		  
		return str;
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
		 
		   public static void checkMail(String hostval, String mailStrProt, String uname,String pwd) 
		   {
		      try {
		      //Set property values
		      Properties propvals = new Properties();
		      propvals.put("mail.pop3.host", hostval);
		      propvals.put("mail.pop3.port", "995");
		      propvals.put("mail.pop3.starttls.enable", "true");
		      Session emailSessionObj = Session.getDefaultInstance(propvals);  
		      //Create POP3 store object and connect with the server
		      Store storeObj = emailSessionObj.getStore("pop3s");
		      storeObj.connect(hostval, uname, pwd);
		      //Create folder object and open it in read-only mode
		      Folder emailFolderObj = storeObj.getFolder("INBOX");
		      emailFolderObj.open(Folder.READ_ONLY);
		      //Fetch messages from the folder and print in a loop
		      Message[] messageobjs = emailFolderObj.getMessages(); 
		 
		      for (int i = 0, n = messageobjs.length; i < n; i++) {
		         Message indvidualmsg = messageobjs[i];
		         System.out.println("Printing individual messages");
		         System.out.println("No# " + (i + 1));
		         System.out.println("Email Subject: " + indvidualmsg.getSubject());
		         System.out.println("Sender: " + indvidualmsg.getFrom()[0]);
		         System.out.println("Content: " + indvidualmsg.getContent().toString());

		      }
		      //Now close all the objects
		      emailFolderObj.close(false);
		      storeObj.close();
		      } catch (NoSuchProviderException exp) {
		         exp.printStackTrace();
		      } catch (MessagingException exp) {
		         exp.printStackTrace();
		      } catch (Exception exp) {
		         exp.printStackTrace();
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

}
