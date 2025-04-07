package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageObjects.GraphPage;
import PageObjects.LoginPage;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class GraphTest extends TestBase {

TestBase testBase =new TestBase();
ConfigReader config = new ConfigReader();
GraphPage graphpage = new GraphPage();
LoginPage login = new LoginPage();
String Username=ConfigReader.getProperty("username");
String Password=ConfigReader.getProperty("password");

@BeforeMethod
public void setupPages() {
    login = new LoginPage();
    graphpage = new GraphPage();
}

@Test(priority=1)
public void GraphFromGetStarted() {
login.signin();
login.login(Username, Password);
graphpage.GraphGetStarted();
Assert.assertEquals(driver.getTitle(), "Graph");
LoggerReader.info("User is in the Graph Page");
}
@Test(priority=2)
public void GraphfromDropdown() {
graphpage.dropdownMenuClick();
graphpage.ClickGraphFromDropdown();
Assert.assertEquals(driver.getTitle(), "Graph");
}
@Test(priority=3)
public void checkingGraphLink() {
graphpage.Graphlink();
Assert.assertEquals(driver.getTitle(), "Graph");
}
@Test(priority=4)
public void checkingPracticeQnPage() {
graphpage.navigateback();
graphpage.GraphRepresentationlink();
graphpage.PracticeQns();
Assert.assertEquals(driver.getTitle(), "Practice Questions");
}

@Test(priority=5)
public void checkingGraphRepresentationLink() {
graphpage.graphGetStarted();
graphpage = new GraphPage(); // Re-initialize Page Object after page change
graphpage.GraphRepresentationlink();
//Assert.assertEquals(driver.getTitle(), "Graph Representations");
graphpage.TryHereButton();
graphpage.EmptytryInput();
graphpage.Run();
Assert.assertEquals(driver.getTitle(), "Assessment");
System.out.println("No Error Message is present");
}

@Test(priority = 6, dataProvider = "Invalidpythoncode", dataProviderClass = Dataprovider.class)
public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
   graphpage.graphGetStarted();
   graphpage = new GraphPage();
   graphpage.GraphRepresentationlink();
   graphpage.TryHereButton();
   graphpage.enterPythonCode(tryherecode);
   graphpage.Run();

   // Handle the alert popup and get the message
   String actualAlertMessage = graphpage.getAlertTextAndAccept(); // You'll define this in GraphPage

   // Assert the alert text
   Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
}


@Test(priority=7, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
public void testvalidPythonCode(String tryherecode, String expectedalertmessage) throws InterruptedException {
graphpage.graphGetStarted();
graphpage = new GraphPage(); // Re-initialize Page Object after page change
   graphpage.GraphRepresentationlink();
   graphpage.TryHereButton();
   graphpage.enterPythonCode(tryherecode); // Send code to editor
   graphpage.Run();
   Assert.assertEquals(driver.getTitle(), "Assessment");
}
  }
