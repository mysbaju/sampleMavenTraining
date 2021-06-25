package commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getScreenShot(WebDriver driver){
		TakesScreenshot screen=(TakesScreenshot)driver;
		File scrFile=screen.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screehshot/"+System.currentTimeMillis()+".png";
		File dest=new File(path);
		try {
			FileUtils.copyFile(scrFile, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
