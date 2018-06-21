package Com.Selenium_Contacts.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class AbstractTest {
	public static WebDriver driver;
	public String baseUrl = "http://newcontacts.t.ums86.com/dist/page/contacts/address_book.html?hover=10111";
	
	@BeforeSuite
	public static void setUp(){
		
		//启动firefox,需要selenium3.0.1以上
		System.setProperty("webdriver.firefox.bin", "F:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		System.setProperty("webdriver.gecko.driver", "webDriver//geckodriver.exe");
		driver = new FirefoxDriver();
		
/*		//启动chrome
		System.setProperty("webdriver.chrome.driver", "webDriver//chromedriver.exe");
		driver = new ChromeDriver();*/
		
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public static void tearDown() throws Exception{
		Thread.sleep(2000);
		driver.quit();
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
