package com.itacademy;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelTest {
        @DataProvider(name = "excelData")
        public Object[][] excelDataProvider() throws IOException {
            Object[][] arrObj = getExcelData("src/test/resources/excel/test.xlsx","Sheet1");
            return arrObj;
        }
        public String[][] getExcelData(String fileName, String sheetName) throws IOException {
            String[][] data = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
                XSSFSheet sheet = workbook.getSheet(sheetName);
                XSSFRow row = sheet.getRow(0);
                int noOfRows = sheet.getPhysicalNumberOfRows();
                int noOfCols = row.getLastCellNum();
                Cell cell;
                data = new String[noOfRows - 1][noOfCols];

                for (int i = 1; i < noOfRows; i++) {
                    for (int j = 0; j < noOfCols; j++) {
                        row = sheet.getRow(i);
                        cell = row.getCell(j);
                        data[i - 1][j] = cell.getStringCellValue();
                    }
                }
            } catch (Exception e) {
                System.out.println("The exception is: " + e.getMessage());
            }
            return data;
        }
        @Test(dataProvider = "excelData")
        public void search(String keyWord1, String keyWord2) {
            System.out.println(keyWord1 + " " + keyWord2);
    }
}
