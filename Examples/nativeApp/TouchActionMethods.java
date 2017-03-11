package nativeApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TouchActionMethods {
	
	// https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3240386
	
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	File appDir = new File("src");
	File app = new File(appDir, "apiDemos.apk");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	TouchAction touch = new TouchAction(driver);
	
		// How to tap on element :like clicking on an element : https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2016932
	// How to long press on an element :like clicking on element : https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2016932
	
			WebElement element = driver.findElement(By.id("jgjgj"));
			touch.tap(element).perform(); 
			touch.press(element).waitAction(2000).release().perform();
	
			
			WebElement element2 = driver.findElement(By.id("jgjgj"));
			touch.longPress(element2).perform();
			
			
			
			
			
			
		    
	
	
	
	
	
	}

	
}
