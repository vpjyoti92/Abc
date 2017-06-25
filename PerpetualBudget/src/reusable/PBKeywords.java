package reusable;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PBKeywords {
	
	/**
	 * This method will hover mouse to the web element.
	 * @param driver
	 * @param we
	 * @return
	 */
	public static boolean hoverToElement(WebDriver driver, WebElement we) {
		try {
			Thread.sleep(200);
			new Actions(driver).moveToElement(we).build().perform();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Occured in hoverToElement " + e.getMessage());
			return false;
		}
	}

	/**
	 * This method will hover mouse to the item and perform click.
	 * @param driver
	 * @param we
	 * @return
	 */
	public static boolean hoverToElementAndClick(WebDriver driver, WebElement we) {
		try {
			new Actions(driver).moveToElement(we).click(we).build().perform();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Occured in hoverToElementAndClick " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * This method scrolls to a web element
	 * @param driver
	 * @param we
	 */
	public static void scrollToElement(WebDriver driver, WebElement we) {
		try {
			((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(" + we.getLocation().getX()
					+ " , " + (we.getLocation().getY() - 100) + ")");
		} catch (Exception e) {
			System.out.println("Exception occured in scrollToElement " + e.getMessage());
		}
	}
	
	/**
	 * This method scrolls to a web element and performs click operation
	 * @param driver
	 * @param element WebElement to click
	 */			
	public static void scrollToAndClick(WebDriver driver, WebElement we) {
		try {
			((JavascriptExecutor) driver).executeScript("javascript:window.scrollTo(" + we.getLocation().getX() + " , "
					+ (we.getLocation().getY() - 100) + ")");
			we.click();
		} catch (Exception e) {
			System.out.println("Exception in scrollToAndClick - " + e.getMessage());
		}
	}
	
	/**
	 * This method performs click operation using javascript
	 * @param driver
	 * @param we
	 */
	public static void javascriptClick(WebDriver driver, WebElement we) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", we);
		} catch (Exception e) {
			System.out.println("Exception occured in javascriptClick " + e.getMessage());
		}
	}
	
	
	/**
	 * Select value using visible text from drop down box
	 * @param elem
	 * @param text
	 * @return
	 */
	public static boolean dropdownSelectByVisibleText(WebElement we, String sText) {
		boolean status = false;
		try {
			new Select(we).selectByVisibleText(sText);
			status = true;
		} catch (Exception e) {
			System.out.println("Exception occured in dropdownSelectByVisibleText " + e.getMessage());
		}
		return status;
	}
	
	
	/**
	 * Get selected value from drop down box using javascript
	 * @param driver
	 * @param we
	 * @param text
	 * @return
	 */
	public static String javascriptGetValueOfDropDown(WebElement we, WebDriver driver) {
		String sText = null; 
		try {
			Thread.sleep(200);
			sText = ((JavascriptExecutor) driver)
					.executeScript("return arguments[0].options[arguments[0].selectedIndex].text", we).toString();
			sText = sText.trim();
		} catch (Exception e) {
			System.out.println("Exception occured in javascriptGetValueOfDropDown " + e.getMessage());
		}
		
		// --- Changing the text to blank if javascript returns default = null
		
		if (sText.equalsIgnoreCase("null")) {
			sText = "";
		}
		return sText;
	}
	
	/**
	 * This method returns the web element from the list matching the text.
	 * @param list
	 * @param sElementName
	 * @return
	 */
	public static WebElement getWebelementFromList(List<WebElement> list, String sElementName) {
		try {
			for (WebElement we : list) {
				if (we.getText().trim().equalsIgnoreCase(sElementName)) {
					return we;
				}
			}
		}catch (Exception e) {
			System.out.println("Exception in getWebelementFromList " +e.getMessage());
		}
		return null;
	}
	
	/**
	 * This method returns true/false if the web element from the list matches the text.
	 * @param list
	 * @param sElementName
	 * @return
	 */
	public static boolean isWebelementExistInList(List<WebElement> list, String sElementName) {
		try {
			for (WebElement we : list) {
				if (we.getText().trim().equalsIgnoreCase(sElementName)) {
					return true;
				}
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * Get web element value using javascript. Applicable to type 'input' tag
	 * @param driver
	 * @param we
	 * @return
	 */
	public static String javascriptGetValueOfElement(WebElement we, WebDriver driver) {
		String sText = "";
		try {
			Thread.sleep(200);
			sText = ((JavascriptExecutor) driver).executeScript("return arguments[0].value;", we).toString();
			sText = sText.trim();
		} catch (Exception e) {
			System.out.println("Exception occured in javascriptGetValueOfElement " + e.getMessage());
		}
		return sText;
	}
	
	/**
	 * Set web element value using javascript. Applicable to type 'input' tag
	 * @param driver
	 * @param we
	 * @return
	 */
	public static void javascriptSetValueOfElement(WebElement we, WebDriver driver, String sText) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value='" +sText +"';", we);
		} catch (Exception e) {
			System.out.println("Exception occured in javascriptSetValueOfElement " + e.getMessage());
		}
	}
	
	/**
	 * Wait For web element to be visible. Timeout 15 Sec
	 * @param driver
	 * @param we
	 * @return
	 */
	public static void waitForElementToBeVisible(WebElement we, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOf(we));
		} catch (Exception e) {
			System.out.println("Exception occured in waitForElementToBeVisible " + e.getMessage());
		}
	}
	
	/**
	 * Uploads file using javascript
	 * @param File location
	 * @return
	 */
	public static void uploadFile(String fileLocation) {
		try {
			StringSelection stringSelection = new StringSelection(new File(fileLocation).getAbsolutePath());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			Thread.sleep(200);
			try{
				Runtime.getRuntime().exec("cmd /c ActivateFileUpload.vbs");
			}catch(Exception e){
			}
			Robot robot = new Robot();
			// Press CTRL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			try{
				Runtime.getRuntime().exec("cmd /c ActivateFileUpload.vbs");
			}catch(Exception e){
			}
			Thread.sleep(100);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(300);
		} catch (Exception e) {
			System.out.println("Exception in uploadFile " + e.getMessage());
		}
	}
}
