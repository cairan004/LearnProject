package Com.Selenium_Contacts.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Selenium_Contacts.Pages.AddressBookPage;
import Com.Selenium_Contacts.Pages.BatchAddPage;

public class TestBatchImport extends AbstractTest{
	private BatchAddPage batchAddPage;
	private AddressBookPage addressBookPage;
	
	@BeforeTest
	public void getHome() throws Exception{
		batchAddPage = new BatchAddPage(driver);
		addressBookPage = new AddressBookPage(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);
	}

	@Test
	public void testBatchImport() throws Exception{
		addressBookPage.clickBatchAddButton();
		batchAddPage.inputFilePath("C:\\Users\\lenovo\\Desktop\\批量导入联系人测试模板\\模板一.xlsx");
		Thread.sleep(10000);
		
	}
}
