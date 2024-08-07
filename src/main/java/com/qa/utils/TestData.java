package com.qa.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestData {

    public static Map<Integer,String>key=new Hashtable<>();
    public static Map<Integer,String>values=new HashMap<>();
    static Map<String,String>datacomb=new Hashtable<>();
    static File  file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testData.xlsx");
    public static void readTestData(String testCaseID) throws FileNotFoundException {
        try {
            Workbook wb = WorkbookFactory.create(file);
            for(Sheet sheet:wb) {
                Sheet sh = wb.getSheet(sheet.getSheetName());
                for (Row row : sh) {
                    Cell firstCell = row.getCell(0);
                    String firstCellValue = firstCell.getStringCellValue();
                    if (firstCellValue.equalsIgnoreCase("testcaseID")) {
                        for (Cell cell : row) {
                            key.put(cell.getColumnIndex(), cell.getStringCellValue());
                        }
                    } else if (firstCellValue.equalsIgnoreCase(testCaseID)) {
                        for (Cell cell : row) {
                            values.put(cell.getColumnIndex(), cell.getStringCellValue());
                        }
                    }
                }
                for (Integer index : values.keySet()) {
                    if (!values.get(index).equals("")) {
                        datacomb.put(key.get(index), values.get(index));
                    }
                }
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static String get(String key) {
        return datacomb.get(key);
    }
}

/*
public class WriteintoExcel {
    public static void main(String[] args) throws IOException {
        String path = "D://DemoFile.xlsx";
        FileInputStream fs = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fs);
        Sheet sheetl = wb.getSheetAt(0);
        int lastRow = sheetl.getLastRowNum();
        for(int i=0; i<=lastRow; i++) {
            Row row = sheet1.getRow(i);
            Cell cell = row.createCell(2);
            cell.setCellValue ("WriteintoExcel");
        }
        FileOutputStream fos new FileOutputStream(path); wb.write(fos);
        fos.close();
    }
*/