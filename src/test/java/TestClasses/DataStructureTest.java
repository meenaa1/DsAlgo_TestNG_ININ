package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.*;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

public class DataStructureTest extends TestBase {

	TestBase testBase = new TestBase();
	ConfigReader config = new ConfigReader();
	GraphPage graphpage = new GraphPage();
	LoginPage login = new LoginPage();
	DataStructurePage DSPage = new DataStructurePage();
	String Username = ConfigReader.getProperty("username");
	String Password = ConfigReader.getProperty("password");

	@Test(priority = 1)
	public void DataStructureIntrodution() {

		login.signin();
		login.login(Username, Password);
		DSPage.checkGetstarted();
		Assert.assertEquals(driver.getTitle(), "Data Structures-Introduction");
		LoggerReader.info("User is in the Data Structures Introduction Page");
	}

	@Test(priority = 2)
	public void checkPracticeQnsPage() {

		driver.navigate().back();
		DSPage.checkTimeComplexity();
		DSPage.checkPractice();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}

	@Test(priority = 3)
	public void checkTimeComplexitylink() {

		DataStructurePage DSPage = new DataStructurePage();
		DSPage.checkGetstarted();
		DSPage.checkTimeComplexity();
		Assert.assertEquals(driver.getTitle(), "Time Complexity");
		LoggerReader.info("User is in Time Complexity Page");
		DSPage.tryhere();
		DSPage.EmptytryInput();
		DSPage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");

	}

	@Test(priority = 4, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {

		DataStructurePage DSPage = new DataStructurePage();// Re-initialize Page Object after page change
		DSPage.checkGetstarted();
		DSPage.checkTimeComplexity();
		DSPage.tryhere();
		graphpage.enterPythonCode(tryherecode); // Send code to editor
		DSPage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 5, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
		// Perform test actions (e.g., input the code in your UI, click 'Run', etc.)
		System.out.println("Test input: " + tryherecode);
		System.out.println("Expected alert message: " + expectedalertmessage);
		Assert.assertEquals(driver.getTitle(), "NumpyNinja");

	}

}