package ze.testcases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import ze.pageobjects.landing.LoginPage;

public class LoginTest extends Hooks {

	// private HomePage home;
	private LoginPage login;

	// ***************************************************************************
	// * Enter an invalid credentials
	// ***************************************************************************
	@Test
	public void should_not_login() {
		System.out.println(">>> TEST CASE (Login Page) - should_not_login");

		home.ageQuestionYes();

		login = home.clickOnEntrar();
		login.sendKeysemail("testes@test.com").sendKeyspassword("233453gf").clickOnEntrar();

		assertThat("Login Page", login.getErrorMsg(), is(equalTo("Usuário não encotrado")));
	}
}
