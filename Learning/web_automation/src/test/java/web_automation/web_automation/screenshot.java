package web_automation.web_automation;

import java.sql.Driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;


public class screenshot {
	@Test
    public void name() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.get("http://www.baidu.com");
		
		try {
			File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("d:\\scr.png"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		webDriver.quit();
	}
}
