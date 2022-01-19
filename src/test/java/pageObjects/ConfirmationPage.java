package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.google.common.base.Verify;

import utilities.PageElements;

/****************************************************************************************************
 * @author Surya
 * 
 *         This class includes validation methods to be performed in
 *         Confirmation page
 *
 **************************************************************************************************/
public class ConfirmationPage {

	private WebDriver driver;

	public ConfirmationPage(WebDriver remoteDriver) {
		driver = remoteDriver;
	}

	/************************************************************************************************************************
	 * Description: This method is to validate the Payment status and the
	 * corresponding message Return: None Parameters: ExpectedStatus (String),
	 * ExpectedMsg (String)
	 ***********************************************************************************************************************/
	public void validatePaymentStatus(String expStatus, String expMsg) {
		String actualStatus = driver.findElement(By.xpath(PageElements.PAYMENT_STATUS)).getText();
		String actualMsg = driver.findElement(By.xpath(PageElements.PAYMENT_MSG)).getText();
		if (actualStatus.equals(expStatus)) {
			Verify.verify(true);
		} else {
			Verify.verify(false, "Payment Status shows as failed");
		}
		if (actualMsg.equals(expMsg)) {
			Verify.verify(true);
		} else {
			Verify.verify(false, "Payment message shows as failure");
		}
	}

}
