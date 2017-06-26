package Test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import source.ObjectRepository;
import source.ReusableFunctions;

public class ReadingExcel {

	public static void main(String[] args) {
		
		String path="G:/WorkSpace/PB_Project/test-data/Book1.xlsx";
		WebDriver driver=new FirefoxDriver();
		driver.get("http://deptresourc.web708.discountasp.net/PB1/Login.aspx");
		
			XSSFWorkbook book;
			try {
				book = new XSSFWorkbook(path);
				XSSFSheet sheet=book.getSheetAt(0);
				XSSFRow row=sheet.getRow(0);
				String username=row.getCell(0).getStringCellValue();
				String password=row.getCell(1).getStringCellValue();
				new ObjectRepository(driver).XPATH_LOGIN_PAGE_USERID.sendKeys(username);
				new ObjectRepository(driver).XPATH_LOGIN_PAGE_PASSWORD.sendKeys(password);
				new ObjectRepository(driver).XPATH_LOGIN_PAGE_SUBMIT.click();
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			driver.close();
		
	}

}
