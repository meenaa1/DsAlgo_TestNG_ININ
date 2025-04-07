package PageObjects;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
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
	String relativePath = "src/test/resources/TestData/Excel_Login_Pythoncode.xlsx";
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

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	@CacheLookup
	WebElement dropdownMenu;

	@FindBy(xpath = "//a[text()='Graph']")
	@CacheLookup
	WebElement selectGraph_DropdownMenu;

	@FindBy(xpath ="//a[@href='graph']")
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
	public
	WebElement tryEditorInp;

	@FindBy(className = "CodeMirror")
	@CacheLookup
	public WebElement tryEditor;

	@FindBy (xpath="//button[text()='Run']")
	@CacheLookup
	public WebElement RunBtn;
	   
	@FindBy (xpath="//button[@type='button']") 
	WebElement RunBtnenabled;

	@FindBy(xpath = "//pre[@id='output']")
	@CacheLookup
	WebElement OutPutmsg;

	@FindBy(xpath = "//a[text()='Practice Questions']")
	@CacheLookup
	WebElement Practice_QuestionsLink;

	@FindBy(linkText = "Graph Representations")
	@CacheLookup
	WebElement GraphRepresentationsLink;
	
	@FindBy(xpath= ".//textarea")
	@CacheLookup
	WebElement textArea;
	
	@FindBy(xpath = "//a[text()='Sign out']")
	@CacheLookup
	WebElement SignOut;
	
	//Excelreaderpython readExcelreaderpython =new Excelreaderpython();
		
	public void GraphGetStarted() {
		GraphGetStarted.click();
	}

	public void graphGetStarted() {
	    try {
	        GraphGetStarted.click();
	    } catch (StaleElementReferenceException e) {
	        // Re-find and retry once
	        WebElement graphStartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='graph']")));
	        graphStartButton.click();
	    }

	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.titleContains("Graph"));
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
	 public boolean RunbuttonEnabled() {
	       return RunBtnenabled.isEnabled();   
	 }
	       

	public void EmptytryInput() {
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditorTxt).click().sendKeys("").build().perform();
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
		return OutPutmsg.getText();
	}

	public void GraphRepresentationlink() {
		GraphRepresentationsLink.click();
	}

	public void PracticeQns() {
		Practice_QuestionsLink.click();
	}
	    
   	public void signOut() {
		SignOut.click();
	}

	public void navigateback() {
		driver.navigate().back();
	}

	  public void entercode(String code) {    	
	    	Actions actions = new Actions(driver);
			actions.sendKeys(code).perform();
	   }
	
	
	      
}