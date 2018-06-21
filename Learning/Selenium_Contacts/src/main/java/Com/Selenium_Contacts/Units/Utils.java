package Com.Selenium_Contacts.Units;

import org.openqa.selenium.WebDriver;

public class Utils {
	
	/**
	 * 生成随机数
	 * @return 获取一个当前时间毫秒数的long型数字
	 * @author Biaow
	 * */
	public static long randomNum(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 刷新浏览器
	 * @author Biaow
	 */
	public static void refreshBrowse(WebDriver driver){
		driver.navigate().refresh();
	}
	
}
