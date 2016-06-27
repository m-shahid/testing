package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;

import logger.FrameworkLogger;
import logger.FrameworkLogger.LEVEL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static final String EXECUTION_BATCH_SHEET_PATH = "D:\\shahid\\GWC_Execution Sheet.xlsx"; 
	private static final String EXECUTION_BATCH_SHEET_NAME = "TestScripts";
	private static final int TEST_SCRIPT_NAME_COLUMN = 1;
	private static final int RUN_MODE_COLUMN = 3;
	
	private LinkedHashMap<String, String> executionBatchMap = new LinkedHashMap<String, String>();
	
	
	public ExcelReader(){
		
	}
	
	public LinkedHashMap<String, String> readExecutionBatch(){
		
		String key = null;
		String value = null;
		
		try{
			
			FileInputStream fileStream = new FileInputStream(new File(EXECUTION_BATCH_SHEET_PATH));
			XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
			
			System.out.println("Number of sheets : "+workbook.getNumberOfSheets());
			
			for(int i=0; i<workbook.getNumberOfSheets(); i++){
				
				XSSFSheet sheet = workbook.getSheetAt(i);
				String sheetName = sheet.getSheetName();
				
				if(sheetName.equalsIgnoreCase(EXECUTION_BATCH_SHEET_NAME)){
					
					System.out.println("Total rows in sheet : "+sheet.getLastRowNum());
					
					Iterator rowIterator = sheet.rowIterator();
					
					while(rowIterator.hasNext()){
						
						XSSFRow row = (XSSFRow)rowIterator.next();
						
						System.out.println("Total coulmns in row :"+row.getLastCellNum());
						
						XSSFCell cell = row.getCell(TEST_SCRIPT_NAME_COLUMN);
						cell.setCellType(XSSFCell.CELL_TYPE_STRING);
						key = cell.getStringCellValue();
						
						cell = row.getCell(RUN_MODE_COLUMN);
						cell.setCellType(XSSFCell.CELL_TYPE_STRING);
						value = cell.getStringCellValue();
						
						executionBatchMap.put(key, value);
					}
				}
			}
			
			return executionBatchMap;
			
		}catch(Exception msg){
			FrameworkLogger.log("Exception while reading execution batch sheet", LEVEL.fatal, ExcelReader.class);
			return null;
		}
	}
}
