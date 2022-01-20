package parallel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.TestContext;

public class Hooks {

	private TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps() {
		testContext.getWebDriverManager().openUrl();
	}

	@After(order = 1)
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			testContext.getScreenshot().embedScreenshot(scenario);
			testContext.getScreenshot().takeScreenshot(scenario.getName());
		}
	}

	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}

}
