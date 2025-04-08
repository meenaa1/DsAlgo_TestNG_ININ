package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.ArrayPage;
import PageObjects.LoginPage;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

public class ArrayTest extends TestBase {
	ArrayPage arrayPage;
	LoginPage login;
	String Username = ConfigReader.getProperty("username");
	String Password = ConfigReader.getProperty("password");

	@BeforeMethod
	public void setupPages() {
		login = new LoginPage();
		arrayPage = new ArrayPage();
	}

	@Test(priority = 1)
	public void ArrayStartingPage() {
		login.signin();
		login.login(Username, Password);
		arrayPage.ArrayGetStarted();
		Assert.assertEquals(driver.getTitle(), "Array");
		LoggerReader.info("User is in the Array Page");
	}

	@Test(priority = 2)
	public void ArraysPythonPage() {
		driver.navigate().back();
		arrayPage.ArraysPython();
		Assert.assertEquals(driver.getTitle(), "Arrays in Python");
		LoggerReader.info("User is in the Arrays in Python page");
	}

	@Test(priority = 3)
	public void CheckingArraysinPythonwithEmptyRun() {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysPython();
		arrayPage.Tryherebtn();
		arrayPage.TryEditorNocode();
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 4, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysPython();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		String actualAlertMessage = arrayPage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
				"Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 5, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysPython();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 6)
	public void CheckingArraysListwithEmptyRun() {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysList();
		LoggerReader.info("User is in the Arrays Using List page");
		arrayPage.Tryherebtn();
		arrayPage.TryEditorNocode();
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 7, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCodeArraysList(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysList();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		String actualAlertMessage = arrayPage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
				"Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 8, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCodeArraysList(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ArraysList();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 9)
	public void CheckingBasicOpeartionswithEmptyRun() {
		arrayPage.ArrayGetStarted();
		arrayPage.Basicoperation();
		LoggerReader.info("User is in the Basic Opeartions in Lists page");
		arrayPage.Tryherebtn();
		arrayPage.TryEditorNocode();
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 10, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCodeBasicOpeartions(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.Basicoperation();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		String actualAlertMessage = arrayPage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
				"Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 11, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCodeBasicOpearations(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.Basicoperation();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 12)
	public void CheckingApplicationsofArraywithEmptyRun() {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		LoggerReader.info("User is in the Applications of Array page");
		arrayPage.Tryherebtn();
		arrayPage.TryEditorNocode();
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 13, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCodeApplicationsofArray(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		String actualAlertMessage = arrayPage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
				"Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 14, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCodeApplicationsofArray(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Tryherebtn();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 15)
	public void checkPracticeQns() {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		LoggerReader.info("User is in the Applications of Array page");
		arrayPage.Practicequestions();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}

	@Test(priority = 16, dataProvider = "PracticeQSearchthearray", dataProviderClass = Dataprovider.class)
	public void testvalidPythonCode_SearchtheArray(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Practicequestions();
		arrayPage.Searchthearray();
		arrayPage.ClearTryEditor();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 17, dataProvider = "PracticeQMaxConsones", dataProviderClass = Dataprovider.class)
	public void testvalidPythonCode_MaxConones(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Practicequestions();
		arrayPage.MaxConsecutiveOnes();
		arrayPage.ClearTryEditor();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 18, dataProvider = "PracticeQEvennums", dataProviderClass = Dataprovider.class)
	public void testvalidPythonCode_EvenNums(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Practicequestions();
		arrayPage.FindEvenNumbers();
		arrayPage.ClearTryEditor();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 19, dataProvider = "PracticeQSQofsortedarray", dataProviderClass = Dataprovider.class)
	public void testvalidPythonCode_SortedArray(String tryHereCode, String expectedAlertMessage) {
		arrayPage.ArrayGetStarted();
		arrayPage.ApplicationsArray();
		arrayPage.Practicequestions();
		arrayPage.FindEvenNumbers();
		arrayPage.ClearTryEditor();
		arrayPage.enterPythonCode(tryHereCode);
		arrayPage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

}