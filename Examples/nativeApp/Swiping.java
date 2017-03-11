package nativeApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Swiping {
	
	
	// how to swipe until element is shown: https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004614?start=15
	// http://qavalidation.com/2016/07/scrolling-in-appium.html/
	// https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3332118

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

		driver.findElement(By.xpath("//*[@text='Views']")).click();
		
		
		
		//Btw, if you need to get coordinates of an element or just some point on the screen, you can get those from top right corner of the UI Automator Viewer also the bounds attribute.
		// https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2125036
		
		
		do {
		try {
			
			driver.findElement(By.xpath("//*[@text='Tabs']")).click();
		break;
		
		} 
		
		catch (NoSuchElementException nse) 
		{
		Dimension dimensions = driver.manage().window().getSize();
		System.out.println("the dimensions is: "+dimensions);
		Double screenHeightStart = dimensions.getHeight() * 0.9;
		System.out.println("the dimensions Height is: "+dimensions.getHeight());
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.0;
		int scrollEnd = screenHeightEnd.intValue();
		driver.swipe(0, scrollStart, 0, scrollEnd, 500);
		
		
		
	
		

		
		}
		} while (true);
		

		}






// Swipe method (you can use swipe up & down & left & right) https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2404082

@Test

	public void test2() throws MalformedURLException, InterruptedException {
	File appDir = new File("src");
	File app = new File(appDir, "BookMyShow.apk");

	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElementById("com.bt.bms:id/btnNoThanks").click();
	driver.findElement(By.id("com.bt.bms:id/dismiss")).click();
	MobileElement Mumbai = (MobileElement) driver.findElement(By.xpath("//*[@text='Mumbai']"));
	Mumbai.swipe(SwipeElementDirection.DOWN, 20000); // (you can use swipe up & down & left & right)
	

	
	}
	


}
