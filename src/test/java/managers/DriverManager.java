package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProviders.ConfigFileReader;
import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	public ConfigFileReader fileReader = FileReaderManager.getInstance().getConfigReader();

	public DriverManager() {
		driverType = fileReader.getBrowser();
		environmentType = fileReader.getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		
		switch (driverType) {
		case FIREFOX:
/*			System.setProperty(FIREFOX_DRIVER_PROPERTY,
					fileReader.getDriverPath("geckoPath"));*/
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME:
			/*System.setProperty(CHROME_DRIVER_PROPERTY,
					fileReader.getDriverPath("chromePath"));*/
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case EDGE:
			/*System.setProperty(EDGE_DRIVER_PROPERTY,
					fileReader.getDriverPath("edgePath"));*/
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}
	
	public void openUrl() {
		driver.get(fileReader.getApplicationUrl());
	}

	public void closeDriver() {
		driver.quit();
	}

}
