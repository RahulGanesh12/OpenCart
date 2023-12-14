package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegistrationTestData {
	public static Object[][] data(String SheetName) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\OneDrive\\Documents\\RegistrationTestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook xw = new XSSFWorkbook(file);
		XSSFSheet xs = xw.getSheet(SheetName);
		int lastRow = xs.getLastRowNum();
		int lastCell = xs.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for (int i = 1; i <= lastRow; i++) {
			XSSFRow xr = xs.getRow(i);
			for (int j = 0; j < lastCell; j++) {
				obj[i - 1][j] = xr.getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
