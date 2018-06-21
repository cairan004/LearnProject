package Com.Selenium_Contacts.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Selenium_Contacts.Pages.LabelManagementPage;
import Com.Selenium_Contacts.Units.*;

public class TestLabel extends AbstractTest{
	public LabelManagementPage labelManagementPage;

	@BeforeTest
	public void getHomePage() throws Exception{
		labelManagementPage = new LabelManagementPage(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);
	}
	
	@Test(enabled = true)
	public void testAddLabel() throws Exception{
		String labelName = String.valueOf(Utils.randomNum()%10000000);
		
		labelManagementPage.clickLabelManagementBar();
		Thread.sleep(2000);
		labelManagementPage.addLabel(labelName);
		Thread.sleep(2000);
		AssertJUnit.assertTrue("标签不存在",labelManagementPage.isLabel(labelName));
	}
	
	@Test(dependsOnMethods = {"testAddLabel"}, enabled = true)
	public void testBatchDelLabel() throws Exception{
		String labelName = String.valueOf(Utils.randomNum()%10000000);
		
		labelManagementPage.clickLabelManagementBar();
		Thread.sleep(2000);
		labelManagementPage.addLabel(labelName);
		Thread.sleep(2000);
		labelManagementPage.clickCheckBoxForAll();
		Thread.sleep(2000);
		labelManagementPage.clickBatchDelButton();
		Thread.sleep(2000);
		labelManagementPage.clickConfirmDelButton();
		Thread.sleep(2000);
		Utils.refreshBrowse(driver);
		AssertJUnit.assertFalse("标签没删除成功", labelManagementPage.isLabel(labelName));
	}
	
	@Test(dependsOnMethods = {"testAddLabel"}, enabled = true)
	public void testSearchLabel() throws Exception{
		String labelName = String.valueOf(Utils.randomNum()%10000000);
		
		labelManagementPage.clickLabelManagementBar();
		Thread.sleep(2000);
		labelManagementPage.addLabel(labelName);
		Thread.sleep(2000);
		labelManagementPage.inputSearchName(labelName);
		labelManagementPage.clickEnterToSearch();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("标签没搜索不成功", labelManagementPage.isLabel(labelName));
	}
	
	@Test(dependsOnMethods = {"testAddLabel"}, enabled = true)
	public void testEnableOrDisableLabel() throws Exception{
		String labelName = String.valueOf(Utils.randomNum()%10000000);

		labelManagementPage.clickLabelManagementBar();
		Thread.sleep(2000);
		labelManagementPage.addLabel(labelName);
		Thread.sleep(2000);
		labelManagementPage.clickDisableLabelButton(labelName);
		Thread.sleep(2000);
		AssertJUnit.assertTrue("操作失败", labelManagementPage.isCorrectForWeakMark("标签停用成功!"));
	}
}
