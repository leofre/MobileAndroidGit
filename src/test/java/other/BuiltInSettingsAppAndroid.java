package other;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BuiltInSettingsAppAndroid {
	
	// https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3261854
	// 1.   adb shell
	// 2. dumpsys window windows | grep -E 'mCurrentFocus |mFocusedApp'   

	 
	
	
	@Test //Start Appium
	
	public void test() throws MalformedURLException, InterruptedException {

	
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		
		
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

	WebDriverWait _wait = new WebDriverWait(driver, 500);
	
	}

}
