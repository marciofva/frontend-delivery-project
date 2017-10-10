package ze.testcases;

import org.junit.Test;

import ze.pageobjects.landing.LoginPage;
import ze.pageobjects.landing.RegistrationPage;

public class RegistrationTest extends Hooks {

	private LoginPage login;
	private RegistrationPage register;

	// ***************************************************************************
	// * Register a new user passing all valid data
	// ***************************************************************************
	@Test 
	public void should_register_the_user() throws Throwable {
		System.out.println(">>> TEST CASE (Registration Page) - should_register_the_user");

		// Age question => YES 
		home.ageQuestionYes();

		login = home.clickOnEntrar();

		register = login.clickOnNextButton();

		register.sendKeysname("Joao").sendKeyslastname("Silva").sendKeysdocument("12345678901")
				.sendKeysbirthdate("08/05/1990").sendKeysphone("1199999-0102").sendKeysemail("joao@test.com")
				.sendKeysrepeatEmail("joao@test.com").sendKeyspassword("12345abcd0");
	}
}
