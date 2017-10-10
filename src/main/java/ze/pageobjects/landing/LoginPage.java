package ze.pageobjects.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import ze.base.AbstractPage;

public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	} 

	// Elements on screen
	By emailLocator = By.cssSelector("input.user-text-input:nth-child(2)");
	By passwordLocator = By.cssSelector("input.user-text-input:nth-child(1)");
	By entrarBtnLocator = By.cssSelector(".yellow-bg");
	By registerBtnLocator = By.cssSelector(".white-bg-border");
	By popupBtnLocator = By.cssSelector(".action-button");
	By popupMsgLocator = By.cssSelector(".body > p:nth-child(1)");

 
	/**
	 * Method to click on "AINDA NÃO POSSUI LOGIN?  FAZER CADASTRO" button so as to register in the system
	 * @return
	 */
	public RegistrationPage clickOnNextButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getUniqueElement(registerBtnLocator));
		return new RegistrationPage(driver);
	}
	
	/**
	 * Method to enter an email
	 * @param email
	 * @return
	 */
	public LoginPage sendKeysemail(String email)  {
		sendKeys(emailLocator, email);
		return this;		
	}
	
	/**
	 * Method to enter a password
	 * @param password
	 * @return
	 */
	public LoginPage sendKeyspassword(String password)  {
		sendKeys(passwordLocator, password);
		return this;		
	}
	
	/**
	 * Method to click on "Entrar" button to log into the system
	 */
	public void clickOnEntrar() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", getUniqueElement(entrarBtnLocator));
	}
	
	/**
	 * Method to get the error message when entered a non-existent email
	 * @return
	 */
	public String getErrorMsg() {
		return getUniqueElement(popupMsgLocator).getText();
	}

}
