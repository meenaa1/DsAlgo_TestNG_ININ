package Listeners;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import DriverFactory.driverFactory;
import Utilities.ExtentReporter;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class Listener implements ITestListener {

    private static ExtentReports extent = ExtentReporter.getExtentReport();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        test.log(Status.INFO, result.getName() + " started");
        System.out.println(result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, result.getName() + " passed");
        System.out.println(result.getName() + " success");
    }

  
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, result.getName() + " failed");
        System.out.println(result.getName() + " failed");

        WebDriver driver = driverFactory.getDriver();
        if (driver != null) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                ChainTestListener.embed(screenshotFile, "image/png");

                String screenshotDir = "target/screenshots/";
                File screenshotFolder = new File(screenshotDir);
                if (!screenshotFolder.exists()) {
                    screenshotFolder.mkdirs();
                }
                String filePath = screenshotDir + result.getName() + ".png";
                FileUtils.copyFile(screenshotFile, new File(filePath));

                extentTest.get().addScreenCaptureFromPath(filePath);
                System.out.println("Screenshot saved at: " + filePath);

                attachScreenshotToAllure(driver);

            } catch (org.openqa.selenium.NoSuchSessionException e) {
                System.out.println("WebDriver session is closed. Screenshot not taken.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver is null, screenshot not taken.");
        }
    }

    
    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static void attachScreenshotToAllure(WebDriver driver) {
	 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
 }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, result.getName() + " skipped");
        System.out.println(result.getName() + " skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Tests executions started");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); 
        System.out.println("Tests executions completed");
    }
}