import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.testng.annotations.Test;


//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004620


public class TestMobile {

	

	@Test
	
		public void test() throws MalformedURLException, InterruptedException {
		   
		       File appDir = new File("src");
		   
		    File app = new File(appDir, "raaga.apk");

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@text='World Music']")).click();
		MobileElement mostPopular =  (MobileElement)driver.findElement(By.xpath("//*[@text='New Releases']"));
		TouchAction touch = new TouchAction(driver);
		
		do {
		try {
			
			driver.findElement(By.xpath("//*[@text='Trending']"));
		break;
		
		} 
		
		catch (NoSuchElementException nse) 
		{
		
			mostPopular.swipe(SwipeElementDirection.LEFT, 500);
			

		}
		} while (true);
		
		//driver.findElement(By.xpath("//*[@text='Trending']")).click();
		System.out.println("Touching");
		touch.tap(driver.findElement(By.xpath("//*[@text='Trending']"))).perform();

		
		
		System.out.println("until now");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		/*
		do {
		try {
			
			driver.findElement(By.xpath("//*[@text='Silences']"));
		break;
		
		} 
		
		catch (NoSuchElementException nse) 
		{
			
			System.out.println(driver.findElements(By.id("com.raaga.android:id/album_music_details_container")).size());
			MobileElement firstSong = (MobileElement)driver.findElements(By.id("com.raaga.android:id/album_music_details_container")).get(3);
			firstSong.swipe(SwipeElementDirection.UP, 500);
			

		}
		} while (true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@text='Silences']")).click();
		touch.tap(driver.findElement(By.xpath("//*[@text='Silences']"))).perform();
		*/
		

		//* or this option :
		
		do {
		try {
			
			driver.findElement(By.xpath("//*[@text='Silences']"));
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

		driver.findElement(By.xpath("//*[@text='Silences']")).click();
		//*/
	}
		
		
	}
	
	

	

