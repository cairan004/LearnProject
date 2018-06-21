package pers.biao.mingyi_automation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

public class Registe extends AbstractPage {
	
    @AndroidFindBy(id="btn_quick_register")
    private WebElement LoginRegist_btn;
    
    @AndroidFindBy(id="btn_register")
    private WebElement Regist_btn;
    
    
	public Registe(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	

}
