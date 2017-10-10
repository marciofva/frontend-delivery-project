package ze.base;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is aimed to handle the webdriver and has generic methods that can
 * be called by all pages
 * 
 * @author Marcio Fernando
 *
 */

public abstract class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WebElement element;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Method to enter values in the field
	 * @param locator
	 * @param value
	 */
	public void sendKeys(By locator, String value) {
		getUniqueElement(locator).clear();
		getUniqueElement(locator).sendKeys(value);
	}

	/**
	 * Method to get the element and wait for visibility 
	 * 
	 * @param element
	 *            which will be searched
	 * @return an WebElement only
	 */
	public WebElement getUniqueElement(By locator) {

		wait = new WebDriverWait(driver, 15);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	/**
	 * Method to check if the elements are visible
	 * 
	 * @param element
	 *            which will be searched
	 * @return a list of WebElements
	 */
	public List<WebElement> getManyElements(By locator) {

		return driver.findElements(locator);
	}
	

	/**
	 * Method to wait for visibility of element, if the element is not visible in
	 * that time, the method will throw an exception
	 * 
	 * @param element
	 *            which will be searched
	 * @return a WebElement
	 */
	public WebElement waitForElementVisibility(By locator) {

		wait = new WebDriverWait(driver, 15);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	/**
	 * Method to wait for the title of the page in order to ensure that is in the
	 * correct page before continuing
	 * 
	 * @param expectedTitle
	 */
	public void waitForTitle(String expectedTitle) {
		System.out.println("\n>>>>.... Searching for the page: " +  expectedTitle);

		wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
	

	/**
	 * Method to check if the element is present or not
	 * 
	 * @param element
	 *            which will be searched
	 * @return a boolean (true or false)
	 */
	public boolean isElementPresent(By locator) {

		try {
			driver.findElement(locator);
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
}
