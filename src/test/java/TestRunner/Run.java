package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/LoginFeature.feature",
		glue = "StepDefinition",
		plugin = {"pretty", "html:target/cucumber-reports/reports.html"},
		dryRun = false,
		monochrome = true
		)

public class Run {

	/* This will be empty class */
	
}
