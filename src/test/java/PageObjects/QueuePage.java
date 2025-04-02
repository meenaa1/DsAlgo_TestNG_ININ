package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DriverFactory.driverFactory;

public class QueuePage {
 WebDriver driver;
		
public QueuePage() {
			driver = driverFactory.getDriver();
			PageFactory.initElements(driver, this);
}
		
		@FindBy(className = "btn")
		@CacheLookup
		WebElement GetStartedIntro;
		
		@FindBy(xpath = "//a[@href='queue']")
		@CacheLookup
		WebElement queueGetStartedBtn;

		@FindBy(xpath = "//a[text()='Implementation of Queue in Python']")
		@CacheLookup
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

		public void clickRunButton() {
			RunButton.click();
		}

		public void EmptytryEditor() {
			Actions actions = new Actions(driver);
			actions.moveToElement(tryEditor).click().sendKeys("").build().perform();
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
		
	}


