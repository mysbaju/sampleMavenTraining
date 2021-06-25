package dataScriptsTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpectException {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver=new ChromeDriver();	
		driver.manage().window().maximize();
	}
	
@Test(expectedExceptions = NoSuchElementException.class)
public void testUft() {		
	driver.get("https://www.google.com");		
	WebElement searchbox=driver.findElement(By.name("q1"));
	searchbox.sendKeys("UFT");
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"UFT - Google Search");
}

@Test
public void testSelenium() {	
	driver.get("https://www.google.com");		
	WebElement searchbox=driver.findElement(By.name("q"));
	searchbox.sendKeys("Selenium");
	searchbox.submit();
	Assert.assertEquals(driver.getTitle(),"Selenium - Google Search");
	
}


@AfterMethod
public void teardown() {
	driver.close();
}
}
