package order_automation.Case;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class AbstractTest {
   
	protected AndroidDriver<WebElement> driver; 
	   
	   public void setupDriver() throws Exception {
		   /*
		  设置apk的路径
		   File classpathRoot = new File(System.getProperty("user.dir"));
		   File appDir = new File(classpathRoot, "apps");
		   File app = new File(appDir, "ContactManager.apk");
		    */       
		   
		  //设置自动化相关参数
		    DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		    capabilities.setCapability("platformName", "Android");
		    capabilities.setCapability("deviceName", "1770bd16");
		           
		    //设置安卓系统版本
		     capabilities.setCapability("platformVersion", "7.1.1");
		   //设置apk路径
		   //  capabilities.setCapability("app", app.getAbsolutePath()); 
		     
		 //设置app的主包名和主类名
	         capabilities.setCapability("appPackage", "cmcc.hy.com.globaltravel");
		     capabilities.setCapability("appActivity", "cmcc.hy.com.globaltravel.MainActivity");
	      //初始化
		    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
		      
	   }
	   
	     @BeforeSuite
		public void setup() throws Exception{
			setupDriver();
			
		}
		
		@AfterSuite
		public void tearDown() throws Exception{
			Thread.sleep(5000);
			driver.quit();
		}
	
		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return driver;
		}
	
}
