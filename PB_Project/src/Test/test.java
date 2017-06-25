package Test;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

public class test {

	public static void main(String[] args) {
		String sEmailHost = "imap.gmail.com"; // For AOL ->
		// "imap.aol.com";
		String sEMailStoreType = "imaps";
		String Username = "neovaqa.jyoti@gmail.com";// provide user name
		String Password ="may@2017";// provide password
		String spassword = null;
		String str;
		
		try {
			Properties props = new Properties();
			props.setProperty("mail.store.protocol", sEMailStoreType);
			Session session = Session.getInstance(props, null);
			Store store = session.getStore(sEMailStoreType);
			store.connect(sEmailHost, Username, Password);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			Message msg = inbox.getMessage(inbox.getMessageCount());
			Multipart mp = (Multipart) msg.getContent();
			BodyPart bp = mp.getBodyPart(0);
			String sgetPass = (String) bp.getContent();
			 SearchTerm sender = new FromTerm(new InternetAddress("jyoti_pareek@neovasolutions.com"));
//			   Message messages[] = inbox.search(new FlagTerm(
//			   new Flags(Flag.SEEN), true));
			   
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
			   System.out.println("Get From"+message.getFrom());
			   System.out.println("R"+message.getReplyTo());
			  
			   Address address[]=message.getFrom();
			   System.out.println("\nGet From"+address[0].toString());
			   System.out.println("\nGet From User "+address[0].toString().substring(0, 12));
			   
			   Address reply[]=message.getReplyTo();
			   System.out.println("REply To"+reply[0].toString());
			   
			   
			   //Displaying all the content
			   System.out.println(sgetPass);
			   
			   //Fetching the link to be opened
			   String temp="http://us4.campaign-archive1.com/?u=345d3eb5cefbe06c776f61bee&id=b6060c2ecf&e=89de56382";
				  int y=sgetPass.indexOf("http://us4.campaign-archive1.com/?u=345d3eb5cefbe06c776f61bee&id=b6060c2ecf&e=89de56382");
				 // System.out.println(y); 
				  int x=temp.length();
				 // System.out.println(x);
				   str=sgetPass.substring(y, y+x);
				   System.out.println(str);
				   
				   
			   
			   // reply to email
			   // from email
			   //from name 

//			   //Displaying the content of the email 
//			   Message msg = inbox.getMessage(inbox.getMessageCount());
//			   Multipart mp = (Multipart) msg.getContent();
//			   BodyPart bp = mp.getBodyPart(0);
//			   String sgetPass = (String) bp.getContent();
//			   System.out.println(sgetPass);
//			   
//			
//			   System.out.println("--------------------------------");
			   
			   } 
			
//			
//			if (sgetPass.contains("Username:")) {
//				int i = sgetPass.indexOf("Password:");
//				i = sgetPass.indexOf(" ", i) + 1;
//				int j = sgetPass.indexOf("\n", sgetPass.indexOf("Password:")) - 1;
//				spassword = sgetPass.substring(i, j);
//			} else {
//				System.out.println("Username: String not found in Message body. Unable to parse password.");
//			}
		} catch (Exception e) {
			System.out.println("Exception Occured While Parsing Password Sent " + e.getMessage());
		}
	}

}
