package PageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

public class GraphPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GraphPage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn")
	@CacheLookup
	WebElement GetStarted;
	
	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	WebElement GraphGetStarted;

	@FindBy(xpath = "//title[text()='Graph']")
	@CacheLookup
	WebElement GraphTitle;

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	@CacheLookup
	WebElement dropdownMenu;

	@FindBy(xpath = "//a[text()='Graph']")
	@CacheLookup
	WebElement selectGraph_DropdownMenu;

	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	WebElement GraphLink;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	@CacheLookup
	WebElement TryhereBtn;

	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	@CacheLookup
	WebElement tryEditorTxt;

	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	@CacheLookup
	WebElement tryEditorInp;

	@FindBy(className = "CodeMirror")
	@CacheLookup
	public WebElement tryEditor;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	public WebElement RunBtn;

	@FindBy(xpath = "//pre[@id='output']")
	@CacheLookup
	WebElement OutPutmsg;

	@FindBy(linkText = "Practice Questions")
	@CacheLookup
	WebElement Practice_QuestionsLink;

	@FindBy(linkText = "Graph Representations")
	@CacheLookup
	WebElement GraphRepresentationsLink;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	@CacheLookup
	WebElement SignOut;
		
	public void GraphGetStarted() {
		GraphGetStarted.click();
	}

	public void dropdownMenuClick() {
		dropdownMenu.click();
	}

	public void ClickGraphFromDropdown() {
		selectGraph_DropdownMenu.click();
	}

	public void Graphlink() {
		GraphLink.click();
	}

	public void TryHereButton() {
		TryhereBtn.click();
	}

	public String RunBtnText() {
		return RunBtn.getText();
	}

	public void Run() {
		RunBtn.click();
	}

	public void EmptytryInput() {
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditorTxt).click().sendKeys("").build().perform();
	}

	public String alertMessage() {
		return driver.switchTo().alert().getText();
	}

	public String Outputmsg() {
		return OutPutmsg.getText();
	}

	public void GraphRepresentationlink() {
		GraphRepresentationsLink.click();
	}

	public void PracticeQns() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Practice_QuestionsLink);
		wait.until(ExpectedConditions.elementToBeClickable(Practice_QuestionsLink)).click();
	}

	public void enterPythonCode(String code) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(tryEditorInp));
	        tryEditorInp.clear();  // Sometimes this might fail for non-standard editors like CodeMirror
	        tryEditorInp.sendKeys(code);
	        LoggerReader.info("Code entered into TryEditor: " + code);
	    } catch (StaleElementReferenceException e) {
	        LoggerReader.error("StaleElementReferenceException caught. Re-locating the tryEditorInp element.");
	        PageFactory.initElements(driver, this); // Re-initialize the elements
	        tryEditorInp.sendKeys(code); // Retry input
	    } catch (Exception e) {
	        LoggerReader.error("Exception while entering Python code: " + e.getMessage());
	    }
	}
	public void signOut() {
		SignOut.click();
	}
	
}