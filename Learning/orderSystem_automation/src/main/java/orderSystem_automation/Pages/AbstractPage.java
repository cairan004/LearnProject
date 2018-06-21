package orderSystem_automation.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage{

	
	/*
	 * initial driver 
	 */
	
	//构造函数,初始化元素
		public AbstractPage(WebDriver driver){
			PageFactory.initElements(driver,this);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

}
