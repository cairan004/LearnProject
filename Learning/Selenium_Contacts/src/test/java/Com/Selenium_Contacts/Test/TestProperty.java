package Com.Selenium_Contacts.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Selenium_Contacts.Pages.AddressBookPage;
import Com.Selenium_Contacts.Pages.PropertyManagementPage;
import Com.Selenium_Contacts.Units.Utils;

public class TestProperty extends AbstractTest{
	public PropertyManagementPage propertyManagementPage;
	public AddressBookPage addressBookPage;
	
	@BeforeTest
	public void getHomePage() throws Exception{
		propertyManagementPage = new PropertyManagementPage(driver);
		addressBookPage = new AddressBookPage(driver);
		driver.get(baseUrl);
		Thread.sleep(2000);
		addressBookPage.clickPropertyManagementButton();
		Thread.sleep(2000);
	}
	
	@Test(enabled = true)
	public void testAddProperty() throws Exception{
		String baseName = String.valueOf(Utils.randomNum()%1000000);
		String communicationName = String.valueOf(Utils.randomNum()%1000000+1);
		String extensionName = String.valueOf(Utils.randomNum()%1000000+2);
		
		propertyManagementPage.clickBasePropertyAddButton();
		Thread.sleep(2000);
		propertyManagementPage.inputPropertyName(baseName);
		propertyManagementPage.clickConfirmAddButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("属性不存在", propertyManagementPage.isProperty(baseName));
		propertyManagementPage.clickCommunicationPropertyAddButton();
		Thread.sleep(2000);
		propertyManagementPage.checkTypesOfCommunication("手机");
		propertyManagementPage.inputPropertyName(communicationName);
		propertyManagementPage.clickConfirmAddButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("属性不存在", propertyManagementPage.isProperty(communicationName));
		propertyManagementPage.clickExtensionPropertyAddButton();
		Thread.sleep(2000);
		propertyManagementPage.inputPropertyName(extensionName);
		propertyManagementPage.clickConfirmAddButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("属性不存在", propertyManagementPage.isProperty(extensionName));
	}
	
	@Test(dependsOnMethods = {"testAddProperty"}, enabled = true)
	public void testCheckProperty() throws Exception{
		String baseName = String.valueOf(Utils.randomNum()%100000);
		
		propertyManagementPage.clickBasePropertyAddButton();
		Thread.sleep(2000);
		propertyManagementPage.inputPropertyName(baseName);
		propertyManagementPage.clickConfirmAddButton();
		Thread.sleep(2000);
		propertyManagementPage.checkProperty(baseName);
		propertyManagementPage.clickComfirmToSaveButton();
		Thread.sleep(2000);
		AssertJUnit.assertTrue("没有勾选成功", addressBookPage.isPropertyAtHeader(baseName));
	}
	
	@Test(dependsOnMethods = {"testAddProperty"}, enabled = true)
	public void testDelProperty() throws Exception{
		String baseName = String.valueOf(Utils.randomNum()%100000+1);
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		addressBookPage.clickPropertyManagementButton();
		Thread.sleep(2000);
		propertyManagementPage.clickBasePropertyAddButton();
		Thread.sleep(2000);
		propertyManagementPage.inputPropertyName(baseName);
		propertyManagementPage.clickConfirmAddButton();
		Thread.sleep(2000);
		propertyManagementPage.clickDelButton(baseName);
		Thread.sleep(2000);
		propertyManagementPage.clickConfirmDelButton();
		Thread.sleep(2000);
		AssertJUnit.assertFalse("没有删除成功", propertyManagementPage.isCheckedProperty(baseName));
	}
}
