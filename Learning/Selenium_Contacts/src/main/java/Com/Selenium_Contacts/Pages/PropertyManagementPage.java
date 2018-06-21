package Com.Selenium_Contacts.Pages;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PropertyManagementPage extends AbstractPage {
	
	@FindBy(xpath = "//*[@class = 'ep ep-add c-primary']")
	private List<WebElement> lisAddButton;
	
	@FindBy(xpath = "//div[@class = 'modal-content']/div[2]/div/div[2]/div/input")
	private WebElement propertyNameInput;
	
	@FindBy(xpath = "//div[@class = 'modal-content']/div[3]/button[2]")
	private WebElement confirmAddButton;
	
	@FindBy(xpath = "//div[@class = 'modal-content']/div[2]/div/div/div/label")
	private List<WebElement> listTypesOfCommunication;
	
	@FindBy(xpath = "//li[@class = 'attributeName']")
	private List<WebElement> listPropertyUncheck;
	
	@FindBy(xpath = "//li[@class = 'hover attributeName']")
	private List<WebElement> listPropertyChecked;
	
	@FindBy(xpath = "//div[@class='modal-footer text-center operateChunk']/button")
	private WebElement comfirmToSaveButton;
	
	@FindBy(xpath = "//i[@class = 'ep removeAttr']")
	private List<WebElement> listDelButton;
	
	@FindBy(xpath = "//div[@class = 'modal-content']/div[2]/button[2]")
	private WebElement confirmDelButton;
	
	public void clickConfirmDelButton(){
		confirmDelButton.click();
	}
	
	/**
	 * 点击属性名称对应的删除button
	 * @param propertyName 属性名称
	 * @throws Exception 
	 * @author Biaow
	 */
	public void clickDelButton(String propertyName) throws Exception{
		int index = 0;
		for(WebElement element1 : listPropertyUncheck){
			if(element1.getText().equals(propertyName)){
				index = listPropertyUncheck.indexOf(element1);
			}
		}
		checkProperty(propertyName);
		listDelButton.get(index).click();
	}
	
	public void clickComfirmToSaveButton(){
		comfirmToSaveButton.click();
	}
	
	/**
	 * 勾选一个未勾选的属性
	 * @param propertyName 属性名称
	 * @throws InterruptedException 
	 * @author Biaow
	 */
	public void checkProperty(String propertyName) throws InterruptedException{
		if(listPropertyChecked.size()<5){
			for(WebElement element1 : listPropertyUncheck){
				if(element1.getText().equals(propertyName)){
					element1.click();
				}
			}
		}else {
			listPropertyChecked.get(0).click();
			Thread.sleep(2000);
			for(WebElement element2 : listPropertyUncheck){
				if(element2.getText().equals(propertyName)){
					element2.click();
				}
			}
		}
	}

	/**
	 * 判断属性存不存在
	 * @param propertyName 属性名字
	 * @return ture 存在; false 不存在
	 * @author Biaow
	 */
	public Boolean isProperty(String propertyName){
		Boolean boolean1 = null;
		if(isCheckedProperty(propertyName)||isUncheckedProperty(propertyName)){
			boolean1 = true;
		}else{
			boolean1 = false;
		}
		return boolean1;
	}
	
	/**
	 * 查看已勾选列表判断属性是否存在
	 * @param propertyName 属性名字
	 * @return true 存在; false 不存在
	 * @author Biaow
	 */
	public Boolean isCheckedProperty(String propertyName) {
		Boolean b = null;
		for(WebElement element1 : listPropertyUncheck){
			if(element1.getText().equals(propertyName)){
				b = true;
				break;
			}else{
				b = false;
			}
		}
		return b;
	}
	
	/**
	 * 查看未勾选列表判断属性是否存在
	 * @param propertyName 属性名称
	 * @return true 存在; false 不存在
	 * @throws Exception 
	 * @author Biaow
	 */
	public Boolean isUncheckedProperty(String propertyName) {
		Boolean b = null;
		for(WebElement element1 : listPropertyUncheck){
			if(element1.getText().equals(propertyName)){
				b = true;
				break;
			}else{
				b = false;
			}
		}
		return b;
	}
	
	/**
	 * 选择对应名称的通讯类型
	 * @param typeName 类型名称
	 * @author Biaow
	 */
	public void checkTypesOfCommunication(String typeName){
		for(WebElement element : listTypesOfCommunication){
			if(element.getText().equals(typeName)){
				element.click();
			}
		}
	}
	
	public void clickExtensionPropertyAddButton(){
		lisAddButton.get(2).click();
	}
	
	public void clickCommunicationPropertyAddButton(){
		lisAddButton.get(1).click();
	}
	
	public void clickBasePropertyAddButton(){
		lisAddButton.get(0).click();
	}
	
	public void inputPropertyName(String propertyName){
		propertyNameInput.clear();
		propertyNameInput.sendKeys(propertyName);
	}
	
	public void clickConfirmAddButton(){
		confirmAddButton.click();
	}

	public PropertyManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
