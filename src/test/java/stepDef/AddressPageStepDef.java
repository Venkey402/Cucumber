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

public class AddressPageStepDef {
	
	AddressPage addressPage;
	TestContextSetup testContextSetup;
	
	public AddressPageStepDef(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;	
	}

	@Then("user selects the country {string}")
	public void user_selects_the_country(String country) {
		addressPage = new AddressPage(testContextSetup.driver);
		addressPage.selectCountry(country);
	}

	@Then("user accepts the agreement")
	public void user_accepts_the_agreement() {
		addressPage.selectAgreementCheckBox();
	}

	@Then("user proceeds with the order")
	public void user_proceeds_with_the_order() {
		addressPage.clickOnProceed();
	}

	@Then("user recieves {string} message")
	public void user_recieves_message(String successMessage) {
		addressPage.verifyOrderSuccessMessage(successMessage);
	}
}
