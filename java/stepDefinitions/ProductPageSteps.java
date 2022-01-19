package stepDefinitions;

import enums.Context;
import io.cucumber.java.en.*;
import managers.PageObjectManager;
import pageObjects.ProductPage;
import utilities.TestContext;

public class ProductPageSteps {

	public ProductPage productPage;
	public PageObjectManager pageObjectManager;
	private TestContext testContext;
	private String expTitle;
	private String leastProd1;
	private String leastProd2;
	
	public ProductPageSteps(TestContext context) {
		testContext = context;
		productPage = testContext.getPageObjectManager().getProductPage();
		expTitle = (String) testContext.scenarioContext.getValues(Context.PRODUCT);
		leastProd1 =(String) testContext.scenarioContext.getValues(Context.PRODSEARCH1);
		leastProd2 = (String) testContext.scenarioContext.getValues(Context.PRODSEARCH2);
		
	}
	
	@Then("I verify the corresponding product header displayed in the next page")
	public void i_verify_the_corresponding_product_header_displayed_in_the_next_page() {
		productPage.validateTitle(expTitle);
	}
	
	@Given("I add the least expensive product that contains \\(aloe & almond) or \\(spf-{int} & spf-{int}) based on the product page")
	public void i_add_the_least_expensive_product_that_contains_aloe_almond_or_spf_spf_based_on_the_product_page(Integer int1, Integer int2) {
		String[] prodDetails = productPage.addLeastProduct(leastProd1);
		testContext.scenarioContext.setValues(Context.PRODPRICE1, prodDetails[0]);
		testContext.scenarioContext.setValues(Context.PRODNAME1, prodDetails[1]);
		prodDetails = productPage.addLeastProduct(leastProd2);
		testContext.scenarioContext.setValues(Context.PRODPRICE2, prodDetails[0]);
		testContext.scenarioContext.setValues(Context.PRODNAME2, prodDetails[1]);
	}

	@When("I click on Cart Items button")
	public void i_click_on_cart_items_button() {
		productPage.clickCartButton();
	}
	
}
