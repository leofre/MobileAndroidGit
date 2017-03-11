package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShots {
	
	public static String takeScreenShots(AndroidDriver driver, String fileName) throws IOException
	{
		fileName= fileName+".png";
		String directory= CommonVariables.pathForScreenShots;
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = directory+fileName;
		FileUtils.copyFile(sourceFile, new File(destination));
		return destination;
		
				
		
	}
	
	
	
	public static void insertScreenShotIntoReport(AndroidDriver driver, String methodName, ExtentTest test) throws IOException
	{
		
			String path= ScreenShots.takeScreenShots(driver, methodName);
			String imagePath= test.addScreenCapture(path);
			test.log(LogStatus.FAIL, imagePath);	
	}
	

}
