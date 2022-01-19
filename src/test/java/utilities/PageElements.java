package utilities;

public class PageElements {
	// FrontPage WebElements
	public static final String CURRENT_TEMPERATURE = "//span[@id='temperature']";
	public static final String BUY_MOISTURIZER_BTN = "//a[@href='/moisturizer']/button";
	public static final String BUY_SUNSCREEN_BTN = "//a[@href='/sunscreen']/button";

	// ProductsPage WebElements
	public static final String GOTO_CART = "//button[@onclick='goToCart()']";
	public static final String CART_BUTTON_TXT = "//span[@id='cart']";
	public static final String PRODUCTS_TITLE = "//h2";
	private static final String TRANSLATE = "(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'";
	public static final String GET_PRICES_XPATH_OPEN = "//p[contains" + TRANSLATE;
	public static final String GET_PRICES_XPATH_CLOSE = "')]/following-sibling::p";
	public static final String GET_PROD_NAME_XPATH_OPEN = "//p[contains(text(),'";
	public static final String GET_PROD_NAME_XPATH_MIDDLE = "')]/preceding-sibling::p[contains" + TRANSLATE;
	public static final String GET_PROD_NAME_XPATH_CLOSE = "')]";
	public static final String ADD_BTN_XPATH_OPEN = "//button[contains(@onclick,'";
	public static final String ADD_BTN_XPATH_CLOSE = "')]";

	// CartPage WebElements
	public static final String CHECKOUT_TITLE = "//h2";
	public static final String VALIDATE_ITEMS_PRICE_OPEN = "//td[text()='";
	public static final String VALIDATE_ITEMS_PRICE_MIDDLE = "']/following-sibling::td[text()='";
	public static final String VALIDATE_ITEM_PRICE_CLOSE = "']";
	public static final String GET_TOTAL_PRICE = "//p[@id='total']";
	public static final String PAY_BTN = "//button[@type='submit']";

	// Paymentwindow elements
	public static final String FRAME_NAME = "stripe_checkout_app";
	public static final String TEST_MODE_BTN = "//a[@class='testMode']";
	public static final String EMAIL_FIELD = "//input[@id='email']";
	public static final String CARD_FIELD = "//input[@id='card_number']";
	public static final String EXP_FIELD = "//input[@id='cc-exp']";
	public static final String CVC_FIELD = "//input[@id='cc-csc']";
	public static final String ZIP_FIELD = "//input[@id='billing-zip']";
	public static final String AMOUNT_BTN = "//button//span[@class='iconTick']";

	// StripeDocs Elements
	public static final String CARD_NUMBER = "//span[@class='CardNumber']";
	
	// confirmationPage elements
	public static final String CONFIRMATION_PAGE_TITLE = "//html//title[text()='Confirmation']";
	public static final String PAYMENT_STATUS = "//h2";
	public static final String PAYMENT_MSG = "//p[@class='text-justify']";
}
