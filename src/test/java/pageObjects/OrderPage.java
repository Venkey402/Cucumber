package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	ChromeDriver driver;

	public OrderPage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "p.product-name")
	WebElement lblProductName;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement btnPlaceOrder;

	public String getProductName() {

		return lblProductName.getText();
	}

	public void clickOnPlaceOrder() {

		btnPlaceOrder.click();
	}

}
