package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.*;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
//@Listeners(com.aventstack.chaintest.plugins.ChainTestListener.class)
public class TreeTest extends TestBase {
	
	TestBase testBase =new TestBase();
	ConfigReader config = new ConfigReader();
	GraphPage graphpage = new GraphPage();
	LoginPage login = new LoginPage();
	TreePage tree = new TreePage();
	String Username=ConfigReader.getProperty("username");
	String Password=ConfigReader.getProperty("password");
	


	@Test(priority=1)
	public void TreeFromGetStarted() {
		login.signin();
        login.login(Username, Password);
		tree.treeGetStarted();
		Assert.assertEquals(driver.getTitle(), "Tree");
		LoggerReader.info("User is in the Tree Page");
		}
	@Test(priority=2)
	public void TreefromDropdown() {
		tree.dropdownmenuClick();
		tree.clickTreeFromDropdown();
		Assert.assertEquals(driver.getTitle(), "Tree");
	}
	@Test(priority=3)
	public void CheckingOverviOfTrees() {
		driver.navigate().back();
		tree.overviewOfTrees();
		Assert.assertEquals(driver.getTitle(), "Overview of Trees");
		
	}
	@Test(priority=4)
	public void CheckingTerminologieslink() {
		driver.navigate().back();
		tree.Terminoligies();
		Assert.assertEquals(driver.getTitle(), "Terminologies");
		
	}
	@Test(priority=5)
	public void CheckingTypesofTrees() {
		driver.navigate().back();
		tree.TypesofTrees();
		Assert.assertEquals(driver.getTitle(), "Types of Trees");
	}
	@Test(priority=6,dataProvider = "linkDataProvider", dataProviderClass= Dataprovider.class)
	public void Checkingallotherlinks(String string) {
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
	        case "Types of Binary Trees()":
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
	@Test(priority=7, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	 public void testvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
		tree = new TreePage(); 
		tree.treeGetStarted();
	    tree.overviewOfTrees();
		tree = new TreePage(); 
	    tree.TryHereButton();
	    graphpage.enterPythonCode(tryherecode); // Send code to editor
	    graphpage.Run();
	    Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=8, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	 public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
		driver.navigate().back();
		//tree.treeGetStarted();
		//tree = new TreePage(); // Re-initialize Page Object after page change
	   // tree.overviewOfTrees();
	   // tree.TryHereButton();
	    graphpage.enterPythonCode(tryherecode); // Send code to editor
	    graphpage.Run();
	    String actualAlertMessage = graphpage.getAlertTextAndAccept(); // You'll define this in GraphPage
	    Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
	        "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	    Assert.assertEquals(driver.getTitle(), "Assessment");
	}

	
 
	@Test(priority=9)
	public void EmptyInput() {
		TreePage tree = new TreePage();
		//driver.navigate().back();
		tree.treeGetStarted();
		tree.overviewOfTrees();
		tree.TryHereButton();
		tree.EmptytryInput();
		tree.clickRun();
		
	}
	@Test(priority=10)
	public void checkPracticeQns() {
		TreePage tree = new TreePage();
		//driver.navigate().back();
		tree.treeGetStarted();
		tree.overviewOfTrees();
		//LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		tree.PracticeQns();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}
	
}
