package utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

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
	
	public void takeScreenshot(String name) {
		String filePath = "./screenshots/"+name+".png";
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);	
		Path content = Paths.get(filePath);
		try {
			FileUtils.copyFile(source, destination);
		}catch(IOException e){
			System.out.println(e);
		}
		try (InputStream is = Files.newInputStream(content)) {
		    Allure.addAttachment(name+" failure screenshot", is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void embedScreenshot(Scenario scenario) {
		byte[] source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(source, "image/png", "screenshot");
	}
	
	
	
}
