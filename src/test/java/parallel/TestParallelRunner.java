package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/parallel" }, // the path of the future files///BuyProducts.feature
		glue = { "parallel" }, // the path of the step definition files
		dryRun = false, // to check mapping is proper bw step def and feature file
		monochrome = true, // to display the console output in the proper readable format
		plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})

public class TestParallelRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
