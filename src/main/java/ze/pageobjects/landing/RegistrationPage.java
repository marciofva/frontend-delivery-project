package ze.pageobjects.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ze.base.AbstractPage;

public class RegistrationPage extends AbstractPage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	// Elements on screen
	By nameLocator = By.name("name");
	By lastNameLocator = By.name("lastname");
	By documentLocator = By.name("document");
	By birthdateLocator = By.name("birthdate");
	By phoneLocator = By.name("phone");
	By emailLocator = By.name("email");
	By repeatEmailLocator = By.name("repeatEmail");
	By passwordEmailLocator = By.name("password");


	/**
	 * Method to input a name value
	 * @param name
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysname(String name) throws Throwable {
		sendKeys(nameLocator, name);
		return this;		
	}
	
	/**
	 * Method to input a lastname value
	 * @param lastname
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeyslastname(String lastname) throws Throwable {
		sendKeys(lastNameLocator, lastname);
		return this;		
	}
	
	/**
	 * Method to input name a document value, for instance: CPF
	 * @param doc
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysdocument(String doc) throws Throwable {
		sendKeys(documentLocator, doc);
		return this;		
	}
	
	/**
	 * Method to input a birth date value in format DD/MM/YYYY
	 * @param birth
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysbirthdate(String birth) throws Throwable {
		sendKeys(birthdateLocator, birth);
		return this;		
	}
	
	/**
	 * Method to input a phone value in format (99)99999-9999
	 * @param phone
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysphone(String phone) throws Throwable {
		sendKeys(phoneLocator, phone);
		return this;		
	}
	
	/**
	 * Method to input an e-mail value in valid format
	 * @param email
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysemail(String email) throws Throwable {
		sendKeys(emailLocator, email);
		return this;		
	}
	
	/**
	 * Method to input a repeat e-mail value in valid format
	 * @param repeatEmail
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeysrepeatEmail(String repeatEmail) throws Throwable {
		sendKeys(repeatEmailLocator, repeatEmail);
		return this;		
	}
	
	/**
	 * Method to input a password value containing 6 long characters at least
	 * @param password
	 * @return
	 * @throws Throwable
	 */
	public RegistrationPage sendKeyspassword(String password) throws Throwable {
		sendKeys(passwordEmailLocator, password);
		return this;		
	}


}
