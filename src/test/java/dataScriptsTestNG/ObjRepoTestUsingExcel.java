package dataScriptsTestNG;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtils.ExcelReader;





public class ObjRepoTestUsingExcel {

	public static void main(String[] args) throws IOException {
		
		ExcelReader excelReader = new ExcelReader();
		
		System.out.println("Execution Started");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
		
		driver.findElement(By.name(excelReader.readExcelData("uname"))).sendKeys("tomsmith");
		driver.findElement(By.name(excelReader.readExcelData("pwd"))).sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.xpath(excelReader.readExcelData("loginBtn"))).click();
		boolean loginsuccess = driver.findElement(By.xpath(excelReader.readExcelData("sucessMsg"))).isDisplayed();
		System.out.println("Login Success is " + loginsuccess);
			
		driver.close();
		driver.quit();
		System.out.println("Execution Ended");

	}

}
