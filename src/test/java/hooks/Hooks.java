package hooks;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDef.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	Logger logger;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		testContextSetup.logger = Logger.getLogger("Cucumber");
		logger = testContextSetup.logger;
		PropertyConfigurator.configure("log4j.properties");
	}

	@Before
	public void beforeScenario() {

		WebDriverManager.chromedriver().setup();
		logger.info("Chrome driver setup is done");
		testContextSetup.driver = new ChromeDriver();
		logger.info("Chrome browser is opened");
		testContextSetup.driver.manage().window().maximize();
		logger.info("Browser window maximized");

		testContextSetup.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger.info("Page load timeout is set to 10 secs");
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Implicit timeout is set to 10 secs");
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		logger.info("Url is opened");
	}

	@After
	public void afterScenario() {
		testContextSetup.driver.quit();
		logger.info("Browser instance is quitted");
	}

}
