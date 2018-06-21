package web_automation.web_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	 System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    //	WebDriver driver = new FirefoxDriver();
    	driver.get("http://www.baidu.com");
    	driver.manage().window().maximize();
    	WebElement txbox=driver.findElement(By.name("wd"));
    	txbox.sendKeys("hello");
    	WebElement btn=driver.findElement(By.id("su"));
    	btn.click();
    	driver.close();
    }
    
   //通过xpath 
}
