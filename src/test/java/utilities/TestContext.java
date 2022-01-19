package utilities;

import managers.PageObjectManager;
import managers.DriverManager;

public class TestContext {
	private PageObjectManager pageObjectManager;
	private DriverManager webDriverManager;
	public ScenarioContext scenarioContext;
	private Screenshot screenshot;
	
	public TestContext() {
		webDriverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
		screenshot = new Screenshot(webDriverManager.getDriver());
	}

	public DriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public Screenshot getScreenshot() {
		return screenshot;
	}
}
