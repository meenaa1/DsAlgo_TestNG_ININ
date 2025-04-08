package PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import DriverFactory.driverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    WebDriver driver;
	WebDriverWait wait;

	public LoginPage() {
        driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//a[text()='Sign in']")
	@CacheLookup
	WebElement signIn;

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	public WebElement usernameLoginpage;

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	public WebElement passwordLoginpage;

	@FindBy(xpath = "//*[@value='Login']")
	@CacheLookup
	public WebElement loginButton;

	@FindBy(xpath = "//a[@href='/register']")
	@CacheLookup
	WebElement registerlinkLoginPage;

	@FindBy(xpath = "//*[@id='navbarCollapse']/div[2]/ul/a[3]")
	@CacheLookup
	WebElement SignOut;

	@FindBy(css = ("input:invalid"))
	@CacheLookup
	public WebElement alert;

	@FindBy(xpath = "//div[@role='alert']")
	@CacheLookup
	public WebElement LoginStatus;

	@FindBy(className = "btn")
	@CacheLookup
	WebElement getStartedButton;

	public void signin() {
		signIn.click();
	}

	public void clickGetStarted() {
		
		getStartedButton.click();
	}

	public void enterUsername(String username) {
		usernameLoginpage.sendKeys(username);
	}

	public void enterPassword(String password) {
		
		passwordLoginpage.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public void register() {
		
		registerlinkLoginPage.click();
	}

	public void invalidLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public String getErrorMessage() {
		return LoginStatus.getText();
	}

	public boolean isLoginPageDisplayed() {
		return driver.getTitle().equals("Login");
	}

	public boolean isErrorMessageForUsernameDisplayed() {
		return LoginStatus.isDisplayed();
	}

	public void signout() {
		SignOut.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void getCurrentUrl() {
		driver.getCurrentUrl();

	}

	public void navigate() {
		driver.navigate().back();
	}
}