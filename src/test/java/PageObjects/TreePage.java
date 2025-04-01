package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driverFactory;

public class TreePage {

	WebDriver driver;
	WebDriverWait wait;

	public TreePage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(className = "btn")
	@CacheLookup
	WebElement GetStarted;

	@FindBy(xpath = "//a[@href='tree']")
	@CacheLookup
	WebElement TreeGetStarted;

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	@CacheLookup
	WebElement dropdownmenu;

	@FindBy(xpath = "//a[text()='Tree']")
	@CacheLookup
	WebElement selectTree_DropdownMenu;

	@FindBy(xpath = "//title[text()='Tree']")
	@CacheLookup
	WebElement titleTree;

	@FindBy(xpath = "//a[text()='Overview of Trees']")
	@CacheLookup
	WebElement overviewOfTrees;
	
	@FindBy(xpath = "//div[@class='CodeMirror-code']")
	@CacheLookup
	WebElement tryEditorInp;

	@FindBy(xpath = "//a[text()='Try here>>>']")
	@CacheLookup
	WebElement TryhereBtn;

	@FindBy(className = "CodeMirror")
	@CacheLookup
	public WebElement tryEditor;

	@FindBy(xpath = "//button[@type='button']")
	@CacheLookup
	public WebElement RunBtn;

	@FindBy(xpath = "//pre[@id='output']")
	@CacheLookup
	WebElement OutPutmsg;

	@FindBy(linkText = "Terminologies")
	@CacheLookup
	WebElement TerminologiesLink;

	@FindBy(linkText = "Types of Trees")
	@CacheLookup
	WebElement TypesOfTreeslink;

	@FindBy(linkText = "Tree Traversals")
	@CacheLookup
	WebElement TreeTraversals_link;

	@FindBy(linkText = "Traversals-Illustration")
	@CacheLookup
	WebElement Traversals_Illustration_Link;

	@FindBy(linkText = "Binary Trees")
	@CacheLookup
	WebElement BinmaryTreesLink;

	@FindBy(linkText = "Types of Binary Trees")
	@CacheLookup
	WebElement Types_ofBinaryTreesLink;

	@FindBy(linkText = "Implementation in Python")
	@CacheLookup
	WebElement Implementation_inPythonLink;

	@FindBy(linkText = "Binary Tree Traversals")
	@CacheLookup
	WebElement BinaryTreeTraversals_link;

	@FindBy(linkText = "Implementation of Binary Trees")
	@CacheLookup
	WebElement ImplementationOfBiTreeLink;

	@FindBy(linkText = "Applications of Binary trees")
	@CacheLookup
	WebElement AppliOfBitrees_Link;

	@FindBy(linkText = "Binary Search Trees")
	@CacheLookup
	WebElement BinarySearchTreesLink;

	@FindBy(linkText = "Implementation Of BST")
	@CacheLookup
	WebElement ImplementationOfBSTLink;

	@FindBy(linkText = "Practice Questions")
	@CacheLookup
	WebElement Practice_QuestionsLink;
		
	public void treeGetStarted() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TreeGetStarted);
		wait.until(ExpectedConditions.elementToBeClickable(TreeGetStarted)).click();
	}

	public void dropdownmenuClick() {
		dropdownmenu.click();
	}

	public void clickTreeFromDropdown() {
		selectTree_DropdownMenu.click();
	}

	public void overviewOfTrees() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", overviewOfTrees);
		wait.until(ExpectedConditions.visibilityOf(overviewOfTrees)).click();
	}

	public void TryHereButton() {
		TryhereBtn.click();
	}

	public void clickRun() {
		RunBtn.click();
	}
	
	public void EmptytryInput() {
		Actions actions = new Actions(driver);
		actions.moveToElement(tryEditorInp).click().sendKeys("").build().perform();
	}
	
	public String Outputmsg() {
		return OutPutmsg.getText();
	}

	public void Terminoligies() {
		TerminologiesLink.click();
	}

	public void TypesofTrees() {
		TypesOfTreeslink.click();
	}

	public void TreeTraversals() {
		TreeTraversals_link.click();
	}

	public void Traversal_Illustration() {
		Traversals_Illustration_Link.click();
	}

	public void Binary_Trees() {
		BinmaryTreesLink.click();
	}

	public void TypesOfBinaryTrees() {
		Types_ofBinaryTreesLink.click();
	}

	public void ImplementationInPython() {
		Implementation_inPythonLink.click();
	}

	public void BinaryTreeTraversals() {
		BinaryTreeTraversals_link.click();
	}

	public void ImplementationOfBinaryTrees() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ImplementationOfBiTreeLink);
		wait.until(ExpectedConditions.visibilityOf(ImplementationOfBiTreeLink)).click();
	}

	public void ApplicationOfBinaryTrees() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AppliOfBitrees_Link);
		wait.until(ExpectedConditions.visibilityOf(AppliOfBitrees_Link)).click();
	}

	public void BinarySearchTrees() {
		BinarySearchTreesLink.click();
	}

	public void ImplementationOfBST() {
		ImplementationOfBSTLink.click();
	}

	public void PracticeQns() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Practice_QuestionsLink);
		wait.until(ExpectedConditions.elementToBeClickable(Practice_QuestionsLink)).click();
	}
}