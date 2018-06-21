package Com.Selenium_Contacts.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Selenium_Contacts.Pages.AddressBookPage;
import Com.Selenium_Contacts.Units.*;

public class TestGroup extends AbstractTest {
	public AddressBookPage addressBookPage;

	@BeforeTest
	public void getHomePage() throws Exception{
		addressBookPage = new AddressBookPage(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);
	}
	
	@Test(enabled = true)
	public void testAddGroup() throws Exception {
		String groupName = String.valueOf(Utils.randomNum());
		
		addressBookPage.addGroup(groupName);
		Thread.sleep(2000);
		AssertJUnit.assertTrue("群组不存在", addressBookPage.isGroup(groupName));
	}
	
	@Test(dependsOnMethods = {"testAddGroup"}, enabled = true)
	public void testRenameGroup() throws Exception {
		String groupName = String.valueOf(Utils.randomNum());
		String renameGroupName = String.valueOf(Utils.randomNum());

		addressBookPage.addGroup(groupName);
		Thread.sleep(2000);
		addressBookPage.clickRenameButton(renameGroupName);
		addressBookPage.inputGroupName(groupName);
		addressBookPage.clickSaveGroupButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("群组不存在",addressBookPage.isGroup(groupName));
	}
	
	@Test(dependsOnMethods = {"testAddGroup"}, enabled = true)
	public void testAddNextGroup() throws Exception {
		String groupName = String.valueOf(Utils.randomNum());
		String nextGroupName = String.valueOf(Utils.randomNum());
		
		addressBookPage.addGroup(groupName);
		Thread.sleep(2000);
		addressBookPage.clickAddNextGroupButton(groupName);
		addressBookPage.inputGroupName(nextGroupName);
		addressBookPage.clickSaveGroupButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("群组不存在", addressBookPage.isNextGroup(nextGroupName));
	}
	
	@Test(dependsOnMethods = {"testAddGroup"}, enabled = true)
	public void testDelGroup() throws Exception {
		String groupName = String.valueOf(Utils.randomNum());
		
		addressBookPage.addGroup(groupName);
		Thread.sleep(2000);
		addressBookPage.clickDelGroupButton(groupName);
		addressBookPage.clickConfirmDelGroupButton();
		Thread.sleep(2000);
		AssertJUnit.assertFalse("群组没删除掉,仍然存在", addressBookPage.isGroup(groupName));
	}
}
