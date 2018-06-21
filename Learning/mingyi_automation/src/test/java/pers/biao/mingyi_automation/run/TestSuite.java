package pers.biao.mingyi_automation.run;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pers.biao.mingyi_automation.keyword.KeyWordAction;
import pers.biao.mingyi_automation.util.AbstractDriver;
import pers.biao.mingyi_automation.util.ExcelUtil;
import pers.biao.mingyi_automation.util.Log4j2Util;
import pers.biao.mingyi_automation.util.PropertiesUtil;

import static pers.biao.mingyi_automation.pages.AbstractPage.resultFlag;
import static pers.biao.mingyi_automation.pages.AbstractPage.errMessage;

import java.io.IOException;

public class TestSuite extends AbstractDriver{
	private KeyWordAction kAction;
	private String className;
	private String action;
	private String value;
	private String step;
	private String testCaseID;
	private String testCaseFlag;
	private int testCaseCount;
	private int testFirstStep;
	private int testLastStep;
	private static Logger logger = Log4j2Util.initLog4j2(TestSuite.class.getName());
	
	@BeforeTest
	public void setUp() throws Exception{
		kAction = new KeyWordAction(driver);
		ExcelUtil.setExcelPath(PropertiesUtil.getUserStrValue("excelPath"));
	}
	
	@Test
	public void runTest() throws InterruptedException, ClassNotFoundException, NoSuchMethodException, SecurityException, NumberFormatException, IOException{
		
		testCaseCount = ExcelUtil.getRowCount("测试用例集合");
		logger.info("总用例数: {}",testCaseCount);
		
		for(int testCaseNo = 1; testCaseNo<=testCaseCount; testCaseNo++){
			logger.info("执行第 {}条用例!",testCaseNo);
			testCaseID = ExcelUtil.getCellValue("测试用例集合", testCaseNo, PropertiesUtil.getUserIntValue("CaseSet_CaseID"));
			logger.info("用例名称: {}",testCaseID);
			testCaseFlag = ExcelUtil.getCellValue("测试用例集合", testCaseNo, PropertiesUtil.getUserIntValue("CaseSet_RunOrNot"));
			logger.info("是否执行该条用例: {}",testCaseFlag);
			
			if(testCaseFlag.equalsIgnoreCase("Y")){
				testFirstStep = ExcelUtil.getFirstRowContainsTestCaseId("测试用例", testCaseID, PropertiesUtil.getUserIntValue("CaseID"));
				logger.info("用例开始行数: {}",testFirstStep);
				testLastStep = ExcelUtil.getAllCaseStepRow("测试用例", testCaseID, PropertiesUtil.getUserIntValue("CaseID"))+testFirstStep-1;
				logger.info("用例结束行数: {}",testLastStep);
				logger.info("用例总步数: {}",ExcelUtil.getAllCaseStepRow("测试用例", testCaseID, PropertiesUtil.getUserIntValue("CaseID")));
				
				while(testFirstStep<=testLastStep){
					className = ExcelUtil.getCellValue("测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Page"));
					action = ExcelUtil.getCellValue("测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Action"));
					value = ExcelUtil.getCellValue("测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Value"));
					step = ExcelUtil.getCellValue("测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Step"));
					logger.info("第 {}步: {} {} {}",step,className,action,value);
					resultFlag = true;
					kAction.executeAction(className, action, value);
					logger.info("执行结果: {}",resultFlag);
					if(resultFlag){
						ExcelUtil.writeXlsx(PropertiesUtil.getUserStrValue("excelPath"),"测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Result"), "pass");
						ExcelUtil.writeXlsx(PropertiesUtil.getUserStrValue("excelPath"),"测试用例集合", testCaseNo, PropertiesUtil.getUserIntValue("CaseSet_Result"), "pass");
					}else {
						ExcelUtil.writeXlsx(PropertiesUtil.getUserStrValue("excelPath"),"测试用例", testFirstStep, PropertiesUtil.getUserIntValue("Result"), errMessage);
						ExcelUtil.writeXlsx(PropertiesUtil.getUserStrValue("excelPath"),"测试用例集合", testCaseNo, PropertiesUtil.getUserIntValue("CaseSet_Result"), "failed");
						break;
					}
					testFirstStep++;
				}
			}
		}
	}
	
	@AfterTest
	public void testNotification(){
		logger.info("Congratulation to you!! Test Over!!");
	}
}
