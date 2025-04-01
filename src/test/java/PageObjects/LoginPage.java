package PageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//import DriverFactory.driverFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

public static WebDriver driver;
WebDriverWait wait;

public LoginPage() {
//driver = driverFactory.getDriver();
PageFactory.initElements(driver, this);
this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

@FindBy(css=("input:invalid"))
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
wait.until(ExpectedConditions.elementToBeClickable(getStartedButton));
getStartedButton.click();
}

public void enterUsername(String username) {
wait.until(ExpectedConditions.visibilityOf(usernameLoginpage));
usernameLoginpage.sendKeys(username);
}

public void enterPassword(String password) {
wait.until(ExpectedConditions.visibilityOf(passwordLoginpage));
passwordLoginpage.sendKeys(password);
}

public void clickLoginButton() {
wait.until(ExpectedConditions.elementToBeClickable(loginButton));
loginButton.click();
}

public void login(String username, String password) {
enterUsername(username);
enterPassword(password);
clickLoginButton();
}

public void register() {
wait.until(ExpectedConditions.elementToBeClickable(registerlinkLoginPage));
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
public static String getTitle() {
return driver.getTitle();
}

public static void getCurrentUrl() {
driver.getCurrentUrl();

}

public static void navigate() {
driver.navigate().back();
}
}