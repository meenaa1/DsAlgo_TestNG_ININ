package BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.aventstack.chaintest.plugins.ChainTestListener;
import DriverFactory.driverFactory;
import Utilities.ConfigReader;

@Listeners(Utilities.Listener.class)
public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        driverFactory.setBrowser(browser);
        driver = driverFactory.initiateDriver();
        ChainTestListener.log("Browser factory setup");
    }

    @BeforeMethod
    public void navigateToHomePage() {
        driver.get(ConfigReader.getProperty("homeUrl"));
    }

    @AfterClass
    public void tearDown() {
    	driverFactory.quitDriver(); 
    }
}
