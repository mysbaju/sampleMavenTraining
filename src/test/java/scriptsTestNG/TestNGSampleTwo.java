package scriptsTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSampleTwo {
	WebDriver driver;
	
	@BeforeMethod(groups= {"firstgroup","secondgroup","thirdgroup"})
	public void setup() {
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumE2\\webdrivers\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();
	}
@Test(groups= {"firstgroup"})
public void testHP() throws InterruptedException {	
	driver.get("https://www.google.com");		
//	SoftAssert softassert=new SoftAssert();
//	softassert.assertEquals(driver.getTitle(), "Google");
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("HP");
	Thread.sleep(3000);
	searchbox.submit();
//	softassert.assertEquals(driver.getTitle(), "ALM - Google Search");
//	softassert.assertAll();
	Assert.assertEquals(driver.getTitle(),"HP - Google Search");
}

@Test(groups= {"secondgroup"})
public void testDELL() throws InterruptedException {	
	driver.get("https://www.google.com");	
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("DELL");
	Thread.sleep(3000);
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"DELL - Google Search");
}

@Test(groups= {"thirdgroup"})
public void testAndroid() throws InterruptedException {	
	driver.get("https://www.google.com");	
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("Android");
	Thread.sleep(3000);
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"Android - Google Search");
}


@AfterMethod(groups= {"firstgroup","secondgroup","thirdgroup"})
public void teardown() {
	driver.close();
}
}
