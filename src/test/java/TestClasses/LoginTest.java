package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.LoginPage;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class LoginTest extends TestBase {

	public TestBase base = new TestBase();
	LoginPage login;

	@BeforeMethod
	public void setupPages() {
		login = new LoginPage();
	}

	@Test(priority = 1)
	public void checkingLoginLink() {
		login.signin();
		LoggerReader.info("we are in login page");
		Assert.assertEquals(driver.getTitle(), "Login");
	}

	@Test(priority = 2, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void loginwithValidCredentials(String username, String password) {
		login.signin();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		LoggerReader.info("Login Successful.");
		Assert.assertTrue(login.LoginStatus.isDisplayed());
	}

	@Test(priority = 3)
	public void signout() {
		login.signout();
		login.getErrorMessage();
		LoggerReader.info("Logout successful");
		Assert.assertTrue(login.LoginStatus.isDisplayed());
	}

	@Test(priority = 4, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void emptyUsernameandPassword(String username, String password) {
		login.signin();
		login.clickLoginButton();
		LoggerReader.info("Empty username and password.");
		Assert.assertTrue(login.alert.isDisplayed());
	}

	@Test(priority = 5, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void emptyusername(String username, String password) {
		login.signin();
		login.enterPassword(password);
		login.clickLoginButton();
		LoggerReader.info("Username is empty.");
		Assert.assertTrue(login.alert.isDisplayed());
	}

	@Test(priority = 6, dataProvider = "LoginValidcredentials", dataProviderClass = Dataprovider.class)
	public void emptypassword(String username, String password) {
		login.signin();
		login.enterUsername(username);
		login.clickLoginButton();
		LoggerReader.info("Empty Password.");
		Assert.assertTrue(login.alert.isDisplayed());
	}

	@Test(priority = 7)
	public void RegisterfromLogin() {
		login.signin();
		login.register();
		LoggerReader.info("inside login page");
		Assert.assertEquals(driver.getTitle(), "Registration");
	}

	@Test(priority = 8, dataProvider = "InvalidUsername", dataProviderClass = Dataprovider.class)
	public void invalidUsername(String username, String password) {
		login.signin();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		LoggerReader.info("Invalid username.");
		Assert.assertTrue(login.LoginStatus.isDisplayed());
	}
	
	@Test(priority = 8, dataProvider = "InvalidPassword", dataProviderClass = Dataprovider.class)
	public void invalidPassword(String username, String password) {
		login.signin();
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		LoggerReader.info("Invalid password.");
		Assert.assertTrue(login.LoginStatus.isDisplayed());
	}
}