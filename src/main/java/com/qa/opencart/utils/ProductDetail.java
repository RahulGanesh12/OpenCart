package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductDetail {

	public static Object[][] getProductDetails(String SheetName) throws FileNotFoundException, IOException {
		FileInputStream file = new FileInputStream("C://Users//Admin//OneDrive//Documents//RegistrationTestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook xw = new XSSFWorkbook(file);
		XSSFSheet xs = xw.getSheet(SheetName);
		int lastrow = xs.getLastRowNum();
		int lastcell = xs.getRow(0).getLastCellNum();
		Object[][] productArray = new Object[lastrow][lastcell];
		for (int i = 1; i <= lastrow; i++) {
			XSSFRow xr = xs.getRow(i);
			for (int j = 0; j < lastcell; j++) {
				productArray[i - 1][j] = xr.getCell(j).toString();
			}
		}
		return productArray;
	}
}
