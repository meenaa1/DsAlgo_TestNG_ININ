package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreaderpython {
	
	public String readExcelSheet(int rowvalue, int colvalue, String sheetname) throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
		File Excelfile = new File(path);

		try (FileInputStream fis = new FileInputStream(Excelfile); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetname);
			List<List<String>> credentials = new ArrayList<>();
			for (Row currRow : sheet) {
				List<String> rowValues = new ArrayList<>();
				for (Cell currCell : currRow) {
					rowValues.add(currCell.toString());
				}
				credentials.add(rowValues);
			}
			if (rowvalue >= credentials.size() || colvalue >= credentials.get(rowvalue).size()) {
				throw new IndexOutOfBoundsException(
						"Requested row " + rowvalue + ", column " + colvalue + " is out of bounds.");
			}
			return credentials.get(rowvalue).get(colvalue);
		}
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
		ArrayList<String> practiceList = new ArrayList<>();
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";

		try (FileInputStream fis = new FileInputStream(new File(path)); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rowvalue);
			if (row != null) {
				Cell cell = row.getCell(colvalue);
				if (cell != null) {
					practiceList.add(cell.toString());
				}
			}
		}
		System.out.println(practiceList);
		return practiceList;
	}

	public String getconfirmpassword(int rownumber) throws IOException {
		String Confirmpassword = null;
		String sheetname = "Sheet1";
		Confirmpassword = readExcelSheet(rownumber, 2, sheetname);
		LoggerReader.info("Password is:" + Confirmpassword);
		return Confirmpassword;
	}

}
