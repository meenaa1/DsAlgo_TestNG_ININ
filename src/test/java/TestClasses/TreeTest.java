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
public class TreeTest extends TestBase {

	GraphPage graphpage;
	LoginPage login;
	TreePage tree;
	String Username = ConfigReader.getProperty("username");
	String Password = ConfigReader.getProperty("password");

	@BeforeMethod
	public void setupPages() {
		login = new LoginPage();
		graphpage = new GraphPage();
		tree = new TreePage();
	}

	@Test(priority = 1)
	public void treeFromGetStarted() {
		login.signin();
		login.login(Username, Password);
		tree.treeGetStarted();
		Assert.assertEquals(driver.getTitle(), "Tree");
		LoggerReader.info("User is in the Tree Page");
	}

	@Test(priority = 2)
	public void treeFromDropdown() {
		tree.dropdownmenuClick();
		tree.clickTreeFromDropdown();
		Assert.assertEquals(driver.getTitle(), "Tree");
	}

	@Test(priority = 3)
	public void checkingOverviewOfTrees() {
		driver.navigate().back();
		tree.overviewOfTrees();
		Assert.assertEquals(driver.getTitle(), "Overview of Trees");
	}

	@Test(priority = 4)
	public void checkingTerminologiesLink() {
		driver.navigate().back();
		tree.Terminologies();
		Assert.assertEquals(driver.getTitle(), "Terminologies");
	}

	@Test(priority = 5)
	public void checkingTypesOfTrees() {
		driver.navigate().back();
		tree.TypesofTrees();
		Assert.assertEquals(driver.getTitle(), "Types of Trees");
	}

	@Test(priority = 6, dataProvider = "TreelinkDataProvider", dataProviderClass = Dataprovider.class)
	public void checkingAllOtherLinks(String string) {
		driver.navigate().back();
		switch (string) {
		case "Tree Traversals":
			tree.TreeTraversals();
			break;
		case "Traversals-Illustration":
			tree.Traversal_Illustration();
			break;
		case "Binary Trees":
			tree.Binary_Trees();
			break;
		case "Types of Binary Trees":
			tree.TypesOfBinaryTrees();
			break;
		case "Implementation of Python":
			tree.ImplementationInPython();
			break;
		case "Binary Tree Traversals":
			tree.BinaryTreeTraversals();
			break;
		case "Implementation of Binary Trees":
			tree.ImplementationOfBinaryTrees();
			break;
		case "Application of Binary trees":
			tree.ApplicationOfBinaryTrees();
			break;
		case "Binary Search Trees":
			tree.BinarySearchTrees();
			break;
		case "Implementation Of BST":
			tree.ImplementationOfBST();
			break;
		}
	}

	@Test(priority = 7, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
		tree.treeGetStarted();
		tree.overviewOfTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 8, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_overviewofTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.overviewOfTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 9)
	public void emptyInput() {
		tree.treeGetStarted();
		tree.overviewOfTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 10, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Terminologies(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Terminologies();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 11, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Terminologies(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Terminologies();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 12)
	public void emptyInputforTerminologies() {
		tree.treeGetStarted();
		tree.Terminologies();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 13)
	public void emptyInputforTypesofTrees() {
		tree.treeGetStarted();
		tree.TypesofTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 14, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_TypesofTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TypesofTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 15, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_TypesofTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TypesofTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 16)
	public void emptyInputforTreeTraversals() {
		tree.treeGetStarted();
		tree.TreeTraversals();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 17, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_TreeTraversals(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TreeTraversals();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 18, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_TreeTraversals(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TreeTraversals();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 19)
	public void emptyInputforTraversals_Illust() {
		tree.treeGetStarted();
		tree.Traversal_Illustration();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 20, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Traversals_Illust(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Traversal_Illustration();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 21, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Traversals_Illust(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Traversal_Illustration();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 22)
	public void emptyInputforBinaryTrees() {
		tree.treeGetStarted();
		tree.Binary_Trees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 23, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_BinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Binary_Trees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 24, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_BinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.Binary_Trees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 25)
	public void emptyInputforTypesofBinaryTrees() {
		tree.treeGetStarted();
		tree.TypesOfBinaryTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 26, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_TypesofBinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TypesOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 27, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_TypesofBinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.TypesOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 28)
	public void emptyInputforImple_BinaryTrees() {
		tree.treeGetStarted();
		tree.ImplementationOfBinaryTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 29, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Imple_BinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 30, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Imple_BinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 31)
	public void emptyInputforImple_inpython() {
		tree.treeGetStarted();
		tree.ImplementationInPython();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 32, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_Imple_inpython(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationInPython();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 33, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_Imple_inpython(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationInPython();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 34)
	public void emptyInputforBinaryTreeTraversal() {
		tree.treeGetStarted();
		tree.BinaryTreeTraversals();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 35, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_BinaryTreeTraversal(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.BinaryTreeTraversals();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 36, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_BinaryTreeTraversal(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.BinarySearchTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 37)
	public void emptyInputforApplOfBinaryTrees() {
		tree.treeGetStarted();
		tree.ApplicationOfBinaryTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 38, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_ApplOfBinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ApplicationOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 39, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_ApplOfBinaryTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ApplicationOfBinaryTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 40)
	public void emptyInputforBinarySearchTrees() {
		tree.treeGetStarted();
		tree.BinarySearchTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 41, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_BinarySearchTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.BinarySearchTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 42, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_BinarySearchTrees(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.BinarySearchTrees();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 43)
	public void emptyInputforImpleOfBST() {
		tree.treeGetStarted();
		tree.ImplementationOfBST();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
	}

	@Test(priority = 44, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
	public void testValidPythonCode_ImpleOfBST(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationOfBST();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 44, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
	public void testInvalidPythonCode_ImpleOfBST(String tryherecode, String expectedalertmessage)
			throws InterruptedException {
		tree.treeGetStarted();
		tree.ImplementationOfBST();
		tree.TryHereButton();
		graphpage.enterPythonCode(tryherecode);
		graphpage.Run();
		String actualAlertMessage = graphpage.getAlertTextAndAccept();
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
				"Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	@Test(priority = 45)
	public void checkPracticeQuestions() {
		tree.treeGetStarted();
		tree.overviewOfTrees();
		tree.PracticeQns();
		Assert.assertFalse(graphpage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}
	
}