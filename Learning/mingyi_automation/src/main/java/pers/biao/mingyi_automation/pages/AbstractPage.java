package pers.biao.mingyi_automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pers.biao.mingyi_automation.util.AbstractDriver;

public class AbstractPage {
	public AndroidDriver<WebElement> driver;
	public static Boolean resultFlag = true;
	public static String errMessage;
	
	/*
	 * initial driver
	 */
	public AbstractPage(AndroidDriver<WebElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,15,TimeUnit.SECONDS), this);
	}
}
