package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features", 
glue = { "stepDef" , "hooks" }, 
plugin = { "pretty",
		"html:target\\CucumberReports\\index.html","json:target\\CucumberReports\\index.json","junit:target\\CucumberReports\\index.xml" } 
//,tags = "@TC_03"
)
public class TestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
