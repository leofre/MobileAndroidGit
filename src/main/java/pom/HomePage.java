package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import utilities.BasicMethodsAndroidMobile;
import utilities.CommonVariables;

public class HomePage {
	
    private    ExtentTest _test;
	private    AndroidDriver _driver ;
	private    BasicMethodsAndroidMobile _basic; 
	private    CommonVariables commonVars =  new CommonVariables();
	private    By worldMusicButtonLocator = By.xpath("//*[@text='World Music']");
	
	
	public HomePage()
	{
		
	}
	
	public HomePage(AndroidDriver driver, ExtentTest test)
	{	
		_driver = driver;
		_test = test;
		_basic = new BasicMethodsAndroidMobile(_driver, _test) ;
	}
	
	
	public  WebElement getWorldMusicCategory() throws Exception
	{
		WebElement worldMusicButton = _basic.FindElementByWithoutFailLog(worldMusicButtonLocator, "In the home page can't find the category 'World Music'");
		return worldMusicButton;
	}
	

}
