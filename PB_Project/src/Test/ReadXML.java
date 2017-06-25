package Test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		 try {
		File file=new File("G:/WorkSpace/PB_Project/User.xml");
		
      DocumentBuilderFactory db =DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=db.newDocumentBuilder();
		Document doc=dBuilder.parse(file);
		System.out.println("ROOT ELEMENT :"+doc.getDocumentElement().getNodeName());
	
		NodeList nlist=doc.getElementsByTagName("staff");
		System.out.println("-----------------------------");
		
		for(int i=0; i<nlist.getLength(); i++)
		{
			Node nnode=nlist.item(i);
			System.out.println("\n Current Element "+nnode.getNodeName());
			
			
			
			System.out.println(nlist.getLength());
			
			if(nnode.hasChildNodes())
			{
				Element element=(Element)nnode;
				System.out.println("Staff id"+element.getAttribute("id"));
				System.out.println("Firstname"+element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name:"+element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("NickName:"+element.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println(" Salary:"+element.getElementsByTagName("salary").item(0).getTextContent());
				
			}
			
		}
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
