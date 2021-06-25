package dataScriptsTestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import commonUtils.Utility;
import commonUtils.XmlReader;
import commonUtils.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataParamTest {
WebDriver driver;
ConfigFileReader configReader = new ConfigFileReader();
XmlReader xmlReader = new XmlReader();

	@Parameters("browser")
	@BeforeMethod
	public void launchbrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
//	@Test(dataProvider="testdata" , expectedExceptions=NoSuchElementException.class)
	@Test(dataProvider="testdata" , retryAnalyzer = RetryAnalyzerTest.class)
	public void login(String username,String Password) throws ParserConfigurationException, SAXException, IOException {
		driver.get("https://the-internet.herokuapp.com/login");
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(Password);
		
		driver.findElement(By.name(xmlReader.readXmlData("uname"))).sendKeys(username);
		driver.findElement(By.name(xmlReader.readXmlData("pwd"))).sendKeys(Password);
		
		driver.findElement(By.xpath(xmlReader.readXmlData("loginBtn"))).click();
		boolean loginsuccess = driver.findElement(By.id("flash")).isDisplayed();
		Assert.assertEquals(true, loginsuccess);
		boolean Header =driver.findElement(By.className("subheader")).isDisplayed();
		Assert.assertEquals(true, Header);
		driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();
		boolean logoutsuccess = driver.findElement(By.id("flash")).isDisplayed();
		Assert.assertEquals(true, logoutsuccess);	
	}
	
//	@DataProvider(name="testdata")
//	public Object[][] getdata(){
//		return new Object[][] {
//			new Object[] {"user1","password"},
//			new Object[] {"user2","password"},
//			new Object[] {"tomsmith","SuperSecretPassword!"},
//		};
//		}
		

	//Read from propertyFile
	
	@DataProvider(name="testdata")
	public Object[][] getdata() throws CsvValidationException, IOException{
		String path = System.getProperty("user.dir")+"/src/test/resources/testData/config.properties";
		Properties prop = configReader.readPropertiesFile(path);
		return new Object[][] {
		new Object[] {prop.getProperty("username"),prop.getProperty("password")}
		};
	}	
	
	
	
	
	//Read from .CSV file
	
//	@DataProvider(name="testdata")
//	public Object[][] getdata() throws CsvValidationException, IOException{
//		String path = System.getProperty("user.dir")+"/src/test/resources/testData/LoginData.csv";
//		CSVReader reader = new CSVReader(new FileReader(path));
//		String[] col;
//		ArrayList<Object[]> datalist = new ArrayList<Object[]>();
//		while((col=reader.readNext())!=null) {
//			Object[] record = {col[0],col[1]};
//			datalist.add(record);
//		}
//		reader.close();
//		return datalist.toArray(new Object[datalist.size()][]);
//	}
	

	//Read from .JSON file
	
//	@DataProvider(name="testdata")
//	public Object[][] getdata() throws IOException, ParseException {
//		
//		JSONParser parser = new JSONParser();	
//		String path = System.getProperty("user.dir")+"/src/test/resources/testData/LoginData.json";
//		FileReader reader = new FileReader(path);
//		Object obj = parser.parse(reader);
//		JSONObject jsonObj = (JSONObject)obj;
//		JSONArray userArray = (JSONArray)jsonObj.get("userlogins");
//		String arr[][] = new String[userArray.size()][];
//		
//		for(int i=0;i<userArray.size();i++) {
//			
//			JSONObject user = (JSONObject) userArray.get(i);
//			String username = (String)user.get("username");
//			String password = (String)user.get("password");
//			String record[] = new String[2];
//			record[0] = username;
//			record[1] = password;
//			arr[i] = record;
//		}
//
//		return arr;
//	}

	@AfterMethod
	public void teardown()  {
		driver.close();
	}
	
}
