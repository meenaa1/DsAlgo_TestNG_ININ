package BaseClass;

import DriverFactory.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        driverFactory.setBrowser(browser);
        driver = driverFactory.initiateDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverFactory.quitDriver();
    
}
}
