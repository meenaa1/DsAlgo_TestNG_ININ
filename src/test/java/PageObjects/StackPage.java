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
import Utilities.LoggerReader;

public class StackPage {
	WebDriver driver;
	WebDriverWait wait;
	String relativePath = "src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
	
	public StackPage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn")
	@CacheLookup
	WebElement GetStartedIntro;
	
	@FindBy(xpath = "//h5[text()='Stack']/../a")
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

	@FindBy (xpath="//button[@type='button']") 
	@CacheLookup
	WebElement RunBtnenabled;
	
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

	public String RunBtnText() {
		return RunBtn.getText();
	}

	public void RunBtn() {
		RunBtn.click();
	}
	
	 public boolean RunbuttonEnabled() {
	       return RunBtnenabled.isEnabled();   
	 }

	public void EmptytryEditor() {
		Actions actions = new Actions(driver);
		actions.moveToElement(TryEditor).click().sendKeys("").build().perform();
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
	    } catch ( NoAlertPresentException e) {
	        return ""; // No alert appeared
	    }
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

	 public void entercode(String code) {    	
	    	Actions actions = new Actions(driver);
			actions.sendKeys(code).perform();
	   }
	

}