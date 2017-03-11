
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.BasicMethodsAndroidMobile;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestWeb {

	// https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2028806
	// If it is a web responsive design so no need for connecting the mobile watch from 12:00 :
	// https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2149742
	
	// Go to: Appium\node_modules\appium\node_modules\appium-chromedriver\chromedriver and switch chromedriver to a new one
	// For chrome:    https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3342226
	
	private AndroidDriver _driver;
	private WebDriverWait _wait;
	private BasicMethodsAndroidMobile basic = new BasicMethodsAndroidMobile();
	private ExtentReports report;
	private ExtentTest test;
    String nameOfThisSuite= "TestWeb";
    private    AppiumServiceBuilder service;
    
    
	@BeforeMethod
	public void Initialize() throws MalformedURLException 
	{
		basic.stopAppiumServer(service);
		basic.startAppiumServer(nameOfThisSuite, service);
		_driver= basic.configureDriverForAndroidWebApp();
		_wait= basic.InitializeWait(_driver);
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult methodResult) throws IOException
	{
		
		basic.Cleanup(_driver, service);
		
	}
	
	@Test
	
		public void test()  {
		
		
			System.out.println(_driver.getContext());
		
		
		_driver.get("http://www.udemy.com");
		_driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SoapUI");
		_driver.findElement(By.xpath("//button[@class='home-search-btn']")).click();


		}
	
	
	 

	
}
