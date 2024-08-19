package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDef.TestContextSetup;

public class HomePage {
	ChromeDriver driver;

	public HomePage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input.search-keyword")
	WebElement txtSearch;

	@FindBy(css = "a.cart-icon")
	WebElement iconCart;

	@FindBy(xpath = "//*[text()='PROCEED TO CHECKOUT']")
	WebElement btnProceedToCheckout;

	public void clickOnProceedToCheckout() {
		btnProceedToCheckout.click();
	}

	public void clickOnCartIcon() {

		iconCart.click();
	}

	public void enterProductName(String productName) {
		txtSearch.clear();
		txtSearch.sendKeys(productName);
	}

	public void addToCart(String productName) {
		WebElement btnAddToCart = driver.findElement(By.xpath(
				"//*[@class='product-name'][contains(text(),'" + productName + "')]/..//button[text()='ADD TO CART']"));
		btnAddToCart.click();
	}
}
