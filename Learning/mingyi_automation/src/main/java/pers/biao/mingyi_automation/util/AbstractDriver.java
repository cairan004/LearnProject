package pers.biao.mingyi_automation.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class AbstractDriver {
	
	protected AndroidDriver<WebElement> driver;
	private  DesiredCapabilities dCapabilities;
	private  InputStream inputStream;
	private  Properties properties;
	private final  String ANDROID_PROPERTIES = System.getProperty("user.dir")+"\\src\\main\\java\\pers\\biao\\mingyi_automation\\config\\"+"Android.properties";
	private final  String LOCAL_URL = "http://127.0.0.1:4723/wd/hub";
	
	/*
	 * initial driver
	 */
	public void setUpDriver() throws Exception {
		dCapabilities = new DesiredCapabilities();
		inputStream = new FileInputStream(ANDROID_PROPERTIES);
		properties = new Properties();
		properties.load(inputStream);
		
		//遍历properties,设置Desired Capabilities
		Iterator<?> iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) iterator.next();
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			dCapabilities.setCapability(key,value);
		}
		driver = new AndroidDriver<WebElement>(new URL(LOCAL_URL), dCapabilities);
		inputStream.close();
	}
	
	@BeforeSuite
	public void getDriver() throws Exception{
		setUpDriver();
	}
	
	@AfterSuite
	public void tearDown() throws Exception{
		Thread.sleep(5000);
		driver.quit();
	}
}
