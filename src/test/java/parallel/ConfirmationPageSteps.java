package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import managers.FileReaderManager;
import pageObjects.ConfirmationPage;
import utilities.TestContext;

public class ConfirmationPageSteps {

	public ConfirmationPage confirmationPage;
	private TestContext testContext;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("I validate the successful confirmation page with the data from given sheetName {string} and {int}")
	public void i_validate_the_successful_confirmation_page_with_the_data_from_given_sheet_name_and(String sheetName, int index) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> excelData;
		try {
			excelData = FileReaderManager.
					getInstance().
					getExcelReader().
					getData("./testDataResources/testData.xlsx", sheetName);
			String title = excelData.get(index).get("Title");
			String msg = excelData.get(index).get("Message");
			confirmationPage.validatePaymentStatus(title, msg);
		} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
