package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelreaderpython {

	public static int totalRow = 0;

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws EncryptedDocumentException, IOException {

		Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row = null;
		Cell cell = null;
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
			row = sheet.getRow(currentRow);
			short totalColumn = row.getLastCellNum();
			Map<String, String> columnMapData = new LinkedHashMap<String, String>();
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
				cell = row.getCell(currentColumn);
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapData.put(columnHeaderName, cell.getStringCellValue());
			}
			excelRows.add(columnMapData);
		}
		return excelRows;
	}
	public int countRow() {
		return totalRow;
	}
}
