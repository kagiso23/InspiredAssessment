package Pages;

import HelperFunctions.TakeAlotHelperFunction;
import Utilities.JsonUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import storage.Constants;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TestBase {
    public static final String aut_url = "https://www.takealot.com/";
    public static final String chromeProfilePath = "C:\\Users\\KagisoMabokela\\AppData\\Local\\Google\\Chrome\\User Data";
    public static RemoteWebDriver driver;
    public ExtentSparkReporter report = new ExtentSparkReporter("C:\\InspiredAssessmentAutomation\\InspiredTestingBasicFramework\\reports\\TestReport_" + new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date()) + ".html");
    public static ExtentTest logger;
    public static ExtentReports extent;
    @BeforeClass
    public void before() throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\InspiredAssessmentAutomation\\InspiredTestingBasicFramework\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions chromeProfile = new ChromeOptions();
        chromeProfile.addArguments("user-data-dir=" + chromeProfilePath);
        extent = new ExtentReports();
        extent.attachReporter(report);
        report.config().setTheme(Theme.DARK);
        report.config().setDocumentTitle("Inspired Assessment Test Report");
        report.config().setReportName("Automation Tests Report");
        extent.setSystemInfo("Environment", "Prod");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        if (ITestResult.FAILURE == result.getStatus()) {

            logger.log(Status.FAIL, result.getName() + " Failed");
            logger.log(Status.FAIL, "Logs For " + result.getName() + "\n  " + result.getThrowable());
        } else if (ITestResult.SKIP == result.getStatus()) {
            logger.log(Status.SKIP, result.getName() + " Skipped");
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            logger.log(Status.PASS, result.getName() + " Passed");
        }
    }

    @AfterClass
    public void after() {
        if (driver != null) {
            driver.quit();
            extent.flush();
        }
    }
}
