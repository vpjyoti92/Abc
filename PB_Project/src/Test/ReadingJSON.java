package Test;
 
import java.io.FileReader;

import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import source.ObjectRepository;
 
/**
 * @author Crunchify.com
 */
 
public class ReadingJSON {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
 
        try {
 
            Object obj = parser.parse(new FileReader(
                    "/G:/WorkSpace/PB_Project/test-data/File1.txt"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            
            System.out.println("Name: " + name);
            System.out.println("Password: " + author);
            
            WebDriver driver=new FirefoxDriver();
            driver.get("http://deptresourc.web708.discountasp.net/PB1/Login.aspx");
            new ObjectRepository(driver).XPATH_LOGIN_PAGE_USERID.sendKeys(name);
			new ObjectRepository(driver).XPATH_LOGIN_PAGE_PASSWORD.sendKeys(author);
			new ObjectRepository(driver).XPATH_LOGIN_PAGE_SUBMIT.click();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}