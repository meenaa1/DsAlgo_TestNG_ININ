package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverFactory.driverFactory;
import Utilities.ConfigReader;

public class HomePage {

	WebDriver driver;
	String url = ConfigReader.getProperty("url");
	String homeurl = ConfigReader.getProperty("homeUrl");

	public HomePage() {
		driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='nav-item dropdown show']")
	@CacheLookup
	public WebElement dataStructuresDropdown;

	@FindBy(xpath = "//a[text()='Tree']")
	@CacheLookup
	public WebElement treeOption;

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	@CacheLookup
	public WebElement warning1;

	@FindBy(xpath = "//a[@href='/register']")
	@CacheLookup
	public WebElement registerLink;

	@FindBy(xpath = "//button[text()='Get Started']")
	@CacheLookup
	WebElement DSAlgoGetstart;

	@FindBy(xpath = "//a[@href='tree']")
	@CacheLookup
	public WebElement treeGetStarted;

	@FindBy(xpath = "//a[@href='graph']")
	@CacheLookup
	public WebElement graphGetStarted;

	@FindBy(xpath = "//a[text()='Sign out']")
	@CacheLookup
	WebElement signout;

	@FindBy(xpath = "//div[@class='nav-item dropdown']")
	@CacheLookup
	WebElement dropdownMenu;

	@FindBy(xpath = "//a[text()='Tree']")
	@CacheLookup
	WebElement selectTree_DropdownMenu;

	@FindBy(xpath = "//title[text()='Tree']")
	@CacheLookup
	WebElement titleTree;

	public void dropdownMenuClick() {
		dropdownMenu.click();
	}

	public void clickTreeFromDropdown() {
		selectTree_DropdownMenu.click();
	}

	public String titleTree() {
		return titleTree.getText();
	}

	public void GetStarted() {
		DSAlgoGetstart.click();
	}

	public void signout() {
		signout.click();
	}

	public void Geturl() {
		driver.get(url);
	}

	public void Gethomeurl() {
		driver.get(homeurl);
	}

	public String warning() {
		return warning1.getText();
	}

}