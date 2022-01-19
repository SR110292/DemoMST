package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}

}
