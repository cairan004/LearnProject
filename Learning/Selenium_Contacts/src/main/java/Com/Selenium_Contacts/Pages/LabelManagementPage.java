package Com.Selenium_Contacts.Pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabelManagementPage extends AbstractPage {
	
	@FindBy(xpath = "//form[@class = 'form-group bor-top p-t-20 clearfix']/div[2]/button[1]")
	private WebElement addLabel;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[3]/button[2]")
	private WebElement confirmAddButton;
	
	@FindBy(xpath = "//*[@class = 'modal-content']/div[2]/div/div/div/input")
	private WebElement labelNameInput;
	
	@FindBy(xpath = "//tbody[@id = 'dataList']/tr/td/div")
	private List<WebElement> listLabel;
	
	@FindBy(xpath = "//*[@class = 'page-wrap']/div/div/label")
	private WebElement checkBoxForAll;
	
	@FindBy(xpath = "//*[@class = 'page-wrap']/div/button")
	private WebElement batchDelButton;
	
	@FindBy(xpath = "//*[@id = 'messager-dialogue']/div/div/div[2]/button[2]")
	private WebElement confirmDelButton;
	
	@FindBy(xpath = "//input[@class='form-control normal-text search']")
	private WebElement searchInput;
	
	@FindBy(xpath = "//tbody[@id = 'dataList']/tr/td/div/button[2]/i")
	private List<WebElement> listFunctionLabelButton;
	
	@FindBy(xpath = "//*[@id = 'messager-dialogue']/div/div/div[1]/div/div/div/div[2]/div")
	private WebElement weakMark;

	/**
	 * 判断标识语是否正确
	 * @param markWord 标识语
	 * @return true 正确; false 不正确
	 * @author Biaow
	 */
	public Boolean isCorrectForWeakMark(String markWord){
		Boolean boolean1 = null;
		if(weakMark.getText().equals(markWord)){
			boolean1 = true;
		}else {
			boolean1 = false;
		}
		return boolean1;
	}
	
	/**
	 * 点击对应标签名的停用标签功能
	 * @param labelName 标签名
	 * @author Biaow
	 */
	public void clickDisableLabelButton(String labelName){
		int index = 0;
		for(WebElement element : listLabel){
			if(element.getText().equals(labelName)){
				index = listLabel.indexOf(element);
			}
		}
		listFunctionLabelButton.get(index).click();
	}
	
	public void clickEnterToSearch(){
		searchInput.sendKeys(Keys.ENTER);
	}
	
	public void inputSearchName(String labelName){
		searchInput.clear();
		searchInput.sendKeys(labelName);
	}
	
	public void clickConfirmDelButton(){
		confirmDelButton.click();
	}
	
	public void clickBatchDelButton(){
		batchDelButton.click();
	}
	
	public void clickCheckBoxForAll(){
		if(!checkBoxForAll.isSelected()){
			checkBoxForAll.click();
		}
	}
	
	/**
	 * 添加标签
	 * @param labelName 标签名
	 * @throws Exception
	 * @author Biaow
	 */
	public void addLabel(String labelName) throws Exception{
		clickAddLabel();
		Thread.sleep(2000);
		inputLabelName(labelName);
		clickConfirmAddButton();
	}
	
	/**
	 * 判断标签是否存在
	 * @param labelName 标签名
	 * @return true 存在; false 不存在
	 * @author Biaow
	 */
	public Boolean isLabel(String labelName){
		Boolean boolean1 = null;
		if(listLabel.isEmpty()){
			boolean1 = false;
		}else {
			for(WebElement element : listLabel){
				if(element.getText().equals(labelName)){
					boolean1 = true;
					break;
				}else {
					boolean1 = false;
				}
			}	
		}
		return boolean1;
	}
	
	public void inputLabelName(String labelName){
		labelNameInput.clear();
		labelNameInput.sendKeys(labelName);
	}
	
	public void clickConfirmAddButton(){
		confirmAddButton.click();
	}
	
	public void clickAddLabel(){
		addLabel.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public LabelManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
