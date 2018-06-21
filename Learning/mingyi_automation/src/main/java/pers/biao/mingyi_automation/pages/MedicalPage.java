package pers.biao.mingyi_automation.pages;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedicalPage extends AbstractPage{
	
	//@AndroidFindBy(xpath="//android.widget.RelativeLayout/android.widget.TextView[contains(@text,'医案')]")
	@AndroidFindBy(name="医案")
	private WebElement medicalTab;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='医案'and @resource-id='com.mingyihome.tcmmgr:id/title']")
	private WebElement medicalTitle;
	
    @AndroidFindBy(id="consilia_add")
    private WebElement addMedical_btn;
    
    @AndroidFindBy(id="search")
    private WebElement searchMedical_btn;
    
    @AndroidFindBy(id="me_item_title")
    private WebElement unnameMedical_btnElement;
    
    @AndroidFindBy(id="fb_take_picture")
    private WebElement pictureMedical;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='新建医案']")
    private WebElement addMedical_title;
	
    @AndroidFindBy(id="save")
    private WebElement saveMedical_btn;
    
    @AndroidFindBy(id="tv_patient_info")
    private WebElement patientInfo_btn;
    
    @AndroidFindBy(id="tv_create_date")
    private WebElement createDate_btn;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text=‘病情’]")
    private WebElement diseaseLable;
    
    @AndroidFindBy(id="tv_disease_pic")
    private WebElement diseasePic_btn;
    
    @AndroidFindBy(id="et_disease")
    private WebElement editDisease;
    
    @AndroidFindBy(id="tv_diagnose")
    private WebElement diagnoseLable;
    
    @AndroidFindBy(id="et_diagnose")
    private WebElement editDiagnose;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text=‘处方’]")
    private WebElement prescriptionLable;
    
    @AndroidFindBy(id="tv_electron_prescription")
    private WebElement ePrescription_btn;
    
    @AndroidFindBy(id="tv_pic_prescription")
    private WebElement picPrescription_btn;
    
    @AndroidFindBy(id="et_prescription")
    private WebElement editPrescription;
    
    @AndroidFindBy(id="tv_comment")
    private WebElement commentLable;
    
    @AndroidFindBy(id="et_comment")
    private WebElement editCommet_btn;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text=‘就诊人信息’]")
    private WebElement patientInfo_title;
    
    @AndroidFindBy(id="confirm")
    private WebElement confirm_btn;
    
    @AndroidFindBy(id="patient_name")
    private static WebElement nameInput;
    
    @AndroidFindBy(xpath = "//android.widget.RadioGroup/android.widget.RadioButton")
    private List<WebElement> sexList;
    
    @AndroidFindBy(id="patient_age")
    private WebElement ageIput;
    
    @AndroidFindBy(id="patient_month")
    private WebElement monthInput;
    
    @AndroidFindBy(id="et_patient_phone_number")
    private WebElement phoneunmberInput;
    
    @AndroidFindBy(id="numberpicker_input")
    private WebElement numberpickerInput;
    
    @AndroidFindBy(id="tv_patient_name")
    private List<WebElement> patientName;
    
    @AndroidFindBy(id="rb_tongue")
    private WebElement tongue;
    
    @AndroidFindBy(id="rb_disease_pic")
    private WebElement diseasePic;
    
    @AndroidFindBy(id="btn_picture")
    private WebElement choosePic;
    
    @AndroidFindBy(id="et_prescription_name")
    private WebElement prescNameInput;
    
    @AndroidFindBy(id="et_drug_name")
    private WebElement drugNameInput;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='白芍 - 芍药'and @resource-id='com.mingyihome.tcmmgr:id/result_drug_name']")
    private WebElement drugNameChoose;
     
    @AndroidFindBy(id="et_drug_weight")
    private WebElement drugWeightInput;
    
    @AndroidFindBy(id="iv_add")
    private WebElement medicAddBtn;
    
    @AndroidFindBy(id="item_drug_name")
    private WebElement drugnameItem;
    
    @AndroidFindBy(id="confirm")
    private WebElement saveElec;
    
   public MedicalPage(AndroidDriver<WebElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   public void MedicalRecord(){
	   try {
		   medicalTab.click();
		   if (medicalTitle.isDisplayed()&&addMedical_btn.isDisplayed()&&searchMedical_btn.isDisplayed()&&unnameMedical_btnElement.isDisplayed()&&pictureMedical.isDisplayed()) {
			resultFlag=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }  
   public void AddMedical() {
	try {
		addMedical_btn.click();	
		if(addMedical_title.isDisplayed()){
			resultFlag=true;
		}
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   public void AddPatientInfo(){
	   try {
		   patientInfo_btn.click();
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*输入名字*/
   public void AddPatientName(String name){
	   try {		   			
			nameInput.sendKeys(name);	
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*选择性别*/
   public void AddPatientSex(String sexinput){
	   try {
		   for(WebElement element : sexList){
			   
			   String text = element.getText();
			   String reg = "[^\u4e00-\u9fa5]";
			   text=text.replaceAll(reg, "");
			   if((text).equals(sexinput)){
				   element.click();
			   }
		   }
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}	   
   }	
   /*输入岁*/
   public void AddPatientAge(String age){
	   try {
		   ageIput.sendKeys(age);
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*输入月*/   
   public void AddPatientMonth(String month){
	   try {
		   monthInput.sendKeys(month);
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*输入手机*/
   public void AddPatientPhone(String phonenum){
	   try {
		   phoneunmberInput.sendKeys(phonenum);
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   public void SavePatientInfo() {
	try {
		confirm_btn.click();
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   /*输入病情*/
   public void AddDisease(String dieaseinfo){
	   try {
		   editDisease.sendKeys(dieaseinfo);
		
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*选择舌苔图片*/
   public void AddDiseasepic(){
	   try {
		diseasePic_btn.click();
		tongue.click();
		choosePic.click();		
		
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   
   /*输入诊断*/
   public void AddDiangnose(String diagnoseinfo) {
	try {
		editDiagnose.sendKeys(diagnoseinfo);
		
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   public void OpenElectronPres() {
	try {
		ePrescription_btn.click();
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   /*输入处方名*/
   public void PrecName(String precname){
	   try {
		     prescNameInput.sendKeys(precname);
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*输入处方药材*/
   public  void DrugName(String drugname) {
	   try {
		drugNameInput.sendKeys(drugname);
		drugNameChoose.click();
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}	
}
   /*输入剂量*/
   public void  DrugWeight(String weight) {
	try {
		  drugWeightInput.sendKeys(weight);  		  
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   public void AddDrug(String name) {
	try {
		medicAddBtn.click();	
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   /*保存电子处方*/  
   public void SaveElec(){
	   try {
		saveElec.click();
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   } 
   
   /*输入处方备注*/
   public void PrescriptionNote(String prescritioninfo){
	   try {
		   editPrescription.sendKeys(prescritioninfo); 
		
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*输入按语*/
   public void Note(String commet){

	   try {
		   if(editCommet_btn.isDisplayed()){
			   editCommet_btn.sendKeys(commet); 
		   }
		 else {
			
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
   }
   /*保存医案*/
   public void SaveMedical(String name) {
	try {
		  saveMedical_btn.click();
		  for(WebElement element:patientName){
		if(element.getText().equals(name)){
			  resultFlag=true;
		  }
		else {
			errMessage="没有找到新建的医案";
			resultFlag=false;
		}
		  }
	} catch (Exception e) {
		// TODO: handle exception
		errMessage=e.getMessage();
		resultFlag=false;
	}
}
   
}
