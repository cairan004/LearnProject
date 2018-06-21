package pers.biao.mingyi_automation.keyword;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import pers.biao.mingyi_automation.pages.AbstractPage;

public class KeyWordAction extends AbstractPage{

	/*
	 * 通过java反射机制获取类中所有的方法,并初始化构造函数
	 */
	public void executeAction(String className, String action, String value) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		
			Boolean boolean1 = true;
		
			Method[] method = getClass(className).getMethods();
			Constructor<?> constructor = getClass(className).getConstructor(AndroidDriver.class);
			
			try {
				for(int i=0;i<method.length;i++){
					if(method[i].getName().equalsIgnoreCase(action)){
						try {
							method[i].invoke(constructor.newInstance(driver),value);
						} catch (Exception e) {
							// TODO: handle exception
							method[i].invoke(constructor.newInstance(driver));
							}
						boolean1 = true;
						break;
						}else{
							boolean1 = false;
						}
					} 
				}catch (Exception e) {
				// TODO: handle exception
				resultFlag = false;
				errMessage = e.getMessage();
			}
			
			if(!boolean1){
				resultFlag = false;
				errMessage = "页面无此操作,请检查className和action是否匹配";
			}
	}
	
	/*
	 * 返回传入的类,供反射使用
	 */
	public Class<?> getClass(String className) throws ClassNotFoundException, NoSuchMethodException, SecurityException{
		switch (className) {
			case "AbstractPage":
				Class<?> clazz01 = Class.forName("pers.biao.mingyi_automation.pages.AbstractPage");
				return clazz01;
			case "LoginPage":
				Class<?> clazz02 = Class.forName("pers.biao.mingyi_automation.pages.LoginPage");
				return clazz02;
			case "WorkRoomPage":
				Class<?> clazz03 = Class.forName("pers.biao.mingyi_automation.pages.WorkRoomPage");
				return clazz03;
			case "PasswordPage":
				Class<?> clazz04 = Class.forName("pers.biao.mingyi_automation.pages.PasswordPage");
				return clazz04;
			case "MedicalPage":
				Class<?> clazz05 = Class.forName("pers.biao.mingyi_automation.pages.MedicalPage");
				return clazz05;
				
			default:
				System.out.println(className+" 没找到,请传入正确的类或者在该方法中加入新增的类!");
				return null;
		}
	}

	public KeyWordAction(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
