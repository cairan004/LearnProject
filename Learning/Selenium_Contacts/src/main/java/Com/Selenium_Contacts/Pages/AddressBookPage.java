package Com.Selenium_Contacts.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends AbstractPage {
	private WebElement eGroup;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/div/h5/a[1]")
	private WebElement addGroupButton;
	
	@FindBy(xpath = "//*[@id='groupTree']/li")
	private List<WebElement> listGroup;
	
	@FindBy(xpath = "//*[@id='groupTree']/li/ul/li[1]")
	private WebElement nextGroup;
	
	@FindBy(id = "addGroup")
	private WebElement groupNameInput;
	
	@FindBy(id = "saveGroup")
	private WebElement saveGroupButton;
	
	@FindBy(xpath = "//*[@class='ep ep-more c-primary large-text on_click lass_show']")
	private WebElement functionGroupButton;
	
	@FindBy(xpath = "//*[@class='ep ep-more c-primary large-text on_click lass_show']/div/div/div[2]/ol/li[1]/a")
	private WebElement renameButton;
	
	@FindBy(xpath = "//*[@class='ep ep-more c-primary large-text on_click lass_show']/div/div/div[2]/ol/li[2]/a")
	private WebElement addNextGroupButton;
	
	@FindBy(xpath = "//*[@class='ep ep-more c-primary large-text on_click lass_show']/div/div/div[2]/ol/li[3]/a")
	private WebElement delGroupButton;
	
	@FindBy(xpath = "//*[@class='btn btn-primary del_all']")
	private WebElement delAllButton;
	
	@FindBy(xpath = "//*[@class='ep ep-set']")
	private WebElement propertyManagementButton;
	
	@FindBy(xpath = "//tr[@id = 'mysure_all']/th/div[1]/span")
	private List<WebElement> listHeaderOfContacts;
	
	@FindBy(xpath = "//div[@class = 'modal-content del_selfs in']/div[3]/button[2]")
	private WebElement confirmDelGroupButton;
	
	@FindBy(xpath = "//*[@class='btn btn-default show_butone text-center btn-sm w-80 m-l-10 allany_some']")
	private WebElement batchAddButton;
	
	public void clickBatchAddButton(){
		batchAddButton.click();
	}
	
	public void clickConfirmDelGroupButton(){
		confirmDelGroupButton.click();
	}
	
	/**
	 * 判断属性在通讯录中是否显示
	 * @param propertyName
	 * @return true 显示; false 未显示
	 * @author Biaow
	 */
	public Boolean isPropertyAtHeader(String propertyName){
		Boolean b = null;
		for(WebElement e : listHeaderOfContacts){
			if(e.getText().equals(propertyName)){
				b = true;
			}else {
				b = false;
			}
		}
		return b;
	}
	
	public void clickPropertyManagementButton(){
		propertyManagementButton.click();	
	}
	
	public void clickDelAllButton(){
		delAllButton.click();
	}
	
	/**
	 * 判断子一级群组是否存在
	 * @param nextGroupName 子一级群组名字
	 * @return true 存在; false 不存在
	 * @author Biaow
	 */
	public Boolean isNextGroup(String nextGroupName){
		Boolean b = null;
		if(nextGroup.getText().equals(nextGroupName)){
			b = true;
		}else {
			b = false;
		}
		return b;
	}
	
	/**
	 * 点击对应群组名的删除button
	 * @param groupName 群组名
	 * @throws Exception 
	 * @author Biaow
	 */
	public void clickDelGroupButton(String groupName) throws Exception{
		clickGroup(groupName);
		Thread.sleep(2000);
		clickFunctionGroupButton();
		Thread.sleep(2000);
		delGroupButton.click();
	}
	
	/**
	 * 点击对应群组名的添加下一级button
	 * @param groupName 群组名
	 * @throws Exception 
	 * @author Biaow
	 */
	public void clickAddNextGroupButton(String groupName) throws Exception{
		clickGroup(groupName);
		Thread.sleep(2000);
		clickFunctionGroupButton();
		Thread.sleep(2000);
		addNextGroupButton.click();
	}
	
	/**
	 * 点击对应群组名的的重命名button
	 * @param groupName 群组名
	 * @throws Exception 
	 * @author Biaow
	 * */
	public void clickRenameButton(String groupName) throws Exception{
		clickGroup(groupName);
		Thread.sleep(2000);
		clickFunctionGroupButton();
		Thread.sleep(2000);
		renameButton.click();
	}
	
	public void clickFunctionGroupButton(){
		functionGroupButton.click();
	}
	
	public void clickSaveGroupButton(){
		saveGroupButton.click();
	}
	
	public void inputGroupName(String groupName){
		groupNameInput.clear();
		groupNameInput.sendKeys(groupName);
	}
	
	//返回对应名字的元素
	public WebElement getGroup(String groupName){
		for(WebElement element : listGroup){
			if(element.getText().equals(groupName)){
				eGroup = element;
			}
		}
		return eGroup;
	}
	
	/**
	 * 判断指定群组名字的群组是否存在
	 * @param groupName 群组名字
	 * @return true 存在; false 不存在
	 * @author Biaow
	 */
	public Boolean isGroup(String groupName){
		Boolean b = null;
		for(WebElement element : listGroup){
			if(element.getText().equals(groupName)){
				b = true;
				break;
			}else {
				b = false;
			}
		}
		return b;
	}
	
	//点击对应名字的群组
	public void clickGroup(String groupName){
		for(WebElement element : listGroup){
			if(element.getText().equals(groupName)){
				element.click();
			}
		}
	}
	
	public void clickAddGroupButton(){
		addGroupButton.click();
	}
	
	/**
	 * 新建一个群组
	 * @param groupName 新建的群组名
	 * @author Biaow
	 */
	public void addGroup(String groupName){
		clickAddGroupButton();
		inputGroupName(groupName);
		clickSaveGroupButton();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public AddressBookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
