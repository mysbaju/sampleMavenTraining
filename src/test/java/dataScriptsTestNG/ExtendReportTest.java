package dataScriptsTestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonUtils.Utility;

public class ExtendReportTest {
WebDriver driver;
ExtentTest extentTest;
ExtentReports reports;	
ExtentHtmlReporter htmlReport;

@BeforeTest()
public void setExtent() {
	reports=new ExtentReports();
	htmlReport=new ExtentHtmlReporter("/Users/balajikumar/Desktop/Selenium_E2/Screenshot/ExtendReport.html");
	reports.attachReporter(htmlReport);
}
@BeforeMethod()
	public void setup() {
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
}

@Test()
public void testHP() {	
	extentTest=reports.createTest("HP test");
	driver.get("https://www.google.com");
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("HP");
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"HP - Google Search");
}


@Test()
public void testDELL() {
	extentTest=reports.createTest("DELL test");
	driver.get("https://www.google.com");	
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("DELL");
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"DELL - Google Searc");
}

@Test()
public void testAndroid() {	
	extentTest=reports.createTest("Android test");
	driver.get("https://www.google.com");	
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("Android");
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"Android - Google Search");
}

@AfterMethod()
public void teardown(ITestResult result) throws IOException {
	if(ITestResult.FAILURE==result.getStatus()) {
		String path=Utility.getScreenShot(driver);
		extentTest.fail(result.getName());
		extentTest.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
	else if(ITestResult.SKIP==result.getStatus()) {
		extentTest.skip(result.getName());
	}
	driver.close();
}
@AfterTest()
public void fineshReport() {
	reports.flush();
}
}
