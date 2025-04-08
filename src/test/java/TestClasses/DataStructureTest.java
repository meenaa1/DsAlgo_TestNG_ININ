package TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.*;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;
import org.testng.annotations.BeforeMethod;

//@Listeners(Utilities.Listener.class)
public class DataStructureTest extends TestBase {

    LoginPage login;
    GraphPage graphpage;
    DataStructurePage DSPage;
    String Username = ConfigReader.getProperty("username");
    String Password = ConfigReader.getProperty("password");

    @BeforeMethod
    public void setupPages() {
        login = new LoginPage();
        graphpage = new GraphPage();
        DSPage = new DataStructurePage();
    }

    @Test(priority = 1)
    public void dataStructureIntroduction() {
        login.signin();
        login.login(Username, Password);
        DSPage.checkGetstarted();
        Assert.assertEquals(driver.getTitle(), "Data Structures-Introduction");
        LoggerReader.info("User is in the Data Structures Introduction Page");
    }

    @Test(priority = 2)
    public void checkPracticeQuestionsPage() {
        driver.navigate().back();
        DSPage.checkTimeComplexity();
        DSPage.checkPractice();
        Assert.assertEquals(driver.getTitle(), "Practice Questions");
        LoggerReader.info("User is in Practice Questions Page");
    }

    @Test(priority = 3)
    public void checkTimeComplexityLinkAndEmptyRun() {
        DSPage.checkGetstarted();
        DSPage.checkTimeComplexity();
        Assert.assertEquals(driver.getTitle(), "Time Complexity");
        LoggerReader.info("User is in Time Complexity Page");
        DSPage.tryhere();
        DSPage.EmptytryInput();
        DSPage.Run();

        Assert.assertEquals(driver.getTitle(), "Assessment");
        LoggerReader.info("No Error Message is present on empty Run");
    }

    @Test(priority = 4, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
    public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
        DSPage.checkGetstarted();
        DSPage.checkTimeComplexity();
        DSPage.tryhere();
        graphpage.enterPythonCode(tryherecode);
        DSPage.Run();

        String actualAlertMessage = graphpage.getAlertTextAndAccept();

        Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
                "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
        Assert.assertEquals(driver.getTitle(), "Assessment");
    }

    @Test(priority = 5, dataProvider = "Validpythoncode", dataProviderClass = Dataprovider.class)
    public void testValidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
        DSPage.checkGetstarted();
        DSPage.checkTimeComplexity();
        DSPage.tryhere();
        graphpage.enterPythonCode(tryherecode);
        DSPage.Run();

        Assert.assertEquals(driver.getTitle(), "Assessment");
    }
}
