package Com.Selenium_Contacts.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Selenium_Contacts.Pages.AddressBookPage;

public class TestSiderBar extends AbstractTest {
	public AddressBookPage addressBookPage;

	@BeforeTest
	public void getHomePage() throws Exception{
		addressBookPage = new AddressBookPage(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);
	}

	@Test(enabled = true)
	public void testSideBar() throws Exception{

		String titleContact = driver.getTitle();
		AssertJUnit.assertEquals("通讯录", titleContact);
		addressBookPage.clickLabelManagementBar();
		Thread.sleep(2000);
		String titleLabel = driver.getTitle();
		AssertJUnit.assertEquals("标签管理", titleLabel);
/*		addressBookPage.clickContactsConfigBar();
		Thread.sleep(2000);
		String titleConfig = driver.getTitle();
		AssertJUnit.assertEquals("通讯录策略配置", titleConfig);*/
		addressBookPage.expandDataCenterBar();
		addressBookPage.clickImportList();
		Thread.sleep(2000);
		String titleImport = driver.getTitle();
		AssertJUnit.assertEquals("导入导出列表", titleImport);
		addressBookPage.clickUserDataBar();
		Thread.sleep(2000);
		String titleData = driver.getTitle();
		AssertJUnit.assertEquals("用户数据", titleData);
	}
}
