package pers.biao.mingyi_automation.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WorkRoomPage extends AbstractPage{
	
	@AndroidFindBy(id = "title_name")
	private WebElement loginName;
	
	public void isLoginNameRight(String name){
		try {
			System.out.println(loginName.getText());
			if(loginName.getText().equalsIgnoreCase(name)){
				resultFlag = true;
			}else {
				resultFlag = false;
				errMessage = "登录账户实际名字与预期名字不符合";
			}
		} catch (Exception e) {
			// TODO: handle exception
			errMessage = e.getMessage();
			resultFlag = false;
		}
	}
	

	public WorkRoomPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
