package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

/****************************************************************************************************
 * @author Surya
 * 
 * This class serves us to take the screenshot whenever whenever being called
 *
 ***************************************************************************************************/

public class Screenshot {

	private WebDriver driver;
	
	public Screenshot(WebDriver RemoteDriver) {
		driver = RemoteDriver;
	}
	public void takeScreenshot(String folder, String name) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/"+folder+"/"+name+".png");	
		try {
			FileUtils.copyFile(source, destination);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public void embedScreenshot(Scenario scenario) {
		byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(source, "image/png", "screenshot");
	}
	
}
