package ze.pageobjects.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ze.base.AbstractPage;

public class AddressOutOfAreaPage extends AbstractPage{

	public AddressOutOfAreaPage(WebDriver driver) {
		super(driver);
	} 
	  
	// Elements on screen
	By emailLocator 			= By.id("newsletter-email");
	By errorMsgLocator 		= By.cssSelector(".error-message-email");
	By successMsgLocator 	= By.cssSelector("div.initial-call:nth-child(2) > div:nth-child(1)");
	By sendBtnLocator 		= By.cssSelector("#btn-send");

	public boolean statusPage() {
		return isElementPresent(sendBtnLocator);
	}
	
	public String getErrorMessage() {
		return getUniqueElement(errorMsgLocator).getText();
	}
	
	public String getSuccessMessage() {
		return getManyElements(successMsgLocator).get(0).getText();
	}
	
	public AddressOutOfAreaPage sendKeysemail(String email)  {
		sendKeys(emailLocator, email);
		return this;		
	}
	
	public void clickOnSendBtn() {
		getUniqueElement(sendBtnLocator).click();
	}
}
