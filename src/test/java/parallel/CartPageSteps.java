package parallel;

import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.CartPage;
import testDatatypes.CardDetails;
import utilities.TestContext;

public class CartPageSteps {

	public CartPage cartPage;
	private TestContext testContext;
	private String prodName1;
	private String prodName2;
	private String price1;
	private String price2;
	private String cardNumber;
	private int totalPrice;
	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
		prodName1 =(String) testContext.scenarioContext.getValues(Context.PRODNAME1);
		prodName2 = (String) testContext.scenarioContext.getValues(Context.PRODNAME2);
		price1 =(String) testContext.scenarioContext.getValues(Context.PRODPRICE1);
		price2 = (String) testContext.scenarioContext.getValues(Context.PRODPRICE2);
	}
	
	@Then("I verify the corresponding Checkout header displayed in the next page")
	public void i_verify_the_corresponding_checkout_header_displayed_in_the_next_page() {
		cartPage.validateTitle();
	}

	@Then("I verify the two selected items and their prices are displayed")
	public void i_verify_the_two_selected_items_and_their_prices_are_displayed() {
		cartPage.validateAddedProducts(prodName1,price1);
		cartPage.validateAddedProducts(prodName2, price2);
	}

	@Then("I also validate the total price is displayed as expected")
	public void i_also_validate_the_total_price_is_displayed_as_expected() {
		totalPrice = cartPage.validateTotalPrice(price1, price2);
	}

	@When("I click on Pay with Card button")
	public void i_click_on_pay_with_card_button() {
		cartPage.clickOnPayWithCardButton();
	}

	@Then("the payment window should be displayed")
	public void the_payment_window_should_be_displayed() {
		cartPage.paymentWindowNavigation();
		
	}
	
	@Then("I get the test card number from seperate window")
	public void i_get_the_test_card_number_from_seperate_window() {
		 cardNumber = cartPage.getCardDataFromTestMode();
	}

	@Then("I enter the test data in the Email, Card number, Expiry, CVC and Zip code fields")
	public void i_enter_the_test_data_in_the_email_card_number_expiry_cvc_and_zip_code_fields() {
		CardDetails cardDetails = FileReaderManager.getInstance().getJsonReader("CardDetails").getCardDetails();
		cartPage.fillPaymentDetails(cardDetails, cardNumber);
	}

	@Then("I validate the same total price is displayed in the Pay button as well")
	public void i_validate_the_same_total_price_is_displayed_in_the_pay_button_as_well() {
		cartPage.validatePaymentAmount(totalPrice);
	}

	@When("I click on Pay button")
	public void i_click_on_pay_button() {
		cartPage.clickOnPayButton();
	}

	@Then("the payment window should be closed automatically after few seconds")
	public void the_payment_window_should_be_closed_automatically_after_few_seconds() {
		cartPage.validatePaymentWindowClosed();
	}


}
