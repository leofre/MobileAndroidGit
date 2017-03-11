import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class GeneralMethods {
	
	
	
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	File appDir = new File("src");  
	File app = new File(appDir, "apiDemos.apk");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	TouchAction touch = new TouchAction(driver);
	
	
	
	//how to close app : https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004616
		
		driver.closeApp();	
		 


	
	// how to get the activity of the page: each page have different activity: https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004616
		
		driver.currentActivity();
		 
	
	
	
	// how to know if app is locked or not : https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004616
		
		driver.isLocked();
	   
	
	
	
	// how to know if app is native or not : https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004616
		/*
		driver.getContext();
		 */

	
	
	
	}
	
	
	

}
