package TestClasses;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.ConfigReader;

public class HomeTest extends TestBase {
	
	public TestBase base=new TestBase();
	HomePage home;
	LoginPage login;
	
	 String Username = ConfigReader.getProperty("username");
      String Password = ConfigReader.getProperty("password");
	
	@BeforeMethod
	public void setupPages() {
		home = new HomePage();
		login = new LoginPage(); 
	}
	@Test(priority=1)
	public void checkTreefromDropdownWithoutSignIn()
	{
		home.dropdownMenuClick();
		home.clickTreeFromDropdown();
		assertTrue(home.warning1.isDisplayed());
	}
	
	@Test(priority=2)
	public void checkGetstartedWithoutSignin()
	{
		home.clickGraphGetstarted();
		assertTrue(login.LoginStatus.isDisplayed());
	}
	
	@Test(priority=3)
	public void checkGetStartedafterSignIn() 
	{
		login.signin();
		login.login(Username, Password);
		home.clickGraphGetstarted();
		assertEquals(driver.getTitle(),"Graph");
	}
	
	@Test(priority=4)
	public void checkTreeFromDropownAfterSignin()
	{
        home.dropdownMenuClick();
		home.clickTreeFromDropdown();
		assertEquals("Tree", driver.getTitle());
	}
	@Test(priority=5)
	public void checkStackGetStarted()
	{
		home.clickStackGetstarted();
		assertEquals(driver.getTitle(),"Stack");
	}
	
	@Test(priority=6)
	public void checkQueueGetStarted()
	{
		home.clickQueueGetstarted();
		assertEquals(driver.getTitle(),"Queue");
	}
	
	@Test(priority=7)
	public void checkArrayGetStarted()
	{
		home.clickArrayGetstarted();
		assertEquals(driver.getTitle(),"Array");
	}
	
	
	@Test(priority=10)
	public void chechSignOut()
	{
		home.signout();
		assertTrue(login.LoginStatus.isDisplayed());
	}

}
