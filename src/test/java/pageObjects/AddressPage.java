package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddressPage {
	ChromeDriver driver;

	public AddressPage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "select")
	WebElement drpCountry ;
	
	@FindBy(css = ".chkAgree")
	WebElement chkAgree ;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement btnProceed ;

	public void selectCountry(String country) {
		
		Select select = new Select(drpCountry);
		select.selectByValue(country);
	}
	
	public void selectAgreementCheckBox() {
		chkAgree.click();
	}

	public void verifyOrderSuccessMessage(String message) {
		WebElement lblOrderSuccessful = driver
				.findElement(By.xpath("//*[contains(text(),'"+message+"')]"));
		boolean isSuccess = lblOrderSuccessful.isDisplayed();
		Assert.assertTrue(isSuccess);
	}
	
	public void clickOnProceed() {
		btnProceed.click();
	}
	
}
