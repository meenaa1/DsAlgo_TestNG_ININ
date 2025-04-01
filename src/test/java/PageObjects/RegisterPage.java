package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driverFactory;

public class RegisterPage {

	WebDriver driver;
	WebDriverWait wait;

    public RegisterPage() {
    	driver = driverFactory.getDriver();
		PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	@CacheLookup
	WebElement ErrorMessage;
	
	@FindBy(css=("input:invalid"))
	@CacheLookup
	public WebElement alert;
	
    @FindBy(xpath="//input[@id='id_username']") 
    @CacheLookup
    private WebElement usernameField;
   
    @FindBy(xpath="//input[@id='id_password1']") 
    @CacheLookup
    private WebElement passwordField;

	@FindBy(className = "btn")
	@CacheLookup
	WebElement GetStarted;
	
	@FindBy(xpath = "//div[@id='navbarCollapse']/div[2]/ul/a[2]")
	@CacheLookup
	WebElement registerlink;
    
    @FindBy(xpath="//input[@id='id_password2']") 
    @CacheLookup
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@value='Register']") 
    @CacheLookup
    private WebElement registerButton;
    
    @FindBy(xpath = "//div[@role='alert']")
    @CacheLookup
    public WebElement success;

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
    }
    
    public void GetStarted() {
		GetStarted.click();
    }
    
    public void register() {
    	registerlink.click();
    }
   
    public void clickRegister() {
        registerButton.click();
    }

    public void valid_register(String username, String password, String confirmPassword) {
        enterUsername(username);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        clickRegister();
    }
    
    public String getErrorMessage() {
    	return ErrorMessage.getText();
    }
    
	public String successMessage() {
		return success.getText();
	}
	
	public String alertmsg() {
		return alert.getText();
	}
		
}