package TestClasses;

import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class RegisterTest extends TestBase {
	
	RegisterPage registerPage;
	String newusername;
	LoginPage login;

	@BeforeMethod
	public void setupPages() {
		login = new LoginPage();
		registerPage = new RegisterPage();
	}

	@Test(priority = 1)
	public void checkRegisterLink() {
		registerPage.register();
		LoggerReader.info("User is in the Register page");
		Assert.assertEquals(driver.getTitle(), "Registration");
	}

	@Test(priority = 2, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void successfulRegistration(String username, String password) throws InterruptedException {
		registerPage.register();
		newusername = registerPage.generateuser(username);
		registerPage.enterUsername(newusername);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		LoggerReader.info("New account !!");
		Thread.sleep(1000);
		assertEquals(driver.getTitle(),"NumpyNinja");
	}

	@Test(priority = 3, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void LoginAfterRegistration(String username, String password) {
		login.signout();
	    login.signin();
		login.login(newusername, password);
		String expectedmessage = "You are logged in";
		String actualmessage = login.getErrorMessage();
		LoggerReader.info("Signin message: " + actualmessage);
		Assert.assertEquals(actualmessage, expectedmessage, "Incorrect Message");
	}

	@Test(priority = 4, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void RegistrationWithSameRegdCredentials(String username, String password) {
		login.signout();
		registerPage.register();
		registerPage.enterUsername(newusername);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		String expectedmessage = "Username already exists";
		String actualmessage = registerPage.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}

	@Test(priority = 5, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void RegisterWithEmptyUsername(String username, String password) {
		registerPage.register();
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		Assert.assertTrue(registerPage.alert.isDisplayed());
	}

	@Test(priority = 6, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void RegisterWithEmptyPassowrd(String username, String password) {
		registerPage.register();
		newusername = registerPage.generateuser(username);
		registerPage.enterUsername(newusername);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		Assert.assertTrue(registerPage.alert.isDisplayed());
	}

	@Test(priority = 7, dataProvider = "Registervalidcredentials", dataProviderClass = Dataprovider.class)
	public void RegisterWithEmptyConfirmPassowrd(String username, String password) {
		registerPage.register();
		registerPage.enterUsername(username);
		registerPage.enterPassword(password);
		registerPage.clickRegister();
		Assert.assertTrue(registerPage.alert.isDisplayed());
	}

	@Test(priority = 8, dataProvider = "Registerinvalidusername", dataProviderClass = Dataprovider.class)
	public void Registrationusinginvalidusername(String username, String password) {
		registerPage.register();
		registerPage.enterUsername(username);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		String expectedmessage = "password_mismatch:The two password fields didn’t match.";
		String actualmessage = registerPage.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}

	@Test(priority = 9, dataProvider = "Registerinvalidpassword", dataProviderClass = Dataprovider.class)
	public void Registrationusinginvalidpassword(String username, String password) {
		registerPage.register();
		registerPage.enterUsername(username);
		registerPage.enterPassword(password);
		registerPage.enterConfirmPassword(password);
		registerPage.clickRegister();
		String expectedmessage = "password_mismatch:The two password fields didn’t match.";
		String actualmessage = registerPage.getErrorMessage();
		LoggerReader.info(actualmessage);
		assertEquals(actualmessage, expectedmessage, "Incorrect error message");
	}

}