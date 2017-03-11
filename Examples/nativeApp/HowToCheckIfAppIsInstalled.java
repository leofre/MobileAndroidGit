package nativeApp;
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

public class HowToCheckIfAppIsInstalled {
	
	
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	File appDir = new File("src");
	File app = new File(appDir, "BookMyShow.apk");

	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
	//How to check if app is installed and if it isn't install so how to install it: https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/2004616 

		/*
		if(! driver.isAppInstalled(bundleId)) // If app is not installed so we will install it --> What is a bundleId ?
		{
			driver.installApp(app.getAbsolutePath());
		}
	    */
	
	}
}
