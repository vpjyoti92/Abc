package reusable;
import java.io.File;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseTestNGReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sEmailableContent ="";
		try {
			
			File inputFile = new File("test-output/testng-results.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			Node nNode1 = doc.getElementsByTagName("testng-results").item(0);
			Element eElement1 = (Element) nNode1;

			sEmailableContent = "---------------------\n";
			sEmailableContent = sEmailableContent + "Total Test - " + eElement1.getAttribute("total") + "\n";
			sEmailableContent = sEmailableContent + "Test Failed - " + eElement1.getAttribute("failed") + "\n";
			sEmailableContent = sEmailableContent + "Test Passed - " + eElement1.getAttribute("passed") + "\n";
			sEmailableContent = sEmailableContent + "Test Skipped - " + eElement1.getAttribute("skipped") + "\n";
			sEmailableContent = sEmailableContent + "---------------------\n";

			NodeList nList = doc.getElementsByTagName("test-method");
			sEmailableContent = sEmailableContent + "\nThe Following Test Passed -\n";

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				if (!eElement.hasAttribute("is-config") && (eElement.getAttribute("status").equalsIgnoreCase("pass"))) {
					sEmailableContent = sEmailableContent + "\t" + eElement.getAttribute("name") +" [" +((Element) nNode.getParentNode()).getAttribute("name") + "]\n";
				}
			}

			nList = doc.getElementsByTagName("test-method");
			sEmailableContent = sEmailableContent + "\nThe Following Test Failed -\n";

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				if (!eElement.hasAttribute("is-config") && (eElement.getAttribute("status").equalsIgnoreCase("fail"))) {
					sEmailableContent = sEmailableContent + "\t" + eElement.getAttribute("name") +" [" +((Element) nNode.getParentNode()).getAttribute("name") + "]\n";
				}
			}

			nList = doc.getElementsByTagName("test-method");
			sEmailableContent = sEmailableContent + "\nThe Following Test Skipped -\n";

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				Element eElement = (Element) nNode;
				if (!eElement.hasAttribute("is-config") && (eElement.getAttribute("status").equalsIgnoreCase("skip"))) {
					sEmailableContent = sEmailableContent + "\t" + eElement.getAttribute("name") +" [" +((Element) nNode.getParentNode()).getAttribute("name") + "]\n";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured Wile Parsing TestNG Result File");
		}
		try{
			File file = new File("test-output/EmailContents.txt");
		    file.createNewFile();
		    FileWriter writer = new FileWriter(file); 
		    writer.write(sEmailableContent); 
		    writer.flush();
		    writer.close();
		}catch(Exception e){
			System.out.println("Exception Occured While Creating ContentText File");
		}
	}
}