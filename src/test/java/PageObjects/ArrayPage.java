package PageObjects;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ArrayPage {
WebDriver driver;
Excelreaderpython python = new Excelreaderpython();
String relativePath = "src/test/resources/Testdata/Excel_Login_Pythoncode.xlsx";

public ArrayPage() {
driver = driverFactory.getDriver();
PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//button[text()='Get Started']")
@CacheLookup
WebElement DSAlgoGetStart;

@FindBy(xpath = "//a[text()='Sign in']")
@CacheLookup
WebElement Signin;

@FindBy(xpath = "//input[@name='username']")
@CacheLookup
WebElement Username;

@FindBy(xpath = "//input[@name='password']")
@CacheLookup
WebElement Password;

@FindBy(xpath = "//input[@type='submit']")
@CacheLookup
WebElement Login;

@FindBy(xpath = "//*[@class ='alert alert-primary']")
@CacheLookup
WebElement Login_Success;

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

@FindBy(id = "output")
@CacheLookup
WebElement TryEditor_Console;

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

@FindBy(xpath = "//pre[text()='Error occurred during submission']")
@CacheLookup
WebElement Errormessage;

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

@FindBy(xpath = "//a[text()='Sign out']")
@CacheLookup
WebElement Signout;

@FindBy(xpath = "//div[@class='alert alert-primary']")
@CacheLookup
WebElement logoutMsg;
public void DsAlgoStarting() {
DSAlgoGetStart.click();
}
public void Usersignin() {
Signin.click();
}
public void Entercredentials(String username, String password) {
Username.sendKeys(username);
Password.sendKeys(password);
}
public void Userlogin() {
Login.click();
}
public String LoginMessage() {
return Login_Success.getText();
}
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
public void InvalidPythoncode(String sheetName, int rowNumber) throws EncryptedDocumentException, IOException, InterruptedException {
Path filePath = Paths.get(relativePath).toAbsolutePath();
List<Map<String, String>> testDataMap = python.getData(filePath.toString(), sheetName);
String pcode = testDataMap.get(rowNumber).get("pyCode");
Actions actions = new Actions(driver);
actions.moveToElement(TryEditor).sendKeys(pcode).build().perform();
Run.click();

try {
// Wait for the alert to appear
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.alertIsPresent());

// Switch to the alert and accept (click OK)
Alert alert = driver.switchTo().alert();
alert.accept(); // Or alert.dismiss() if you want to dismiss the alert

} catch (NoAlertPresentException e) {
// No alert was present, continue with the test
System.out.println("No alert present.");
}
}
public String alertMessage() {
return driver.switchTo().alert().getText();
}
public void ValidPythoncode(String sheetName,int rowNumber) throws EncryptedDocumentException, IOException {
Path filePath = Paths.get(relativePath).toAbsolutePath();
List<Map<String, String>> testDataMap = python.getData(filePath.toString(), sheetName);
String pcode = testDataMap.get(rowNumber).get("pyCode");
Actions actions = new Actions(driver);
actions.moveToElement(TryEditor).sendKeys(pcode).build().perform();
}
public String GetConsoleOutput() {
return TryEditor_Console.getText();
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
driver.navigate().back();
Applications_Of_Array.click();
}
public void Practicequestions() {
Practice_Questions.click();
}
public void PracticeTryEditor() {
codeMirrorDiv.click();
}
public void PracticeNoCodeinput() {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].CodeMirror.setValue('');", codeMirrorDiv);
System.out.println("Code input field cleared successfully");
Run.click();
}
public void ValidInputPracticeQn(String sheetName,int rowNumber) throws EncryptedDocumentException, IOException {
Path filePath = Paths.get(relativePath).toAbsolutePath();
List<Map<String, String>> testDataMap = python.getData(filePath.toString(), sheetName);
String pcode = testDataMap.get(rowNumber).get("pyCode");
StringSelection stringSelection = new StringSelection(pcode);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

Actions actions = new Actions(driver);
actions.moveToElement(codeMirrorDiv).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)
.perform();
}
public void SearchArray() {
SearchThe_Array.click();
}
public String Errormsg() {
return Errormessage.getText();
}
public void Maxconsecutive() {
MaxConsecutive_Ones.click();
}
public void FindEvenNumbers() {
Find_Numbers_Evennumber_Digits.click();
}
public void SquaresSortedArray() {
SquaresOf_SortedArray.click();
}
public void ArraySigningout() {
Signout.click();
}
public String Logout() {
return logoutMsg.getText();
}
}
