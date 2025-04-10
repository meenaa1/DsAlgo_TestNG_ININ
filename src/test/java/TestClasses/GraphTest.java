package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.*;
import Utilities.*;

@Listeners(Utilities.Listener.class)
public class GraphTest extends TestBase {

    LoginPage login;
    GraphPage graphPage;
    String Username = ConfigReader.getProperty("username");
    String Password = ConfigReader.getProperty("password");

    @BeforeMethod
    public void setupPages() {
        login = new LoginPage();
        graphPage = new GraphPage();
    }

    @Test(priority = 1)
    public void graphFromGetStarted() {
        login.signin();
        login.login(Username, Password);
        graphPage.GraphGetStarted();
        Assert.assertEquals(driver.getTitle(), "Graph");
        LoggerReader.info("User is in the Graph Page");
    }

    @Test(priority = 2)
    public void graphFromDropdown() {
        graphPage.dropdownMenuClick();
        graphPage.ClickGraphFromDropdown();
        Assert.assertEquals(driver.getTitle(), "Graph");
    }

    @Test(priority = 3)
    public void checkingGraphLink() {
        graphPage.Graphlink();
        Assert.assertEquals(driver.getTitle(), "Graph");
    }

    @Test(priority = 4)
    public void checkingPracticeQuestionsPage() {
        graphPage.navigateback();
        graphPage.GraphRepresentationlink();
        graphPage.PracticeQns();
        Assert.assertFalse(graphPage.content().trim().isEmpty(), "Page is blank! Body does not contain text.");
        Assert.assertEquals(driver.getTitle(), "Practice Questions");
    }

    @Test(priority = 5)
    public void checkingGraphLinkWithEmptyRun() {
        graphPage.graphGetStarted();
        graphPage.Graphlink();
        graphPage.TryHereButton();
        graphPage.EmptytryInput();
        graphPage.Run();
        Assert.assertEquals(driver.getTitle(), "Assessment");
        LoggerReader.info("No error message is present on empty input Run");
    }
    
    @Test(priority = 6, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
    public void testInvalidPythonCodeforGraphlink(String tryHereCode, String expectedAlertMessage) {
        graphPage.graphGetStarted();
        graphPage.Graphlink();
        graphPage.TryHereButton();
        graphPage.enterPythonCode(tryHereCode);
        graphPage.Run();
        String actualAlertMessage = graphPage.getAlertTextAndAccept();
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
                "Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
        Assert.assertEquals(driver.getTitle(), "Assessment");
    }
    
    @Test(priority = 7, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
    public void testValidPythonCodeforGraphLink(String tryHereCode, String expectedAlertMessage) {
        graphPage.graphGetStarted();
        graphPage.Graphlink();
        graphPage.TryHereButton();
        graphPage.enterPythonCode(tryHereCode);
        graphPage.Run();
        Assert.assertEquals(driver.getTitle(), "Assessment");
    }
    
    @Test(priority = 8)
    public void checkingGraphRepresentationLinkWithEmptyRun() {
        graphPage.graphGetStarted();
        graphPage.GraphRepresentationlink();
        graphPage.TryHereButton();
        graphPage.EmptytryInput();
        graphPage.Run();
        Assert.assertEquals(driver.getTitle(), "Assessment");
        LoggerReader.info("No error message is present on empty input Run");
    }
    
    @Test(priority = 9, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
    public void testInvalidPythonCodeforGraphRepresentationLink(String tryHereCode, String expectedAlertMessage) {
        graphPage.graphGetStarted();
        graphPage.GraphRepresentationlink();
        graphPage.TryHereButton();
        graphPage.enterPythonCode(tryHereCode);
        graphPage.Run();
        String actualAlertMessage = graphPage.getAlertTextAndAccept();
        Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage),
                "Expected alert message to contain: " + expectedAlertMessage + ", but got: " + actualAlertMessage);
        Assert.assertEquals(driver.getTitle(), "Assessment");
    }

    @Test(priority = 10, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
    public void testValidPythonCodeGraphRepresentationLink(String tryHereCode, String expectedAlertMessage) {
        graphPage.graphGetStarted();
        graphPage.GraphRepresentationlink();
        graphPage.TryHereButton();
        graphPage.enterPythonCode(tryHereCode);
        graphPage.Run();
        Assert.assertEquals(driver.getTitle(), "Assessment");
    }
    
}