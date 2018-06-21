package Com.Selenium_Contacts.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BatchAddPage extends AbstractPage{
	
	@FindBy(xpath = "//a[@class = 'impotup_show m-l-20']")
	private WebElement groupSelectionButton;
	
	@FindBy(xpath = "//div[@class = 'uploadfile w-326 h-35']/a")
	private WebElement importFileButton;
	
	@FindBy(xpath = "//div[@class = 'uploadfile w-326 h-35']/input[2]")
	private WebElement filePathInput;
	
	public void inputFilePath(String filePath){
		filePathInput.sendKeys(filePath);
		filePathInput.submit();
	}
	
	public void clickImportFileButton(){
		importFileButton.click();
	}
	
	public void clickGroupSelectionButton(){
		groupSelectionButton.click();
	}

	public BatchAddPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
