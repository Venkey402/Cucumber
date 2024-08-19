package stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddressPage;
import pageObjects.HomePage;
import pageObjects.OrderPage;

public class OrderPageStepDef {	
	OrderPage orderPage;
	TestContextSetup testContextSetup;
	
	public OrderPageStepDef(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}

	@Then("user verifies the product name from order page")
	public void user_verifies_the_product_name_from_ordre_page() {
		orderPage = new OrderPage(testContextSetup.driver);
		String actualProductname = orderPage.getProductName();
		Assert.assertTrue(actualProductname.contains(testContextSetup.productName));
	}

	@When("user places the order")
	public void user_places_the_order() {
		orderPage.clickOnPlaceOrder();
	}
}
