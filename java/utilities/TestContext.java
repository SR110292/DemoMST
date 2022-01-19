package utilities;

import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
	private PageObjectManager pageObjectManager;
	private WebDriverManager webDriverManager;
	public ScenarioContext scenarioContext;
	
	public TestContext() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
}
