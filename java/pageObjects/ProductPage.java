package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Verify;

import utilities.PageElements;

/****************************************************************************************************
 * @author Surya
 * This class includes all the action methods and validation methods to be performed in Product page
 *
 **************************************************************************************************/

public class ProductPage {

	private WebDriver driver;

	public ProductPage(WebDriver RemoteDriver) {
		driver = RemoteDriver;
	}

	/************************************************************************************************************************
	 * Description: This method is validate the header displayed in the Product page
	 * Return: None Parameters: expectedTitle (String)
	 ***********************************************************************************************************************/
	public void validateTitle(String expTitle) {
		String actualTitle = driver.findElement(By.xpath(PageElements.PRODUCTS_TITLE)).getText();
		Verify.verify(true,"Title not matched",actualTitle, expTitle);
	}

	/************************************************************************************************************************
	 * Description: This method is add the least expensive product based on the
	 * search txt Return: Price, ProdName (String[]) Parameters: searchText (String)
	 ***********************************************************************************************************************/
	public String[] addLeastProduct(String srchTxt) {
		String[] prodValues = new String[2];
		prodValues[0] = this.getLeastPrice(srchTxt);
		prodValues[1] = this.getProductName(srchTxt, prodValues[0]);
		this.clickAddButton(prodValues[1]);
		return prodValues;
	}

	/************************************************************************************************************************
	 * Description: This method is get the least expensive product price based on
	 * the search txt Return: min Price(String) Parameters: searchText (String)
	 ***********************************************************************************************************************/
	private String getLeastPrice(String srchTxt) {
		String locator = PageElements.GET_PRICES_XPATH_OPEN + srchTxt + PageElements.GET_PRICES_XPATH_CLOSE;
		String minPrice;
		int price;
		String temp;
		List<Integer> prices = new ArrayList<Integer>();
		List<WebElement> text = driver.findElements(By.xpath(locator));
		for (int i = 0; i < text.size(); i++) {
			temp = text.get(i).getText().replaceAll("[^0-9]", "");
			price = Integer.parseInt(temp);
			prices.add(price);
		}
		minPrice = Collections.min(prices) + "";
		return minPrice;
	}

	/************************************************************************************************************************
	 * Description: This method is get the product name based on the search txt and
	 * price Return: product Name(String) Parameters: searchText (String), price
	 * (String)
	 ***********************************************************************************************************************/
	private String getProductName(String srchTxt, String price) {
		String locator = PageElements.GET_PROD_NAME_XPATH_OPEN + price + PageElements.GET_PROD_NAME_XPATH_MIDDLE
				+ srchTxt + PageElements.GET_PROD_NAME_XPATH_CLOSE;
		String prodName = driver.findElement(By.xpath(locator)).getText();
		return prodName;
	}

	/************************************************************************************************************************
	 * Description: This method is to click on the Add button of the product Return:
	 * None Parameters: product Name (String)
	 ***********************************************************************************************************************/
	private void clickAddButton(String prodName) {
		String locator = PageElements.ADD_BTN_XPATH_OPEN + prodName + PageElements.ADD_BTN_XPATH_CLOSE;
		driver.findElement(By.xpath(locator)).click();
	}

	/************************************************************************************************************************
	 * Description: This method is to click on Cart button Return: None Parameters:
	 * None
	 ***********************************************************************************************************************/
	public void clickCartButton() {
		driver.findElement(By.xpath(PageElements.GOTO_CART)).click();
	}

}
