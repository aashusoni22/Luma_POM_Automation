package com.auto.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.auto.qa.base.BaseClass;

public class TestUtil extends BaseClass {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "E:\\QA Automation Classes\\CreateAccount.xlsx";
	static Workbook book;
	static Sheet sheet;

	public void action(WebElement a) {
		Actions actions = new Actions(driver);
		actions.moveToElement(a).build().perform();
	}

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
	    FileInputStream file = null;
	    try {
	        file = new FileInputStream(TESTDATA_SHEET_PATH);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    try {
	        book = WorkbookFactory.create(file);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    sheet = book.getSheet(sheetName);
	    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    for (int i = 0; i < sheet.getLastRowNum(); i++) {
	        for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
	            Cell cell = sheet.getRow(i + 1).getCell(k);
	            if (cell != null) {
	                data[i][k] = cell.toString();
	            } else {
	                data[i][k] = "";
	            }
	        }
	    }
	    return data;
	}

	//Screenshot 
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
