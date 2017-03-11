package webApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.testng.annotations.Test;

public class TestMobile2 {

	// https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2028806
	// If it is a web responsive design so no need for connecting the mobile watch from 12:00 :
	// https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2149742
	
	// 

	@Test
	
		public void test() throws MalformedURLException, InterruptedException {
		
		
	  //  File appDir = new File("src"); 
	   //File app = new File(appDir, "chrome.apk");
	    
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		//cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.udemy.com");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SoapUI");
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@class='home-search-btn']")).click();
		Thread.sleep(20000);


		
		
		
		
	

		}
	
	
	 

	
}
