package testRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "./features" }, // the path of the future files///BuyProducts.feature
		glue = { "stepDefinitions" }, // the path of the step definition files
		dryRun = false, // to check mapping is proper bw step def and feature file
		monochrome = true, // to display the console output in the proper readable format
		plugin = { "pretty", 
				/*"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"*/
				"html:./cucumber-output/htmlOutput.html",
				"json:./cucumber-output/jsonOutput.json",
				"junit:./cucumber-output/xmlOutput.xml"
				})
public class TestRun {

}
