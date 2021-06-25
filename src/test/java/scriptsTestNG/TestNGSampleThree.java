package scriptsTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGSampleThree {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumE2\\webdrivers\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
	}
@Test()
public void testTCS() throws InterruptedException {	
	long id=Thread.currentThread().getId();
	System.out.println(id);
}

@Test()
public void testCITI() throws InterruptedException {	
	long id=Thread.currentThread().getId();
	System.out.println(id);
}

@Test(threadPoolSize=3, invocationCount=3, timeOut=1000)
public void testOS() throws InterruptedException {
	long id=Thread.currentThread().getId();
	System.out.println(id);
}


@AfterTest
public void teardown() {
	driver.close();
}
}
