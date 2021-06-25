package scriptsTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestNGGoogleTest {
		WebDriver driver;

		@BeforeMethod(groups= {"firstgroup","secondgroup","thirdgroup"})
		public void setup() {
//			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumE2\\webdrivers\\chromedriver.exe");
			driver=new ChromeDriver();	
			driver.manage().window().maximize();
		}
		
	@Test(alwaysRun=true,dependsOnMethods="testAppium")
	public void testUft() throws InterruptedException {		
		driver.get("https://www.google.com");		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("UFT");
		Thread.sleep(3000);
		searchbox.submit();
		Assert.assertEquals(driver.getTitle(),"UFT - Google Search");
	}
	
	@Test(groups= {"secondgroup"})
	public void testSelenium() throws InterruptedException {	
		driver.get("https://www.google.com");		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("Selenium");
		Thread.sleep(3000);
		searchbox.submit();
		Assert.assertEquals(driver.getTitle(),"Selenium - Google Search");
		
	}
	
	@Test(priority=2)
	public void testAppium() throws InterruptedException {		
		driver.get("https://www.google.com");		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("Appium");
		Thread.sleep(3000);
		searchbox.submit();
		Assert.assertEquals(driver.getTitle(),"Appium - Google Search");
	}
	
	@Test(enabled=false)
	public void testSQL() throws InterruptedException {		
		driver.get("https://www.google.com");		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("SQL");
		Thread.sleep(3000);
		searchbox.submit();
		Assert.assertEquals(driver.getTitle(),"SQL - Google Search");
	}
	
	@Test(groups= {"firstgroup"})
	public void testJIRA() throws InterruptedException {		
		driver.get("https://www.google.com");		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("JIRA");
		Thread.sleep(3000);
		searchbox.submit();
		Assert.assertEquals(driver.getTitle(),"JIRA - Google Search");
	}

	@AfterMethod(groups= {"firstgroup","secondgroup","thirdgroup"})
	public void teardown() {
		driver.close();
	}
}
