package Com.Selenium_Contacts.Units;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import Com.Selenium_Contacts.Test.AbstractTest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class TestngListener extends TestListenerAdapter {
	 private static Logger logger = Logger.getLogger(TestngListener.class);

	 @Override
	 public void onTestFailure(ITestResult tr) {
	      super.onTestFailure(tr);
	      logger.info(tr.getName() + " Failure");
	      takeScreenShot(tr);
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
	      super.onTestSkipped(tr);
	      logger.info(tr.getName() + " Skipped");
	      takeScreenShot(tr);
	  }

	    @Override
	  public void onTestSuccess(ITestResult tr) {
	      super.onTestSuccess(tr);
	      logger.info(tr.getName() + " Success");
	    }

	  @Override
	  public void onTestStart(ITestResult tr) {
	      super.onTestStart(tr);
	      logger.info(tr.getName() + " Start");
	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
	      super.onFinish(testContext);

	  }
	  
	  /**
	   * 自动截图，保存图片到本地以及html结果文件中
	   *
	   * @param tr
	   */
	  private void takeScreenShot(ITestResult tr) {
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	     String date = formatter.format(new Date());
	     String fileName = date + "_" + tr.getName();
	     String path = getScreenshotSavePath() + File.separator + fileName+".png";
	     System.out.println(1);
	     AbstractTest tb = (AbstractTest) tr.getInstance();
	     WebDriver driver = tb.getDriver();
	     try {
	        	logger.info("Captured Screenshot for Failure: "+path);
	            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(srcFile,new File(path));
	            System.out.println(2);
	      }catch (Exception e) {
	           logger.info("Captured Screenshot failed ");
	           throw new RuntimeException(e);
	       }
	       finally {
	           logger.info("Captured Screenshot success ");
	       }

	        Reporter.setCurrentTestResult(tr);
	        Reporter.log(path);

	        //这里实现把图片链接直接输出到结果文件中，通过邮件发送结果则可以直接显示图片
	        Reporter.log("<img src=\"../" + path + "\"/>");

	    }
	    protected String getScreenshotSavePath() {
	        String packageName = this.getClass().getPackage().getName();
	        File dir = new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator + packageName + File.separator);
	        dir.mkdirs();
	        return dir.getAbsolutePath();
	    }

}
