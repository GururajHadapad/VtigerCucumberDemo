package VtigerRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {".\\src\\test\\java\\Features"},
		glue = {"StepDefinationsAndHooksClasses"},
		dryRun = false,
		monochrome = true,
		tags = "",
		plugin = {
				"pretty",
				"html:VtigerCucumber.html",
				"json:VtigerCucumber.json"
		}
		
		)


public class Runner extends AbstractTestNGCucumberTests{

}
