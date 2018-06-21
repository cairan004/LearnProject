package Com.Selenium_Contacts.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

	@FindBy(xpath = "//*[@class='side-inner contact-silde']/ul/li[1]/h3/a")
	private WebElement contactsBar;
	
	@FindBy(xpath = "//*[@class='side-inner contact-silde']/ul/li[2]/h3/a")
	private WebElement labelManagementBar;
	
	@FindBy(xpath = "//*[@class='side-inner contact-silde']/ul/li[3]/h3/a")
	private WebElement contactsConfigBar;
	
	@FindBy(xpath = "//*[@class='side-inner contact-silde']/ul/li[4]/h3/a")
	private WebElement dataCenterBar;
	
	@FindBy(xpath = "//*[@class = 'listview']")
	private WebElement listDataCenterBar;
	
	@FindBy(xpath = "//*[@class = 'listview']/ul/li[1]/a")
	private WebElement importListBar;
	
	@FindBy(xpath = "//*[@class = 'listview']/ul/li[2]/a")
	private WebElement userDataBar;
	
	public void clickUserDataBar(){
		userDataBar.click();
	}
	
	public void clickImportList(){
		importListBar.click();
	}
	
	public String getStyleOfListDataCenterBar(){
		return listDataCenterBar.getAttribute("style");
	}
	
	public void expandDataCenterBar(){
		if(getStyleOfListDataCenterBar().equals("display: none;")){
			dataCenterBar.click();
		}
	}
	
	public void clickContactsConfigBar(){
		contactsConfigBar.click();
	}
	
	public void clickLabelManagementBar(){
		labelManagementBar.click();
	}
	
	public void clickContactsBar(){
		contactsBar.click();
	}
	
	
	
	//构造函数,初始化元素
	public AbstractPage(WebDriver driver){
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
}
