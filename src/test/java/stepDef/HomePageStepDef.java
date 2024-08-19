package stepDef;

import java.time.Duration;

import org.apache.log4j.Logger;
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

public class HomePageStepDef  {
	HomePage homePage;
	TestContextSetup testContextSetup;
	Logger logger ;

	public HomePageStepDef(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		logger = this.testContextSetup.logger;
	}

	@Given("user launches the greenkart application")
	public void user_launches_the_greenkart_application() {

	}

	@When("user searches for {string} and adds to cart")
	public void user_searches_for_and_adds_to_cart(String productName) {
		testContextSetup.productName = productName;
		homePage = new HomePage(testContextSetup.driver);
		logger.info("Homepage object got created");
		homePage.enterProductName(testContextSetup.productName);
	}

	@Then("user checks product with name {string} added to the cart")
	public void user_checks_product_with_name_added_to_the_cart(String productName) {
		homePage.addToCart(testContextSetup.productName);
	}

	@When("user checksout the products added to cart")
	public void user_checksout_the_products_added_to_cart() {
		homePage.clickOnCartIcon();
		homePage.clickOnProceedToCheckout();
	}

}
