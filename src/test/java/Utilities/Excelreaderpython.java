package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreaderpython {
	String[][] credentials = new String[100][100];
	ArrayList<String> practice = new ArrayList<String>();
	int i = 0, j = 0;

	public String readExcelSheet(int rowvalue, int colvalue, String sheetname) throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
		File Excelfile = new File(path);
		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		List<List<String>> credentials = new ArrayList<>();

		for (Row currRow : sheet) {
			List<String> rowValues = new ArrayList<>();
			for (Cell currCell : currRow) {
				rowValues.add(currCell.toString()); // Convert cell to string safely
			}
			credentials.add(rowValues);
		}
		workbook.close();

		// Validate index before accessing
		if (rowvalue >= credentials.size() || colvalue >= credentials.get(rowvalue).size()) {
			throw new IndexOutOfBoundsException(
					"Requested row " + rowvalue + ", column " + colvalue + " is out of bounds.");
		}

		return credentials.get(rowvalue).get(colvalue);
	}

	public String getusername(int rownumber) throws IOException {
		String username = null;
		String sheetname = "Sheet1";
		username = readExcelSheet(rownumber, 0, sheetname);
		LoggerReader.info("Username is:" + username);
		return username;
	}

	public String getpassword(int rownumber) throws IOException {
		String password = null;
		String sheetname = "Sheet1";
		password = readExcelSheet(rownumber, 1, sheetname);
		LoggerReader.info("Password is:" + password);
		return password;
	}

	public String getconfirmpassword(int rownumber) throws IOException {
		String confirmpassword = null;
		String sheetname = "Sheet1";
		confirmpassword = readExcelSheet(rownumber, 2, sheetname);
		LoggerReader.info("Confirm Password is:" + confirmpassword);
		return confirmpassword;
	}

	public String getPycode(int rownumber) throws IOException {
		String Pycode = null;
		String sheetname = "pythonCode";
		Pycode = readExcelSheet(rownumber, 0, sheetname);
		LoggerReader.info("Try here code is:" + Pycode);
		return Pycode;
	}

	public String gettryheremessage(int rownumber) throws IOException {
		String Output = null;
		String sheetname = "pythonCode";
		Output = readExcelSheet(rownumber, 1, sheetname);
		LoggerReader.info("Expected output is:" + Output);
		return Output;
	}

	public ArrayList<String> getArraypracticeques(int rownumber) throws IOException {
		ArrayList<String> ArrayPracticeQ = new ArrayList<String>();
		String sheetname = "ArrayPracticeQ";
		ArrayPracticeQ = readpracticeques(rownumber, 0, sheetname);
		LoggerReader.info("Practice Question:" + ArrayPracticeQ);
		return ArrayPracticeQ;
	}

	public String getPQoutput(int rownumber) throws IOException {
		String PracticeQnoutput = null;
		String sheetname = "ArrayPracticeQ";
		PracticeQnoutput = readExcelSheet(rownumber, 1, sheetname);
		PracticeQnoutput = PracticeQnoutput.replace("Output", "");
		LoggerReader.info("Expected output is:" + PracticeQnoutput);
		return PracticeQnoutput;
	}

	public ArrayList<String> readpracticeques(int rowvalue, int colvalue, String sheetname) throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
		File Excelfile = new File(path);

		FileInputStream Fis = new FileInputStream(Excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		XSSFSheet sheet = workbook.getSheet(sheetname);

		Iterator<Row> row = sheet.rowIterator();

		while (row.hasNext()) {

			Row currRow = row.next();
			Iterator<Cell> cell = currRow.cellIterator();

			while (cell.hasNext()) {
				Cell currCell = cell.next();
				i = currCell.getRowIndex();
				j = currCell.getColumnIndex();
				credentials[i][j] = currCell.getStringCellValue();
			}
		}
		workbook.close();
		practice.add(credentials[rowvalue][colvalue]);
		System.out.println(practice);
		return practice;
	}

}