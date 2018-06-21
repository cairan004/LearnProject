package pers.biao.mingyi_automation.pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends AbstractPage {
	
	@AndroidFindBy(id = "edt_phone")
	private WebElement phoneNumberInput;
	
	@AndroidFindBy(id = "edt_password")
	private WebElement passwordInput;
	
	@AndroidFindBy(id = "btn_login")
	private WebElement loginButton;	
	@AndroidFindBy (id="btn_find_password")
	private WebElement  forgetpassword_btn;
	@AndroidFindBy (id="tabhost")
	private WebElement  tabhost;
	
/*	@AndroidFindBy(id = "xx")
	private WebElement xxElement;
	
	public Boolean verify(String str){
		if(str.equals(xxElement.getText())){
			return true;
		}else {
			errMessage = "提示语不对！";
			resultFlag = false;
			return false;
		}
	}*/
	
	
	public void inputPhoneNumber(String phoneNum){
		try {
			phoneNumberInput.clear();
			phoneNumberInput.sendKeys(phoneNum);
		} catch (Exception e) {
			// TODO: handle exception
			errMessage = e.getMessage();
			resultFlag = false;
		}
	}
	
	public void inputPassword(String password){
		try {
			passwordInput.clear();
			passwordInput.sendKeys(password);
		} catch (Exception e) {
			// TODO: handle exception
			errMessage = e.getMessage();
			resultFlag = false;
		}
	}
	
	public void clickLoginButton(){
		try {
			loginButton.click();
			if(tabhost.isDisplayed()){
				resultFlag=true;				
			}
			else {
				errMessage="没有登录到主页";
				resultFlag=false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			errMessage = e.getMessage();
			resultFlag = false;
		}
	}
	public void clickForgetpasswordBttton() {
		try{
			forgetpassword_btn.click();
		}catch(Exception e){
			errMessage=e.getMessage();
			resultFlag=false;
		}
		
	}
	public LoginPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
