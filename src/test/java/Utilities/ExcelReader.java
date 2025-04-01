package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private static Workbook workbook;

    // Load the Excel file
    public static void loadExcel(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
    }

    // Get data from a specific cell
    public static String getCellData(String sheetName, int row, int column) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet != null) {
            Row rowData = sheet.getRow(row);
            if (rowData != null) {
                Cell cell = rowData.getCell(column);
                if (cell != null) {
                    return cell.toString();
                }
            }
        }
        return "";
    }

    // Get total rows in a sheet
    public static int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return (sheet != null) ? sheet.getLastRowNum() : 0;
    }
}