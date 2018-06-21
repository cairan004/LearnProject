package web_automation.web_automation;

import java.awt.Desktop.Action;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

public class MouseExercise {
	
	 //System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
 	//WebDriver driver = new ChromeDriver();
	
	//鼠标悬停
	@Test
	public void mouse1() {
		 System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();	
		driver.get("https://www.baidu.com");
		WebElement setbtn = driver.findElement(By.linkText("设置"));
		Actions action = new Actions(driver);
		action.clickAndHold(setbtn).perform();;
			
	}

}
