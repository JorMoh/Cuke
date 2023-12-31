package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html", "json:Reports/jsonReport.json"},
		glue = "step_definitions",
		features ="./src/test/resources/Features/CraterFeatures",
		tags = "@regression",
		dryRun = false,
		publish = true
		)
public class Runner {

}
