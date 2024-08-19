package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features\\failed.txt", 
glue = { "stepDef" , "hooks" }, 
plugin = { "pretty",
		"html:target\\CucumberReports\\index.html",
		"json:target\\CucumberReports\\index.json",
		"junit:target\\CucumberReports\\index.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:src\\test\\java\\features\\failed.txt"} 
//,tags = "@TC_03"

)
public class TestRunner_failedRun extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
