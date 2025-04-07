package TestClasses;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.LoginPage;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

public class LoginTest extends TestBase {
	public TestBase base = new TestBase();
	LoginPage lpf;
	String pagetitle;
	WebDriver driver;

	@Test(priority = 1)
	public void toLoginpage() {
		lpf = new LoginPage();
		lpf.signin();
		// pagetitle = lpf.checkpageTitle();
		LoggerReader.info("Current page: " + pagetitle);
		Assert.assertEquals(pagetitle, "Login", "Incorrect Page");
	}

	@Test(priority = 2, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void successfulLogin(String username, String password) {
		lpf.enterUsername(username);
		lpf.enterPassword(password);
		lpf.clickLoginButton();
		String successmessage = "You are logged in";
		String actualmessage = lpf.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Login not successful");
	}

	@Test(priority = 3)
	public void signout() {
		lpf.signout();
		String successmessage = "Logged out successfully";
		String actualmessage = lpf.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Logged out successfully");
	}

	@Test(priority = 4, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void Loginwithnonexistingcredentials(String username, String password) {
		lpf.signin();
		username = username + "abc";
		lpf.enterUsername(username);
		lpf.enterPassword(password);
		lpf.clickLoginButton();
		String successmessage = "Invalid Username and Password";
		String actualmessage = lpf.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, successmessage, "Incorrectmessage");
	}

	@Test(priority = 5, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void Loginwithnousername(String username, String password) {
		lpf.enterPassword(password);
		lpf.clickLoginButton();
		// String actualvalidationmessage = lpf.emptyusernamevalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		// Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage,
		// "Incorrect validation");
	}

	@Test(priority = 6, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void Loginwithnopassword(String username, String password) {
		// lpf.clearfields();
		lpf.enterUsername(username);
		lpf.clickLoginButton();
		// String actualvalidationmessage = lpf.emptypasswordvalidation();
		String expectedvalidationmessage = "Please fill out this field.";
		// Assert.assertEquals(actualvalidationmessage, expectedvalidationmessage,
		// "Incorrect validation");
	}

	@Test(priority = 7)
	public void RegisterfromLogin() {
		lpf.register();
		// pagetitle = lpf.checkpageTitle();
		LoggerReader.info("Current page: " + pagetitle);
		Assert.assertEquals(pagetitle, "Registration", "Incorrect Page");
	}

}