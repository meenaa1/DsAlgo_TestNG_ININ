package BaseClass;

import DriverFactory.driverFactory;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;
//    GraphPage graphpage;
//    LoginPage login;
//    String Username = ConfigReader.getProperty("username");
//    String Password = ConfigReader.getProperty("password");

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(@Optional("chrome") String browser) {
		driverFactory.setBrowser(browser);
		driver = driverFactory.initiateDriver();
		// Initialize the Page Objects here to ensure they are tied to the session
//        graphpage = new GraphPage();
//        login = new LoginPage();
	}

	@BeforeMethod
	public void navigateToHomePage() {
		
		driver.get(ConfigReader.getProperty("homeUrl")); // Open the URL explicitly before each test
	}

	@AfterClass
	public void afterClass() {

		if (driver != null) {
			driver.quit(); // Quit WebDriver after all tests
		}
	}
}
