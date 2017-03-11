package other;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.BasicMethodsAndroidMobile;

public class TestWebApp {
	
	private AndroidDriver _driver;
	private WebDriverWait _wait;
	
	private BasicMethodsAndroidMobile basic = new BasicMethodsAndroidMobile();
	private ExtentReports report;
	private ExtentTest test;
    private File appDir = new File("src");
    private File app = new File(appDir, "udemy.apk");
    String nameOfThisSuite= "TestWebApp";
    private    AppiumServiceBuilder service;
	
	@BeforeMethod
	public void Initialize() throws MalformedURLException
	{
		
		_driver= basic.configureDriverForAndroidWebApp();
		_wait = new WebDriverWait(_driver, 70);
		
	}

	
@Test // Start Appium Server
	
	public void test() throws MalformedURLException, InterruptedException {
	
	_driver.get("https://www.google.co.il");
	_wait.until(ExpectedConditions.visibilityOf(_driver.findElement(By.id("lst-ib"))));
	_driver.findElement(By.id("lst-ib")).sendKeys("Testing");
	_driver.findElement(By.xpath("//button[@name='btnG']")).click();
	Thread.sleep(15000);
	

	
}

}
