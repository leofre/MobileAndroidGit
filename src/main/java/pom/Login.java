package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import utilities.BasicMethodsAndroidMobile;
import utilities.CommonVariables;

public class Login {

	
    private    ExtentTest _test;
	private    AndroidDriver _driver ;
	private    BasicMethodsAndroidMobile _basic; 
	private    CommonVariables commonVars =  new CommonVariables();
	private    By doneButtonLocator = By.xpath("//*[@text='Done']");
	private    By skipButtonLocator = By.xpath("//*[@text='or Skip to Raaga']");

	
	
	public Login()
	{
		
	}
	
	public Login(AndroidDriver driver, ExtentTest test)
	{	
		_driver = driver;
		_test = test;
		_basic = new BasicMethodsAndroidMobile(_driver, _test) ;
	}
	
	
	public  WebElement getdoneButton() throws Exception
	{
		WebElement doneButton = _basic.FindElementByWithoutFailLog(doneButtonLocator, "In login 'Done' button didn't appear");
		return doneButton;
	}
	
	public  WebElement getSkipButton() throws Exception
	{
		WebElement skipButton = _basic.FindElementByWithoutFailLog(skipButtonLocator, "In login 'skip' button didn't appear");
		return skipButton;
	}
	
    public  void clickOnDoneButtonIfExist()
    {
  	  
    	for (int i=0; i < 20; i++)
    	{
    		
    		try 
    		{
  			_basic.setDriverTimeOut(CommonVariables.minTimeOut);
  			getSkipButton();
  			_basic.setDriverTimeOut(CommonVariables.maxTimeOut);
  			break;
    		}
    		catch (Exception exceptionOne )
    		{
    			
    			try
    			{
    				getdoneButton().click();
    	  			_test.log(LogStatus.INFO, "In the Login page 'Done' button has been clicked");
    	  		    _basic.setDriverTimeOut(CommonVariables.maxTimeOut);
    	  		    break;
    			}
    			
    			catch (Exception exceptionTwo)
    			{
    				_test.log(LogStatus.INFO, "On Login page the 'Done' button or the 'Skip' button haven't appear, the page is loading");
    			}
  		
    		}
    		
    	}



    }
	
	
}
