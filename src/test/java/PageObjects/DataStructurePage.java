package PageObjects;

import java.time.Duration;

import org.openqa.selenium.Alert;
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

public class DataStructurePage {

	private WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement DSAlgoGetstart;
	@CacheLookup

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement GetstartedButton;
	
	@FindBy(className = "list-group-item")
	WebElement timeComplexity;

	@FindBy(xpath = "//a[@href='/tryEditor']")
	@CacheLookup
	WebElement TryhereBtn;

	@FindBy(xpath = "//div[@class='CodeMirror-scroll']")
	public WebElement tryEditorTextBox;
	
    @FindBy(className = "CodeMirror")
	@CacheLookup
	public WebElement tryEditor;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	public WebElement RunBtn;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement PracticeQuestions;

	@FindBy(className = "btn")
	WebElement GetStarted;

	@FindBy(xpath = "//*[@id='navbarCollapse']/div[2]/ul/a[3]")
	@CacheLookup
	WebElement signin;

	@FindBy(id = "id_username")
	@CacheLookup
	WebElement userName;

	@FindBy(id = "id_password")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//*[@value='Login']")
	@CacheLookup
	WebElement LoginBtn;

	@FindBy(xpath = "//*[@class ='alert alert-primary']")
	@CacheLookup
	WebElement LoginStatus;

	@FindBy(xpath = "//pre[@id='output']")
	@CacheLookup
	WebElement OutPutmsg;

	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	@CacheLookup
	WebElement tryEditorInp;

	@FindBy(xpath = "//*[@id='navbarCollapse']/div[2]/ul/a[3]")
	@CacheLookup
	WebElement SignOut;

	public DataStructurePage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void GetStarted() {
		DSAlgoGetstart.click();
	}

	public void signIn() {
		signin.click();
	}

	public void clickLogin(String username, String password) {
		userName.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
	}

	public String getStatus() {
		return LoginStatus.getText();
	}

	public void checkGetstarted() {
		GetstartedButton.click();
	}

	public void checkTimeComplexity() {
		timeComplexity.click();
	}

	public void tryhere() {

		TryhereBtn.click();
	}

	public void checkPractice() {

		PracticeQuestions.click();
	}

	public void enterCode() {

		tryEditorTextBox.clear();

		tryEditorTextBox.sendKeys(" ");
	}

	public String RunBtnText() {
		return RunBtn.getText();
	}

	public void Run() {

		RunBtn.click();
	}

	public void EmptytryInput() {
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditorTextBox).click().sendKeys("").build().perform();
	}

	public String alertMessage() {
		return driver.switchTo().alert().getText();
	}

	public void Invalidinput() {

		RunBtn.click();
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

	public String Outputmsg() {
		return OutPutmsg.getText();
	}
	public void signOut() {
		SignOut.click();
	}
}
