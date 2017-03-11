package utilities;


import java.io.File;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom.HomePage;

public class BasicMethodsAndroidMobile {
	
	
	private    AndroidDriver _driver;
	private    ExtentTest _test;
	private    CommonVariables commonVars =  new CommonVariables();
	private    By declineRatePopupButton = By.xpath("//*[@text='No, Thanks']");
	private    By declineUpdatePopupButton = By.xpath("//*[@text='Later']");
	
	public BasicMethodsAndroidMobile()
	{

	}
	
	
	public BasicMethodsAndroidMobile(AndroidDriver driver, ExtentTest test)
	{
		_driver = driver; 	
    	_test = test;
	}
	
	public BasicMethodsAndroidMobile(AndroidDriver driver)
	{
		_driver = driver; 	
	}	
	
	
	public BasicMethodsAndroidMobile(ExtentTest test)
	{
		_test = test;
	}
	
    public static AndroidDriver configureDriverForAndroidNativeApp(String appPath, ExtentTest test) throws Exception
    {
    	try
    	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "700");
		cap.setCapability(MobileCapabilityType.APP, appPath);
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    test.log(LogStatus.INFO, "Successfully configured android driver for testing native app");

    	return driver;
    	}
    	
    	catch (Exception exc)
    	{
    		String exception = "Failed to configure android driver for native app";
    	    test.log(LogStatus.FAIL, exception);
    		throw new Exception(exception);
    	}
    }
    
    
    public AndroidDriver configureDriverForAndroidWebApp() throws MalformedURLException // Refactor it 
    {

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
    	return driver;
    	
    }
    
    
    
   
    
    public static AppiumServiceBuilder configureAppiumServer(String nameOfThisSuite) 
    {
    	AppiumServiceBuilder service = new AppiumServiceBuilder().usingDriverExecutable(new File(CommonVariables.pathOfTheAppiumNode)).withAppiumJS(new File(CommonVariables.pathOfTheAppiumJS)).withLogFile(new File(CommonVariables.pathOfTheAppiumLogs+nameOfThisSuite+".txt"));
    	return service;


    }

    
    public static void startAppiumServer(AppiumServiceBuilder service, String suiteName, ExtentTest test) throws Exception

    {
    	stopAppiumServer(service, test);
    	
		try
		{
			service.build().start();
    	    test.log(LogStatus.INFO, "Successfully started appium server");
		}

    	
    	catch (Exception exp)
    	{
    		String exception = "Failed to start appium server";
			test.log(LogStatus.FAIL, exception);	
    		throw new Exception(exception);
    	}
    	
    }
    
    public static void stopAppiumServer(AppiumServiceBuilder service, ExtentTest test)
    {
    	try
    	{
    		service.build().stop();
    	    test.log(LogStatus.INFO, "Successfully stopped appium server");

    		
    	}
    	
    	catch (Exception e)
    	{
    		test.log(LogStatus.INFO, "Can't stop appium server");
    	}
    	
    }
    
    
    public void declineRatePopUp()
    {
    	
		try 
		{
			setDriverTimeOut(CommonVariables.minTimeOut);
			_driver.findElement(declineRatePopupButton).click();
			setDriverTimeOut(CommonVariables.maxTimeOut);
			_test.log(LogStatus.INFO, "'Rate' Pop Up has been declined");
		}
		
		catch (Exception a ) // if exception thrown that mean that 'rate' pop up didn't appear. 
		{
			setDriverTimeOut(CommonVariables.maxTimeOut);
			_test.log(LogStatus.INFO, "'Rate' Pop Up didn't appear");
		}
    }
    

      public static void Cleanup(AndroidDriver driver, AppiumServiceBuilder service, ExtentTest test)
      {
    	  
           driver.quit();
           stopAppiumServer(service, test);

      }
     
      
      

      
      
    
      public  void declineUpgradePopUp()
      {
    	  
      	HomePage homepage = new HomePage();
      	for (int i=0; i < 20; i++)
      	{
      		
      		try 
      		{
    			setDriverTimeOut(CommonVariables.minTimeOut);
    			homepage.getWorldMusicCategory();
    			setDriverTimeOut(CommonVariables.maxTimeOut);
    			break;
      		}
      		catch (Exception exceptionOne )
      		{
      			
      			try
      			{
      				FindElementByWithoutFailLog(declineUpdatePopupButton, "'Update' Pop Up decline button didn't appear").click();
      	  			_test.log(LogStatus.INFO, "Upgrade Pop Up has been declined");
      	  		    setDriverTimeOut(CommonVariables.maxTimeOut);
      	  		    break;
      			}
      			
      			catch (Exception exceptionTwo)
      			{
      				_test.log(LogStatus.INFO, "Upgrade Pop Up or the home page still haven't appear, the app is loading");
      			}
    		
      		}
      		
      	}



      }
      
      
      
      public static void unlockDevice(AndroidDriver driver, ExtentTest test)
      {
  		if(driver.isLocked())
  		{
  			driver.unlockDevice();
  		    test.log(LogStatus.INFO, "Successfully unlocked device");	

  			
  		}
    	  
      }
      
      
      public static ExtentReports  getReportInstance(String name)
      {
    	  ExtentReports report = new ExtentReports(CommonVariables.pathOfDirectoryThatContainsReports+"\\"+name+".html", true);
    	 
    	  
    	  return report;
      }
      
      public void setDriverTimeOut(int seconds)
      {
    	  _driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

      }
      
      
      public static void setDriverTimeOut(AndroidDriver driver, int seconds, ExtentTest test)
      {
    	  driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

      }
      
      
      
    public static void preconditionForTestingNativeApp(AndroidDriver driver,ExtentTest test) throws Exception
    {
    	setDriverTimeOut(driver, CommonVariables.maxTimeOut, test);
        unlockDevice(driver, test);
	    test.log(LogStatus.INFO, "Successfully configured all preconditions for native app");	
    	
    		
    }
      
      


     
     
     public  WebElement FindElementByXpath(String TheXpath, String exception) throws Exception
     {

          try
          {
              return _driver.findElement(By.xpath(TheXpath));
              
                          
          }
         

          catch (Exception exc)
          {
        	  _test.log(LogStatus.FAIL, exception);
              throw new Exception(exception);

          }

     }
     
     
     public  WebElement FindElementByName(String name, String exception) throws Exception
     {

         try
         {
        	 return _driver.findElement(By.name(name));
        	 
        	 
                           
         }
        

         catch (Exception exc)
         {
        	 _test.log(LogStatus.FAIL, exception);
             throw new Exception(exception);
             

         }

     }
     
     
     public  WebElement FindElementById(String id, String exception) throws Exception
     {

         try
         {
        	 return _driver.findElement(By.id(id));
        	 
                           
         }
        

         catch (Exception exc)
         {
        	 _test.log(LogStatus.FAIL, exception);
             throw new Exception(exception);

         }
         
     }
         
         public  WebElement FindElementBy(By locator, String exception) throws Exception
         {

             try
             {
            	 return _driver.findElement(locator);
            	 
                               
             }
            

             catch (Exception exc)
             {
            	 _test.log(LogStatus.FAIL, exception);
                 throw new Exception(exception);

             }
         
 
     }
     
         public  WebElement FindElementByWithoutFailLog(By locator, String exception) throws Exception
         {

             try
             {
            	 return _driver.findElement(locator);
            	 
                               
             }
            

             catch (Exception exc)
             {
            	 _test.log(LogStatus.INFO, exception);
                 throw new Exception(exception);

             }
         
 
     }
     
    
     
     
     
     


}
