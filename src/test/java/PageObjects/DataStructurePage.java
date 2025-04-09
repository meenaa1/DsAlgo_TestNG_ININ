package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driverFactory;

public class DataStructurePage {

	WebDriver driver;
	WebDriverWait wait;

	public DataStructurePage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	WebElement GetstartedButton;

	@FindBy(xpath = "//a[@href='time-complexity']")
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

	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	@CacheLookup
	WebElement tryEditorInp;
		
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

	
}