package PageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import DriverFactory.driverFactory;
import Utilities.Excelreaderpython;
import Utilities.LoggerReader;

public class ArrayPage {

	WebDriver driver;
	Excelreaderpython python = new Excelreaderpython();
	String relativePath = "src/test/resources/Testdata/Excel_Login_Pythoncode.xlsx";

	public ArrayPage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='array']")
	@CacheLookup
	WebElement ArrayGetStart;

	@FindBy(xpath = "//a[text()='Arrays in Python']")
	@CacheLookup
	WebElement Arrays_Python;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	@CacheLookup
	WebElement TryHere;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	@CacheLookup
	public WebElement TryEditor;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	public WebElement Run;

	@FindBy(xpath = "//a[text()='Arrays Using List']")
	@CacheLookup
	WebElement Arrays_Using_List;

	@FindBy(xpath = "//a[text()='Basic Operations in Lists']")
	@CacheLookup
	WebElement Basic_Operation;

	@FindBy(xpath = "//a[text()='Applications of Array']")
	@CacheLookup
	WebElement Applications_Of_Array;

	@FindBy(xpath = "//*[@id=\"content\"]/a")
	@CacheLookup
	WebElement Practice_Questions;

	@FindBy(xpath = "//a[text()='Search the array']")
	@CacheLookup
	WebElement SearchThe_Array;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	public WebElement Submit;

	@FindBy(xpath = "//a[text()='Max Consecutive Ones']")
	@CacheLookup
	WebElement MaxConsecutive_Ones;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	@CacheLookup
	WebElement MaxConsecutiveOnes_Question;

	@FindBy(xpath = "//a[text()='Find Numbers with Even Number of Digits']")
	@CacheLookup
	WebElement Find_Numbers_Evennumber_Digits;

	@FindBy(xpath = "//a[text()='Squares of  a Sorted Array']")
	@CacheLookup
	WebElement SquaresOf_SortedArray;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	@CacheLookup
	WebElement SquaresOfSortedArray_Question;

	@FindBy(className = ("CodeMirror"))
	@CacheLookup
	public WebElement codeMirrorDiv;

	public void ArrayGetStarted() {
		ArrayGetStart.click();
	}

	public void ArraysPython() {
		Arrays_Python.click();
	}

	public void Tryherebtn() {
		TryHere.click();
	}

	public void TryEditorNocode() {
		Actions actions = new Actions(driver);
		actions.moveToElement(TryEditor).click().sendKeys("").build().perform();
	}

	public void RunBtn() {
		Run.click();
	}

	public void enterPythonCode(String code) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(TryEditor));

			Actions actions = new Actions(driver);
			actions.moveToElement(TryEditor).click().perform();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", code);

			LoggerReader.info("Successfully entered code: " + code);
		} catch (Exception e) {
			LoggerReader.error("Failed to enter code: " + e.getMessage());
		}
	}

	public String getAlertTextAndAccept() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String alertText = alert.getText();
			alert.accept(); // close the alert
			return alertText;
		} catch (NoAlertPresentException e) {
			return ""; // No alert appeared
		}
	}

	public void ArraysList() {
		Arrays_Using_List.click();
	}

	public void Basicoperation() {
		Basic_Operation.click();
	}

	public void BasicOperationText() {
		Actions actions = new Actions(driver);
		actions.moveToElement(TryEditor).click().build().perform();
	}

	public void ApplicationsArray() {
		Applications_Of_Array.click();
	}

	public void Practicequestions() {
		Practice_Questions.click();
	}

	public void Searchthearray() {
		SearchThe_Array.click();
	}

	public void MaxConsecutiveOnes() {
		MaxConsecutive_Ones.click();
	}

	public void FindEvenNumbers() {
		Find_Numbers_Evennumber_Digits.click();
	}

	public void SquaresSortedArray() {
		SquaresOf_SortedArray.click();
	}

	public void PracticeTryEditor() {
		codeMirrorDiv.click();
	}

	public void ClearTryEditor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].CodeMirror.setValue('');", codeMirrorDiv);
		System.out.println("Code input field cleared successfully");
	}

	public void entercode(String code) {
		Actions actions = new Actions(driver);
		actions.sendKeys(code).perform();
	}

}