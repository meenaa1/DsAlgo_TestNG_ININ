package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.LoginPage;
import PageObjects.QueuePage;
import PageObjects.StackPage;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class StackTest extends TestBase{
	
	TestBase testBase =new TestBase();
	ConfigReader config = new ConfigReader();
	StackPage stackpage = new StackPage();
	QueuePage queuepage = new QueuePage();
	LoginPage login = new LoginPage();
	String Username=ConfigReader.getProperty("username");
	String Password=ConfigReader.getProperty("password");
	
	 @BeforeMethod
	    public void setupPages() {
	        login = new LoginPage();
	        stackpage = new StackPage();
	    }
	
	@Test(priority=1)
	public void testLoginAndNavigateToStack() {
        login.signin();
        login.login(Username, Password);
        stackpage.StackGetStarted();
        Assert.assertEquals(driver.getTitle(),"Stack");
       LoggerReader.info("User is in the Stack Page");
	}
	
	@Test(priority=2)
	public void checkOperationInStack() throws InterruptedException {
		stackpage.StackGetStarted();
		stackpage.OperationInStack();;
		LoggerReader.info("User is in the Operation In Stack Page");
		stackpage.Tryhere();
		stackpage.EmptytryEditor();
		stackpage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
    }
	
	@Test(priority=3, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
		public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) {
			stackpage.StackGetStarted();
			stackpage.OperationInStack();
			LoggerReader.info("User is in the Operation In Stack  Page");
			stackpage.Tryhere();
			stackpage.enterPythonCode(tryherecode);
			stackpage.RunBtn();
			String actualAlertMessage = stackpage.getAlertTextAndAccept(); // You'll define this in StackPage
			   // Assert the alert text
			Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
			       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	}
	
	@Test(priority=4, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testValidPythonCode(String tryherecode, String expectedalertmessage) {
		stackpage.StackGetStarted();
		stackpage.OperationInStack();
		LoggerReader.info("User is in the Operation in Stack Page");
		stackpage.Tryhere();
		stackpage.enterPythonCode(tryherecode);
		stackpage.RunBtn();
	    Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=5)
	public void checkPracticeQns() {
		stackpage.StackGetStarted();
		stackpage.OperationInStack();
		LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		stackpage.StackPracticeQuestions();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}
	
	@Test(priority=6)
	public void checkImplementation() {
		stackpage.StackGetStarted();
		stackpage.Implementation();
		LoggerReader.info("User is in the Implementation Page");
		stackpage.Tryhere();
		stackpage.EmptytryEditor();
		stackpage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
	}
	
	@Test(priority=7, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		stackpage.StackGetStarted();
		stackpage.Implementation();
		LoggerReader.info("User is in the Implementation  Page");
		stackpage.Tryhere();
		stackpage.enterPythonCode(tryherecode);
		stackpage.RunBtn();
		String actualAlertMessage = stackpage.getAlertTextAndAccept(); // You'll define this in StackPage
		   // Assert the alert text
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
}
	@Test(priority=8, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationValidPythonCode(String tryherecode, String expectedalertmessage) {
		stackpage.StackGetStarted();
		stackpage.Implementation();
		LoggerReader.info("User is in the Implementation Page");
		stackpage.Tryhere();
		stackpage.enterPythonCode(tryherecode);
		stackpage.RunBtn();
	    Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=9)
	public void checkApplications() {
		stackpage.StackGetStarted();
		stackpage.Applications();;
		LoggerReader.info("User is in the Applications Page");
		stackpage.Tryhere();
		stackpage.EmptytryEditor();
		stackpage.RunBtn();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
	}
	
	@Test(priority=10, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testApplicationsInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		stackpage.StackGetStarted();
		stackpage.Applications();
		LoggerReader.info("User is in the Applications Page");
		stackpage.Tryhere();
		stackpage.enterPythonCode(tryherecode);
		stackpage.RunBtn();
		 String actualAlertMessage = stackpage.getAlertTextAndAccept(); // You'll define this in StackPage
		   // Assert the alert text
		   Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
    }
	
	@Test(priority=11, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testApplicationsValidPythonCode(String tryherecode, String expectedalertmessage) {
		stackpage.StackGetStarted();
		stackpage.Applications();
		LoggerReader.info("User is in the Applications Page");
		stackpage.Tryhere();
		stackpage.enterPythonCode(tryherecode);
		stackpage.RunBtn();
	    Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	

	
	

}
