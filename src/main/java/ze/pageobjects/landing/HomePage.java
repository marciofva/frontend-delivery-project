package ze.pageobjects.landing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ze.base.AbstractPage;

public class HomePage extends AbstractPage {

	// Elements on screen
	By age_yesLocator = By.cssSelector("#btn-age-yes");
	By age_noLocator = By.cssSelector(
			"#app > div > div > div > div.age-gate-container > div > div.row-buttons > div.btn-age.btn-no");
	By addressLocator = By.id("pacInput");
	By addressSugestionLocator = By.cssSelector(".pac-item");
	By numberaddressLocator = By.id("number-address");
	By complementaddressLocator = By.id("complement-address");
	By nextBtnLocator = By.id("btn-continue");
	By entrarLocator = By.cssSelector(".btn");
	By searchLocator = By.id("search-bar"); 

	private static final String TITLE_HOMEPAGE = "Zé Delivery de Bebidas";
	private static final String TITLE_AMBEV = "Consumo responsável - Ambev";

	public HomePage(WebDriver driver) {
		super(driver);  

		// Check if the page is correct (Home Page)
		if (!driver.getTitle().equals(TITLE_HOMEPAGE)) {
			throw new IllegalStateException("This is not the correct page");
		}
	}

	/**
	 * Method to answer the question positively
	 */
	public void ageQuestionYes() {
		getUniqueElement(age_yesLocator).click();
	}

	/**
	 * Method to answer the question negatively
	 */
	public void ageQuestionNo() {
		getUniqueElement(age_noLocator).click();
		System.out.println(">>> Waiting for loading Ambev Page.... >>> Checking if the page is correct.... >>>");
		waitForTitle(TITLE_AMBEV);
	}

	/**
	 * Method to set an address value and select a given suggestion
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public HomePage sendKeysaddress(String address) throws Throwable {
		sendKeys(addressLocator, address);
				
		// Get all address suggestions
		List<WebElement> addresses = getManyElements(addressSugestionLocator);
		Thread.sleep(5000);
		
		// choose the first one
		addresses.get(0).click();
		return this;
	}

	/**
	 * Method to set a number address
	 * @param number
	 * @return
	 * @throws Throwable
	 */
	public HomePage sendKeysnumber(String number) throws Throwable {
		sendKeys(numberaddressLocator, number);
		return this;
	}

	/**
	 * Method to set a complement address
	 * @param complement
	 * @return
	 * @throws Throwable
	 */
	public HomePage sendKeyscomplement(String complement) throws Throwable {
		sendKeys(complementaddressLocator, complement);
		return this;
	}

	/**
	 * Method to click on "Entrar" button so as to log into system
	 * @return
	 */
	public LoginPage clickOnEntrar() {
		getUniqueElement(entrarLocator).click();
		return new LoginPage(driver);
	}

	/**
	 * Method to validate the address and find a distributor in Product Page
	 */
	public void clickOnNextButton() {
		getUniqueElement(nextBtnLocator).click();
	}

	/**
	 * Method to verify if the user is really in Product Page
	 * @return
	 */
	public boolean productPageStatus() {
		return isElementPresent(searchLocator);
	}

}
