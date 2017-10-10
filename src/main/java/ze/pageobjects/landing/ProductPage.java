package ze.pageobjects.landing;

import java.text.DecimalFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ze.base.AbstractPage;

public class ProductPage extends AbstractPage {

	// Elements on screen
	By dropdownSelectionLocator = By.cssSelector(".user-dropdown-select");
	By searchLocator = By.id("search-bar");
	By productContanierLocator = By.cssSelector(".product-card.display-flex.column.flex");
	By decreaseBtnLocator = By
			.cssSelector(".user-square-btn.font-size-30.clickable.display-flex.noselect.border-1.red-border.red-font");
	By increaseBtnLocator = By.cssSelector(".user-square-btn.font-size-30.clickable.display-flex.noselect.yellow-bg");
	By singlePriceLocator = By.cssSelector("div:nth-child(1) > div:nth-child(4) > span:nth-child(2)");
	By totalPriceLocator = By.cssSelector(".products-cart-price");
	By totalPriceCentsLocator = By.cssSelector(".products-cart-cents");
	By pinChangeAddressLocator = By.cssSelector("#address-b > div");

	private DecimalFormat decimalFormat = new DecimalFormat("######0.00");
	private double total = 0.0; 

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to select an option in dropdown
	 * 
	 * @param value
	 * @throws Throwable
	 */
	public void selectDropDown(String value) throws Throwable {
		Select oSelect = new Select(getUniqueElement(dropdownSelectionLocator));
		oSelect.selectByVisibleText(value);
		Thread.sleep(15000);
	}

	/**
	 * Method to count the quantity of products that is listed in the page
	 * 
	 * @return Total price which is calculated at runtime
	 */
	public Integer getCountProducts() {
		return getManyElements(productContanierLocator).size();
	}

	/**
	 * Method to click on Add button for all products in screen
	 * @return sum of the price in the format 0.00
	 * @throws Throwable
	 */
	public double clickOnIncreaseBtn() throws Throwable {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < getCountProducts(); i++) {

			js.executeScript("arguments[0].click();", getManyElements(increaseBtnLocator).get(i));

			String valueStr = getManyElements(singlePriceLocator).get(i).getText();
			double valueDouble = Double.parseDouble(valueStr.replace(",", "."));
			total += valueDouble;

			Thread.sleep(5000); 
		}

		String numberAsString = decimalFormat.format(total);
		return Double.parseDouble(numberAsString);
	}

	/**
	 * Method to get the Total Price that is in the footer
	 * 
	 * @return Total Price that is calculated by the system
	 */
	public double getTotalPrice() {
		String totalPriceStr = getUniqueElement(totalPriceLocator).getText()
				+ getUniqueElement(totalPriceCentsLocator).getText();
		return Double.parseDouble(totalPriceStr.replace(",", "."));
	}

	/**
	 * Method to click on Pin icon so as to return back to Home Page
	 * 
	 * @return
	 */
	public HomePage clickOnPinToChangeAddress() {
		getUniqueElement(pinChangeAddressLocator);
		return new HomePage(driver);
	}
}
