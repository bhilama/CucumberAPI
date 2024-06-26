package cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/",
		glue = {"stepdefinitions"},
		dryRun = false,
		plugin = {"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"})
public class TestngRunner extends AbstractTestNGCucumberTests {

}
