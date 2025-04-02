package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.driverFactory;

public class StackPage {
	WebDriver driver;
	
	public StackPage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='stack']")
	@CacheLookup
	WebElement StackGetStarted;

	@FindBy(xpath = "//a[text()='Operations in Stack']")
	@CacheLookup
	WebElement OperationsInStack;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	@CacheLookup
	WebElement Tryhere;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	public WebElement RunBtn;

	@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
	@CacheLookup
	public WebElement TryEditor;

	@FindBy(xpath = "//*[@id='output']")
	@CacheLookup
	WebElement consoleOutput;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	@CacheLookup
	WebElement StackPracticeQns;

	@FindBy(xpath = "//a[text()='Implementation']")
	@CacheLookup
	WebElement Implementation;

	@FindBy(xpath = "//a[text()='Applications']")
	@CacheLookup
	WebElement Applications;
	
	public void StackGetStarted() {
		StackGetStarted.click();
	}

	public void OperationInStack() {
		OperationsInStack.click();
	}

	public void Tryhere() {
		Tryhere.click();
	}

	public void RunBtn() {
		RunBtn.click();
	}

	public void EmptytryEditor() {
		Actions actions = new Actions(driver);
		actions.moveToElement(TryEditor).click().sendKeys("").build().perform();
	}

	public String alertMessage() {
		return driver.switchTo().alert().getText();
	}

	public String consoleOutput() {
		return consoleOutput.getText();
	}

	public void StackPracticeQuestions() {
		StackPracticeQns.click();
	}

	public void Implementation() {
		Implementation.click();
	}

	public void Applications() {
		Applications.click();
	}

}