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

//@Listeners(Utilities.Listener.class)
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
        tree.Terminoligies();
        Assert.assertEquals(driver.getTitle(), "Terminologies");
    }

    @Test(priority = 5)
    public void checkingTypesOfTrees() {
        driver.navigate().back();
        tree.TypesofTrees();
        Assert.assertEquals(driver.getTitle(), "Types of Trees");
    }

    @Test(priority = 6, dataProvider = "linkDataProvider", dataProviderClass = Dataprovider.class)
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
    public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
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

    @Test(priority = 10)
    public void checkPracticeQuestions() {
        tree.treeGetStarted();
        tree.overviewOfTrees();
        tree.PracticeQns();
        Assert.assertEquals(driver.getTitle(), "Practice Questions");
        LoggerReader.info("User is in Practice Questions Page");
    }
}
