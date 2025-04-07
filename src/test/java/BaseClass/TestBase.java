package BaseClass;

import DriverFactory.driverFactory;
import Utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class TestBase {
    public WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("edge") String browser) {
    driverFactory.setBrowser(browser);
    driver = driverFactory.initiateDriver();
    ChainTestListener.log("Browser factory setup");
    }
    @BeforeMethod
    public void navigateToHomePage() {
    driver.get(ConfigReader.getProperty("homeUrl"));  // Open the URL explicitly before each test
    }
    @AfterClass
    public void tearDown() {
    	driverFactory.quitDriver(); 
    }
    }


  

