package nativeApp;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class HowToRunOnRealDevice {
	
	
	//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004620
	//In mobile settings->about device-> tap on serial number 7 times->developer options will be enabled-> go to developer options in settings only (above about device) - > enable developer options.
	//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2028820
	//how-to-debug-your-android-app-over-wifi-without-root:   
	//https://futurestud.io/tutorials/how-to-debug-your-android-app-over-wifi-without-root
	//http://stackoverflow.com/questions/4893953/run-install-debug-android-applications-over-wi-fi
	// restart your device after that
	
	@Test
	
		public void test() throws MalformedURLException, InterruptedException {
		       File appDir = new File("src");
		   
		    File app = new File(appDir, "BookMyShow.apk");

		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.id("com.bt.bms:id/btnLogin")).click();
		Thread.sleep(20000);



		
		
		}

}
