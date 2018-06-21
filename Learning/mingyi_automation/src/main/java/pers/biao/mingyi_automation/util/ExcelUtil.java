package pers.biao.mingyi_automation.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private static InputStream inputStream;
	private static OutputStream outputStream;
	private static XSSFWorkbook workbook;
	private static XSSFSheet xssfSheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	/*
	 * 设置excel路径
	 */
	public static void setExcelPath(String filePath){
		try {
			inputStream  = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * 读取对应sheet页,和坐标的元素,并格式化输出
	 */
	public static String getCellValue(String sheetName, int rowNum, int columnNum){
		xssfSheet = workbook.getSheet(sheetName);
		
		cell = xssfSheet.getRow(rowNum).getCell(columnNum);
		
		return getStringValue(cell);
	}
	
	/*
	 * 获取当前sheet页总用例数=(总行数-1)
	 */
	public static int getRowCount(String sheetName){
		xssfSheet = workbook.getSheet(sheetName);
		int rowCount = xssfSheet.getLastRowNum();
		return rowCount;
	}
	
	/*
	 * 获取第一次包含testCaseID的开始的行号
	 */
	public static int getFirstRowContainsTestCaseId(String sheetName, String testCaseID, int columnNum){
		int i;
		xssfSheet = workbook.getSheet(sheetName);
		for(i = 0;i<getRowCount(sheetName);i++){
			if(getCellValue(sheetName, i, columnNum).equalsIgnoreCase(testCaseID)){
				break;
			}
		}
		return i;
	}
	
	/*
	 * 获取某个测试用例的所有步数
	 */
	public static int getAllCaseStepRow(String sheetName,String testCaseID,int columnNum){
		int caseStepRow = 0;
		xssfSheet = workbook.getSheet(sheetName);
		
		for(int i = getFirstRowContainsTestCaseId(sheetName,testCaseID,columnNum);i<=getRowCount(sheetName);i++){
			if(getCellValue(sheetName, i, columnNum).equalsIgnoreCase(testCaseID)){
				caseStepRow++;
			}
		}
		return caseStepRow;
	}
	
	/*
	 * 向excel中写入数据,仅支持xlsx的excel
	 */
	public static void writeXlsx(String filePath,String sheetName, int rowNum, int cloumnNum, String result){
		try {
			outputStream = new FileOutputStream(filePath);
			xssfSheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		row = xssfSheet.getRow(rowNum);
		cell = row.getCell(cloumnNum);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue(result);
		
		try {
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*
	 * 格式化输出cell
	 */
	private static String getStringValue(XSSFCell cell){
		String string = null;
			
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BLANK:
				string = "";
				break;
			case Cell.CELL_TYPE_NUMERIC:
				cell.setCellType(Cell.CELL_TYPE_STRING);
				string = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				string = cell.getBooleanCellValue()? "TRUE":"FALSE";
				break;
			case Cell.CELL_TYPE_STRING:
				string = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				string = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_ERROR:
				string = cell.getErrorCellString();
				break;
			default:
				string = "Unknown Cell Type" + cell.getCellType();
				break;
			}
			return string;
		}
}
