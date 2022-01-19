package stepDefinitions;

import enums.Context;
import io.cucumber.java.en.*;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.FrontPage;
import utilities.PageElements;
import utilities.TestContext;

public class FrontPageSteps {

	public FrontPage frontPage;
	public WebDriverManager webDriverManager;
	public PageObjectManager pageObjectManager;
	private TestContext testContext;
	
	public FrontPageSteps(TestContext context) {
		testContext = context;
		frontPage = testContext.getPageObjectManager().getFrontPage();
	}
	
	@Given("I verify the Current temperature is displayed with values")
	public void i_verify_the_current_temperature_is_displayed_with_values() {
		int temp= frontPage.validateTemperature();
		testContext.scenarioContext.setValues(Context.TEMPERATURE, temp);
		if (temp > 34) {
			testContext.scenarioContext.setValues(Context.LOCATOR, PageElements.BUY_SUNSCREEN_BTN);
			testContext.scenarioContext.setValues(Context.PRODUCT, "Sunscreens");
			testContext.scenarioContext.setValues(Context.PRODSEARCH1, "spf-50");
			testContext.scenarioContext.setValues(Context.PRODSEARCH2, "spf-30");
		} else if (temp < 19) {
			testContext.scenarioContext.setValues(Context.LOCATOR, PageElements.BUY_MOISTURIZER_BTN);
			testContext.scenarioContext.setValues(Context.PRODUCT, "Moisturizers");
			testContext.scenarioContext.setValues(Context.PRODSEARCH1, "aloe");
			testContext.scenarioContext.setValues(Context.PRODSEARCH2, "almond");
		}
	}
	
	@Given("I click on the buy button \\(moisturizers or sunscreens) based on the temperature")
	public void i_click_on_the_buy_button_moisturizers_or_sunscreens_based_on_the_temperature() {
		String locator = (String) testContext.scenarioContext.getValues(Context.LOCATOR);
		frontPage.clickBuyButton(locator);
	}

}
