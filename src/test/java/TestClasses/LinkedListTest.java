package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.*;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class LinkedListTest extends TestBase {

	GraphPage graphpage;
	LoginPage login;
	LinkedListPage Link;
	String Username = ConfigReader.getProperty("username");
	String Password = ConfigReader.getProperty("password");

	@BeforeMethod
	public void setupPages() {
		login = new LoginPage();
		graphpage = new GraphPage();
		Link = new LinkedListPage();
	}

	@Test(priority = 1)
	public void LinkedListFromGetStarted() {
		login.signin();
		login.login(Username, Password);
		Link.Getstarted();
		Assert.assertEquals(driver.getTitle(), "Linked List");
		LoggerReader.info("User is in the Linked List Page");
	}

	@Test(priority = 2)
	public void LinkedListFromDropdown() {
		Link.dropdownmenuClick();
		Link.clickLinkListFromDropdown();
		Assert.assertEquals(driver.getTitle(), "Linked List");
	}

	@Test(priority = 3)
	public void checkingIntro() {
		driver.navigate().back();
		Link.Introductionpage();
		Assert.assertEquals(driver.getTitle(), "Introduction");
	}

	@Test(priority = 4, dataProvider = "linkListDataProvider", dataProviderClass = Dataprovider.class)
	public void checkingAllOtherLinks(String string) {
		driver.navigate().back();
		switch (string) {
		case "Creating Linked List":
			Link.CreatingLinkedlist();
			break;
		case "Types Of Linked List":
			Link.TypesLinkedlist();
			break;
		case "Implement Linked List in Python":
			Link.ImplementingList();
			break;
		case "Traversal":
			Link.Traversal();
			break;
		case "Insertion":
			Link.Insertion();
			break;
		case "Deletion":
			Link.Deletion();
			break;
		}
	}

	@Test(priority = 4, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Intro(String tryherecode, String expectedalertmessage) throws InterruptedException {
		Link.Getstarted();
		Link.Introductionpage();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 5, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Intro(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Introductionpage();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 6)
	public void emptyInput_Intro() {
		Link.Getstarted();
		Link.Introductionpage();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 7, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_CreatingLinkedList(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.CreatingLinkedlist();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 8, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_CreatingLinkedList(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.CreatingLinkedlist();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 9)
	public void emptyInput_CreatingLinkedList() {
		Link.Getstarted();
		Link.CreatingLinkedlist();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 10, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_TypesofLinkedlist(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.TypesLinkedlist();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 11, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_TypesofLinkedlist(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.TypesLinkedlist();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 12)
	public void emptyInput_TypesofLinkedlist() {
		Link.Getstarted();
		Link.TypesLinkedlist();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 13, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_ImplLinkedListInPython(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.ImplementingList();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 14, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_ImplLinkedListInPython(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.ImplementingList();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 15)
	public void emptyInput_ImplLinkedListInPython() {
		Link.Getstarted();
		Link.ImplementingList();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 16, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Traversal(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 17, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Traversal(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 18)
	public void emptyInput_Traversal() {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 19, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Insertion(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 20, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Insertion(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 21)
	public void emptyInput_Insertion() {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 22, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Deletion(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 23, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Deletion(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		graphpage.enterPythonCode(tryherecode);
		Link.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 24)
	public void emptyInput_Deletion() {
		Link.Getstarted();
		Link.Traversal();
		Link.Tryhere();
		Link.Nocode();
		Link.Run();
	}

	@Test(priority = 25)
	public void checkPracticeQuestions() {
		Link.Getstarted();
		Link.Insertion();
		Link.PracticeQuestion();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}
}