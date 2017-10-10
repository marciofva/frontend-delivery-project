package ze.testcases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Random;

import org.junit.Test;

import ze.pageobjects.landing.AddressOutOfAreaPage;

public class AddressOutOfAreaTest extends Hooks {

	private AddressOutOfAreaPage addressOut;
	private String address, number, complement;
	private int randomNum = 0;

	// ***************************************************************************
	// * Enter a valid e-mail
	// ***************************************************************************
	@Test
	public void enterValidEmail() throws Throwable {
		System.out.println(">>> TEST CASE (Address Out Of Area Page) - enterValidEmail");

		setOutOfAddress();

		home.ageQuestionYes();

		home.sendKeysaddress(address).sendKeysnumber(number).sendKeyscomplement(complement);
		home.clickOnNextButton();

		addressOut = new AddressOutOfAreaPage(driver);

		assertThat("Address out of area Page", true, is(equalTo(addressOut.statusPage())));

		addressOut.sendKeysemail("test@test.com");
		addressOut.clickOnSendBtn();
		Thread.sleep(5000);

		assertThat("Correct e-mail", addressOut.getSuccessMessage(), is(equalTo("Obrigado!")));
	}

	// ***************************************************************************
	// * Enter an invalid e-mail
	// ***************************************************************************
	@Test
	public void enterInvalidEmail() throws Throwable {
		System.out.println(">>> TEST CASE (Address Out Of Area) - enterInvalidEmail");

		setOutOfAddress();

		home.ageQuestionYes();

		home.sendKeysaddress(address).sendKeysnumber(number).sendKeyscomplement(complement);
		home.clickOnNextButton();

		addressOut = new AddressOutOfAreaPage(driver);

		assertThat("Address out of area Page", true, is(equalTo(addressOut.statusPage())));

		addressOut.sendKeysemail("test@@").clickOnSendBtn();
		Thread.sleep(5000);

		assertThat("Wrong e-mail", addressOut.getErrorMessage(), is(equalTo("Ops! E-mail incorreto.")));
	}

	public void setOutOfAddress() {

		// Generate a random value to input in address
		Random rand = new Random();
		randomNum = rand.nextInt((800 - 300) + 1) + 800;

		// Set address data
		address = "Rua Cláudio Batista, " + randomNum + " Santo Antônio, Aracaju";
		number = Integer.toString(randomNum);
		complement = "Casa";
	}
}
