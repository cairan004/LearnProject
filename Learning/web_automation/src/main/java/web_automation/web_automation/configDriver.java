package web_automation.web_automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class configDriver {

        public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");     
	    WebDriver driver = new ChromeDriver();
		return driver;
		
	}
}
