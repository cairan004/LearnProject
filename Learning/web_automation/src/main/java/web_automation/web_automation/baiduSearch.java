package web_automation.web_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.WinUser.INPUT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class baiduSearch extends configDriver {
  
	public static void baiduTest(String testdata) throws InterruptedException {
		WebDriver driver = configDriver.init();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys(testdata);
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		driver.close();	
	}
	
	public static void readTextFile(String filepath) {
		try {
			String encoding = "utf8";
			File file = new File(filepath);
			if (file.isFile()&&file.exists()) {
				InputStreamReader reader = new InputStreamReader(new FileInputStream(file), encoding);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String Linetxt = null;
				while((Linetxt=bufferedReader.readLine())!= null) {
					baiduTest(Linetxt);
				}			
				reader.close();					
			} else {
				System.out.println("找不到指定文件");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("读取内容出错");
			e.printStackTrace();
		}
	}
     @Test
   public static void run() {
	   String filepath = "d:\\test.txt";
	   readTextFile(filepath);
   }
}
