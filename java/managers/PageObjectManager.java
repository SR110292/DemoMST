package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.ConfirmationPage;
import pageObjects.FrontPage;
import pageObjects.ProductPage;

public class PageObjectManager {
	private WebDriver driver;
	private FrontPage frontPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private ConfirmationPage confirmationPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public FrontPage getFrontPage() {

		return (frontPage == null) ? frontPage = new FrontPage(driver) : frontPage;

	}

	public ProductPage getProductPage() {

		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;

	}
	
	public CartPage getCartPage() {

		return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;

	}
	
	public ConfirmationPage getConfirmationPage() {

		return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;

	}
}
