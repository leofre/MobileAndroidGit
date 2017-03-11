import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.testng.annotations.Test;

public class TestMobile2 {

	

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

		
		// how to swipe until element is shown: https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004614?start=15
		/*
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		
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
		*/
		
		
		
		
		
	

		}
	
	
	 

	
}
