package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		 (
			features = ".//Features/",
			glue = "stepDefinitions",
			dryRun = false,
			monochrome=true,
			strict = true,
			plugin = {"pretty","html:test-ouput"},
			tags = {"@regression"}			
		 )

public class TestRun {

}
