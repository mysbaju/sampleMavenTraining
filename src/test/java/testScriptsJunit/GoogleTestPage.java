package testScriptsJunit;


import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleTestPage {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.out.println("Execution Started");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate() .to("https://google.com");
		
	}
	@Test
	public void javaSearchTest() {
		
		
		System.out.println("Page Title before search "+driver.getTitle());
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");		
		searchBox.submit();
		System.out.println("Page Title after search "+driver.getTitle());

		Assert.assertEquals("Java Tutorial - Google Search", driver.getTitle());

	}

	
	@Test
	public void searchSeleniumTest() {
		
		
		System.out.println("Page Title before search "+driver.getTitle());
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium Tutorial");		
		searchBox.submit();
		System.out.println("Page Title after search "+driver.getTitle());

		Assert.assertEquals("Selenium Tutorial - Google Search", driver.getTitle());

		}
	
	@After
	public void tearDown() {
		
		driver.close();
		driver.quit();
		System.out.println("Execution Ended");
		
	}

	
}
