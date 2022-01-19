package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.PageElements;

/****************************************************************************************************
 * @author Surya
 * This class includes all the action methods of Front page
 *
 ***************************************************************************************************/

public class FrontPage {

	private WebDriver driver;

	public FrontPage(WebDriver RemoteDriver) {
		driver = RemoteDriver;
	}

	/************************************************************************************************************************
	 * Description: This method is validate the temperature value and return the
	 * selected product. Return: productSelected (String) Parameters: None
	 ************************************************************************************************************************/
	public int validateTemperature() {
		String text = driver.findElement(By.xpath(PageElements.CURRENT_TEMPERATURE)).getText().replaceAll("[^0-9]",
				"");
		int temp = Integer.parseInt(text);
		return temp;
	}


	/*************************************************************************************************************************
	 * Description: This method is to click on buy button based on the initialized
	 * value from the above methods Return type: None Parameters: None
	 *************************************************************************************************************************/
	public void clickBuyButton(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

}
