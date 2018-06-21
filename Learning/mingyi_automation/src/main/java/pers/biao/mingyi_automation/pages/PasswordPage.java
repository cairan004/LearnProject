package pers.biao.mingyi_automation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebElement;

public class PasswordPage extends AbstractPage{
	
	
	@AndroidFindBy (id="edt_phone")
	private WebElement phonenumberInput;
	
	@AndroidFindBy(id="edt_code")
	private WebElement verifycodeInput;
	
	@AndroidFindBy(id="btn_get_code")
	private WebElement code_btn;
	
	@AndroidFindBy(id="edt_password")
	private WebElement passwordInput;

	@AndroidFindBy (id="btn_submit")
	private WebElement submit_btn;
	
	public void InputPhonenumber(String Phonenum){
		try {
			phonenumberInput.clear();
			phonenumberInput.sendKeys(Phonenum);
		} catch (Exception e) {
			errMessage=e.getMessage();
			resultFlag=false;
		}
	}
	
	public void clickVerifycode() {
		try {
			code_btn.click();
			if (code_btn.isEnabled()) {
				resultFlag=false;
				errMessage="获取验证码失败";
			}
			else {
				resultFlag=true;			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			errMessage=e.getMessage();
			resultFlag=false;
		}
	}
	
	public void InputVerifycode(String Verifycode){
		try {
			verifycodeInput.sendKeys(Verifycode);
		} catch (Exception e) {
			// TODO: handle exception
			errMessage=e.getMessage();
			resultFlag=false;
		}
	}
	
	public void  Inputpassord(String passwordnum) {
		try {
			passwordInput.clear();
			passwordInput.sendKeys(passwordnum);
		} catch (Exception e) {
			// TODO: handle exception
			errMessage=e.getMessage();
			resultFlag=false;
		}
	}
	
	public void SubmitButton() {
		try {
			submit_btn.click();
		} catch (Exception e) {
			// TODO: handle exception
			errMessage=e.getMessage();
			resultFlag=false;
		}
	}
	
	public PasswordPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
