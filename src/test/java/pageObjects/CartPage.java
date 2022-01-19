package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Verify;

import testDatatypes.CardDetails;
import utilities.PageElements;

/****************************************************************************************************
 * @author Surya
 * 
 *         This class includes all the action methods and validation methods to
 *         be performed in Cart page
 * 
 **************************************************************************************************/

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver remoteDriver) {
		driver = remoteDriver;
	}

	/************************************************************************************************************************
	 * Description: This method is validate the header displayed in the Cart page
	 * Return: None Parameters: expectedTitle (String)
	 **********************************************************************************************************************/
	public void validateTitle() {
		String expTitle = "Checkout";
		String actualTitle = driver.findElement(By.xpath(PageElements.CHECKOUT_TITLE)).getText();
		Verify.verify(true, "Title mismatched", actualTitle, expTitle);
	}

	/************************************************************************************************************************
	 * Description: This method is verify the product name and price added gets
	 * displayed in the Cart page Return: None Parameters: Product Name, Price
	 * (String[])
	 **********************************************************************************************************************/
	public void validateAddedProducts(String prodName1, String price1) {
		String locator = PageElements.VALIDATE_ITEMS_PRICE_OPEN + prodName1 + PageElements.VALIDATE_ITEMS_PRICE_MIDDLE
				+ price1 + PageElements.VALIDATE_ITEM_PRICE_CLOSE;
		if (driver.findElement(By.xpath(locator)).isDisplayed()) {
			Verify.verify(true);
		} else {
			Verify.verify(false);
		}
	}

	/************************************************************************************************************************
	 * Description: This method is to validate and return the total price displayed
	 * as the sum of individual prices Return: totalPrice (int) Parameters: Price1
	 * (String), Price2 (String)
	 **********************************************************************************************************************/
	public int validateTotalPrice(String val1, String val2) {
		String[] totalVal = driver.findElement(By.xpath(PageElements.GET_TOTAL_PRICE)).getText().split(" ");
		int price1 = Integer.parseInt(val1);
		int price2 = Integer.parseInt(val2);
		int expectedPrice = price1 + price2;
		int totalPrice = Integer.parseInt(totalVal[2]);
		if (totalPrice == expectedPrice) {
			Verify.verify(true);
		} else {
			Verify.verify(false);
		}
		return totalPrice;

	}

	/************************************************************************************************************************
	 * Description: This method is to click on Pay with Card button Return: None
	 * Parameters: None
	 * 
	 **********************************************************************************************************************/
	public void clickOnPayWithCardButton() {
		driver.findElement(By.xpath(PageElements.PAY_BTN)).click();
	}

	/************************************************************************************************************************
	 * Description: This method is to navigate to the payment window Return: None
	 * Parameters: None
	 * 
	 **********************************************************************************************************************/
	public void paymentWindowNavigation() {
		driver.switchTo().frame(PageElements.FRAME_NAME);
	}

	/************************************************************************************************************************
	 * Description: This method is to get test data from Test mode Return:
	 * CardNumber(String) Parameters: None
	 **********************************************************************************************************************/
	public String getCardDataFromTestMode() {
		String cardNumber = null;
		driver.findElement(By.xpath(PageElements.TEST_MODE_BTN)).click();
		driver.switchTo().defaultContent();
		String mainWindow = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				cardNumber = driver.findElement(By.xpath(PageElements.CARD_NUMBER)).getText();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.switchTo().frame(PageElements.FRAME_NAME);
		return cardNumber;
	}

	/************************************************************************************************************************
	 * Description: This method is to validate the payment amount displayed in the
	 * button equals to the total price displayed in the Cart page Return: None
	 * Parameters: totalAmount (float)
	 **********************************************************************************************************************/
	public void validatePaymentAmount(float amount) {
		String actualTxt = driver.findElement(By.xpath(PageElements.AMOUNT_BTN)).getText();
		String expTxt = amount + "";
		if (actualTxt.contains(expTxt)) {
			Verify.verify(true);
		} else {
			Verify.verify(false);
		}
	}

	/************************************************************************************************************************
	 * Description: This method is to fill all the payment window fields Return:
	 * None Parameters: test data (String[]), cardNumber (String)
	 **********************************************************************************************************************/
	public void fillPaymentDetails(CardDetails cardDetails, String cardNumber) {
		Actions builder = new Actions(driver);
		WebElement cardField = driver.findElement(By.xpath(PageElements.CARD_FIELD));
		WebElement expField = driver.findElement(By.xpath(PageElements.EXP_FIELD));
		driver.findElement(By.xpath(PageElements.EMAIL_FIELD)).sendKeys(cardDetails.email);
		builder.click(cardField).sendKeys(cardNumber).build().perform();
		driver.findElement(By.xpath(PageElements.EXP_FIELD)).clear();
		builder.click(expField).sendKeys(cardDetails.expiry).build().perform();
		driver.findElement(By.xpath(PageElements.CVC_FIELD)).sendKeys(cardDetails.cvc);
		driver.findElement(By.xpath(PageElements.ZIP_FIELD)).sendKeys(cardDetails.zip);
	}

	/************************************************************************************************************************
	 * Description: This method is to click on Pay button and wait until the payment
	 * window is closed Return: None Parameters: None
	 * 
	 **********************************************************************************************************************/
	public void clickOnPayButton()  {
		driver.findElement(By.xpath(PageElements.AMOUNT_BTN)).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/************************************************************************************************************************
	 * Description: This method is to validate the payment window is  closed
	 * Return: None Parameters: None
	 * 
	 **********************************************************************************************************************/
	public void validatePaymentWindowClosed() {
		String failureMsg = "Payment submission failed. Known bug!";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean flag = driver.findElement(By.xpath(PageElements.AMOUNT_BTN)).getAttribute("style").contains("opacity: 0");
		if (flag) {
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PageElements.CONFIRMATION_PAGE_TITLE)));
		} else {
			Verify.verify(flag, failureMsg);
		}	
	}
	
}
