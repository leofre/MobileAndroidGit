package TrendingCategory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom.HomePage;
import pom.Login;
import pom.TrendingCategoryPage;
import pom.WorldMusicPage;
import utilities.BasicMethodsAndroidMobile;
import utilities.CommonVariables;
import utilities.ScreenShots;
import utilities.MobileAndroidUtilities;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004620





public class ChooseSong {

	private AndroidDriver _driver;
	private ExtentTest _test;
	private BasicMethodsAndroidMobile basic;
	private ExtentReports report;
	private String nameOfThisSuite= "Test Trending Category";
	private AppiumServiceBuilder service;
    private String nameOfSongToChoose = "Lalit";
	private HomePage homePage; 
	private WorldMusicPage worldMusic;
	private TrendingCategoryPage trending;
	private Login login;

	
	

	
	@BeforeSuite
	public void Initialize() throws Exception
	{
    	service= BasicMethodsAndroidMobile.configureAppiumServer(nameOfThisSuite);
    	report = BasicMethodsAndroidMobile.getReportInstance(nameOfThisSuite);
    	_test = report.startTest("Before Method");
		_test.log(LogStatus.INFO, "Starting Annotation 'Before Suite'");
		BasicMethodsAndroidMobile.startAppiumServer(service, nameOfThisSuite, _test);
		_driver = BasicMethodsAndroidMobile.configureDriverForAndroidNativeApp(CommonVariables.raagaAppPath, _test);
		BasicMethodsAndroidMobile.preconditionForTestingNativeApp(_driver,_test);
		_test.log(LogStatus.PASS, "Finished Annotation 'Before Suite'");
		report.endTest(_test);
	}

	
	
	
	@AfterSuite
	public void clean()
	{
		BasicMethodsAndroidMobile.Cleanup(_driver, service, _test);
		report.flush();
	}
	
	@AfterMethod

	public void afterMethod(ITestResult methodResult) throws IOException
	{

		if (methodResult.getStatus()== ITestResult.FAILURE)
		{
			String methodName = methodResult.getName();
			ScreenShots.insertScreenShotIntoReport(_driver, methodName, _test);
		}
		report.endTest(_test);
	}

	
	
	
	@Test //(priority = 0)
	public void chooseSongOnTrendingCategory() throws Exception {       
		String nameOfTestWithoutSpaces = new Object(){}.getClass().getEnclosingMethod().getName();
		String nameOfTestWithSpaces = MobileAndroidUtilities.splitStringWithCamelCase(nameOfTestWithoutSpaces);
		_test = report.startTest(nameOfTestWithSpaces);
		
		basic = new BasicMethodsAndroidMobile(_driver, _test);
		homePage = new HomePage(_driver,  _test);
		worldMusic= new WorldMusicPage(_driver,  _test);
		trending= new TrendingCategoryPage(_driver,  _test);
		login= new Login(_driver,  _test);

		
		_test.log(LogStatus.INFO, "Starting test "+ nameOfTestWithSpaces);
		login.clickOnDoneButtonIfExist();
		login.getSkipButton().click();
		//basic.declineUpgradePopUp();	
		homePage.getWorldMusicCategory().click();
		_test.log(LogStatus.INFO, "In the home page, category 'World Music' has been chosen");
		//basic.declineRatePopUp();
		worldMusic.swipeToTrendingCategoryAndChooseIt();
		trending.declineCommercialWhenEnteringTrendingPage();
		trending.chooseSong(nameOfSongToChoose);
		_test.log(LogStatus.PASS, "Successfully finished test "+ nameOfTestWithSpaces);

		
	}
		
		
	}
	
	

	

