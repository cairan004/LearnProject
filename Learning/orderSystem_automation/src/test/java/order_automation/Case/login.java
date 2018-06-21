package order_automation.Case;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import orderSystem_automation.Pages.AbstractPage;
import orderSystem_automation.Pages.LoginPage;
import order_automation.util.AbstractDriver;

public class login extends AbstractTest {
	public LoginPage loginPage;

	@BeforeTest
	public void getHome() throws Exception{
		loginPage = new LoginPage(driver);
		Thread.sleep(2000);
	}
	
	@Test
	public void Entry() {
		loginPage.clickEntryBtn();
    }
	
	
}
