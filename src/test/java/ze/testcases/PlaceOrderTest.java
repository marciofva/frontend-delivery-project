package ze.testcases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Random;
import org.junit.Test;
import ze.pageobjects.landing.ProductPage;

public class PlaceOrderTest extends Hooks {

	private ProductPage product;
	private String address, number, complement;
	private int randomNum = 0;
	private Double expectedPrice = 0.0, actualPrice = 0.0;

	// ************* **************************************************************
	// * User under the age of 18 ==> Should go to Ambev webpage
	// ***************************************************************************
	@Test
	public void should_be_under18() {
		System.out.println(">>> TEST CASE (Product Page) - should_be_under18");

		// Age question => NO
		home.ageQuestionNo(); 
	} 
 
	// ***************************************************************************
	// * Search for Products throught dropdown <"Para festas & churrascos">
	// ***************************************************************************
	@Test
	public void validateProductList_festa_churrasco() throws Throwable {
		System.out.println(">>> TEST CASE (Product Page) - validateProductList_festa_churrasco");

		manipulate_HomePage(); 

		product = new ProductPage(driver);

		// Check if Product Page is available
		assertThat("Distributor is available?", home.productPageStatus(), is(equalTo(true)));

		// Set a category in dropdown
		product.selectDropDown("Para festas & churrascos");

		expectedPrice = product.clickOnIncreaseBtn();
		actualPrice = product.getTotalPrice();

		// Validate the total price
		assertThat("Total Price", actualPrice, is(equalTo(expectedPrice)));
	}

	// ***************************************************************************
	// * Search for Products throught dropdown <"Não Alcóolicos">
	// ***************************************************************************
	@Test
	public void validateProductList_NaoAlcoolicos() throws Throwable {
		System.out.println(">>> TEST CASE (Product Page) - validateProductList_NaoAlcoolicos");

		manipulate_HomePage();

		product = new ProductPage(driver);

		// Check if Product Page is available
		assertThat("Distributor is available?", home.productPageStatus(), is(equalTo(true)));

		// Set a category in dropdown
		product.selectDropDown("Não Alcóolicos");

		expectedPrice = product.clickOnIncreaseBtn();
		actualPrice = product.getTotalPrice();

		// Validate the total price
		assertThat("Total Price", actualPrice, is(equalTo(expectedPrice)));
	}

	/**
	 * Method to input address data in the fields
	 * 
	 * @throws Throwable
	 */
	public void manipulate_HomePage() throws Throwable {

		setValidAddress();
 
		// Age question => YES
		home.ageQuestionYes();

		// Fill the address data up
		home.sendKeysaddress(address).sendKeysnumber(number).sendKeyscomplement(complement);
		home.clickOnNextButton();
	}

	/**
	 * Method to set address data in home page
	 */
	public void setValidAddress() { 

		// Generate a random value to input in address
		Random rand = new Random();
		randomNum = rand.nextInt((2000 - 500) + 1) + 500;
 
		// Set address data
		address = "Avenida Paulista, " + randomNum + " - Bela Vista, São Paulo";
		number = Integer.toString(randomNum);
		complement = "Apartamento 243";
	}
}
