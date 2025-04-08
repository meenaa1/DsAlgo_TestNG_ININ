package TestClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseClass.TestBase;
import PageObjects.LoginPage;
import PageObjects.QueuePage;
import Utilities.ConfigReader;
import Utilities.Dataprovider;
import Utilities.LoggerReader;

@Listeners(Utilities.Listener.class)
public class QueueTest extends TestBase {

	TestBase testBase =new TestBase();
	ConfigReader config = new ConfigReader();
	QueuePage queuepage = new QueuePage();
	LoginPage login = new LoginPage();
	String Username=ConfigReader.getProperty("username");
	String Password=ConfigReader.getProperty("password");
	
	 @BeforeMethod
	    public void setupPages() {
	        login = new LoginPage();
	        queuepage = new QueuePage();
	    }
	
	@Test(priority=1)
	public void testQueueGetStarted() {
        login.signin();
        login.login(Username, Password);
        queuepage.clickQueueGetStartedBtn();
        Assert.assertEquals(driver.getTitle(),"Queue");
        LoggerReader.info("User is in the Queue Page");
	}
	
	@Test(priority=2)
	public void checkImplementationofQueueinPython() throws InterruptedException {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationOfQueueInPython();
		LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		queuepage.clickTryHereBtn();
		queuepage.EmptytryEditor();
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
    }
	
	@Test(priority=3, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationOfQueueInPython();
		LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		queuepage.clickTryHereBtn(); 
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		   // Handle the alert popup and get the message
		String actualAlertMessage = queuepage.getAlertTextAndAccept(); // You'll define this in QueuePage
		   // Assert the alert text
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	}
	
	@Test(priority=4, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testValidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationOfQueueInPython();
		LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		queuepage.clickTryHereBtn();
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=5)
	public void checkPracticeQns() {
		//driver.navigate().back();
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationOfQueueInPython();
		//LoggerReader.info("User is in the Implementation Of Queue In Python Page");
		queuepage.clickQueuePracticeQuestionsBtn();
		Assert.assertEquals(driver.getTitle(), "Practice Questions");
		LoggerReader.info("User is in Practice Questions Page");
	}
	
	@Test(priority=6)
	public void checkImplementationUsingCollectionsDequeue() {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingCollectionsDequeue();
		LoggerReader.info("User is in the Implementation using collections.deque Page");
		queuepage.clickTryHereBtn();
		queuepage.EmptytryEditor();
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
	}
	
	@Test(priority=7, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationUsingCollectionsDequeueInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingCollectionsDequeue();
		LoggerReader.info("User is in the Implementation Using Collections Dequeue Page");
		queuepage.clickTryHereBtn(); 
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		   // Handle the alert popup and get the message
		String actualAlertMessage = queuepage.getAlertTextAndAccept(); // You'll define this in QueuePage
		   // Assert the alert text
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	}
	
	@Test(priority=8, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationUsingCollectionsDequeueValidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingCollectionsDequeue();
		LoggerReader.info("User is in the Implementation Using Collections Dequeue Page");
		queuepage.clickTryHereBtn();
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=9)
	public void checkImplementationusingarray() {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingArray();
		LoggerReader.info("User is in the Implementation using array Page");
		queuepage.clickTryHereBtn();
		queuepage.EmptytryEditor();
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
	}
	
	@Test(priority=10, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationusingarrayInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingArray();
		LoggerReader.info("User is in the Implementation using array Page");
		queuepage.clickTryHereBtn(); 
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		   // Handle the alert popup and get the message
		String actualAlertMessage = queuepage.getAlertTextAndAccept(); // You'll define this in QueuePage
		   // Assert the alert text
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	}
	
	@Test(priority=11, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testImplementationusingarrayValidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickImplementationUsingArray();
		LoggerReader.info("User is in the Implementation using array Page");
		queuepage.clickTryHereBtn();
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	@Test(priority=12)
	public void checkQueueOperations() {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickQueueOperations();
		LoggerReader.info("User is in the Queue Operations Page");
		queuepage.clickTryHereBtn();
		queuepage.EmptytryEditor();
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
		System.out.println("No Error Message is present");
	}
	
	@Test(priority=13, dataProvider="Invalidpythoncode", dataProviderClass= Dataprovider.class)
	public void testQueueOperationsInvalidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickQueueOperations();
		LoggerReader.info("User is in the Queue Operations Page");
		queuepage.clickTryHereBtn(); 
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		   // Handle the alert popup and get the message
		String actualAlertMessage = queuepage.getAlertTextAndAccept(); // You'll define this in QueuePage
		   // Assert the alert text
		Assert.assertTrue(actualAlertMessage.contains(expectedalertmessage),
		       "Expected alert message to contain: " + expectedalertmessage + ", but got: " + actualAlertMessage);
	}
	
	@Test(priority=14, dataProvider="Validpythoncode", dataProviderClass= Dataprovider.class)
	public void testQueueOperationsValidPythonCode(String tryherecode, String expectedalertmessage) {
		queuepage.clickQueueGetStartedBtn();
		queuepage.clickQueueOperations();
		LoggerReader.info("User is in the Queue Operations Page");
		queuepage.clickTryHereBtn();
		queuepage.enterPythonCode(tryherecode);
		queuepage.clickRunButton();
		Assert.assertEquals(driver.getTitle(), "Assessment");
	}
	
	
}

