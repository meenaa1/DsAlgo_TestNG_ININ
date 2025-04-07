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
import org.testng.Assert;

import DriverFactory.driverFactory;
import Utilities.LoggerReader;

public class QueuePage {
  WebDriver driver;
  WebDriverWait wait;
  String relativePath = "src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
		
public QueuePage() {
			driver = driverFactory.getDriver();
			PageFactory.initElements(driver, this);
}
		
		@FindBy(className = "btn")
		@CacheLookup
		WebElement GetStartedIntro;
		
		@FindBy(xpath = "//h5[text()='Queue']/../a")
		@CacheLookup
		WebElement queueGetStartedBtn;

		@FindBy(xpath = "//a[text()='Implementation of Queue in Python']")
		@CacheLookup
		public
		WebElement ImplementationOfQueueInPython;

		@FindBy(xpath = "//a[text()='Try here>>>']")
		@CacheLookup
		WebElement TryHere;

		@FindBy(xpath = "//*[@id=\"answer_form\"]/div/div/div[6]")
		@CacheLookup
		public WebElement tryEditor;

		@FindBy(xpath = "//button[@type='button']")
		@CacheLookup
		public WebElement RunButton;

		@FindBy (xpath="//button[@type='button']") 
		@CacheLookup
		WebElement RunButtonenabled;


		@FindBy(xpath = "//*[@id='output']")
		@CacheLookup
		public WebElement Outputmsg;

		@FindBy(xpath = "//a[text()='Practice Questions']")
		@CacheLookup
		WebElement QueuePracticeQns;

		@FindBy(xpath = "//a[text()='Implementation using collections.deque']")
		@CacheLookup
		WebElement ImplementationUsingCollectionsDequeue;

		@FindBy(xpath = "//a[text()='Implementation using array']")
		@CacheLookup
		WebElement ImplementationUsingArray;

		@FindBy(xpath = "//a[text()='Queue Operations']")
		@CacheLookup
		WebElement QueueOperations;

		public void GetStartedIntro() {
			GetStartedIntro.click();
		}

		public void clickQueueGetStartedBtn() {
			queueGetStartedBtn.click();
		}

		public void clickImplementationOfQueueInPython() {
			ImplementationOfQueueInPython.click();
		}

		public void clickTryHereBtn() {
			TryHere.click();
		}
		
		public String RunBtnText() {
			return RunButton.getText();
		}

		public void clickRunButton() {
			RunButton.click();
		}

		public boolean RunButtonEnabled() {

		       return RunButtonenabled.isEnabled();   

		 }
		public void EmptytryEditor() {
			Actions actions = new Actions(driver);
			actions.moveToElement(tryEditor).click().sendKeys("").build().perform();
		}

		public void enterPythonCode(String code) {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(tryEditor));
		        Actions actions = new Actions(driver);
		        actions.moveToElement(tryEditor).click().perform();
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
		
		public String Outputmsg() {
			return Outputmsg.getText();
		}

		public void clickQueuePracticeQuestionsBtn() {
			QueuePracticeQns.click();
		}

		public void clickImplementationUsingCollectionsDequeue() {
			ImplementationUsingCollectionsDequeue.click();
		}

		public void clickImplementationUsingArray() {
			ImplementationUsingArray.click();
		}

		public void clickQueueOperations() {
			QueueOperations.click();
		}

		 public void entercode(String code) {    	
		    	Actions actions = new Actions(driver);
				actions.sendKeys(code).perform();
		   }
		 
		//public void get(String tryherecode) {
			//return;
		//}

		
		
	}


