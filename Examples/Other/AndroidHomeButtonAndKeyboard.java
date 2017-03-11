import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AndroidHomeButtonAndKeyboard {
	
	//also how to use keyboard https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3240250
	// keyboard: https://community.perfectomobile.com/posts/1030842-sending-key-events-to-your-android-device
	//keyboard: https://developer.android.com/reference/android/view/KeyEvent.html
	//keybord by xml:  https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3348186
	
	
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	       File appDir = new File("src");
	   
	    File app = new File(appDir, "BookMyShow.apk");

	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.findElement(By.id("com.bt.bms:id/btnLogin")).click();
	// this is the method:  .pressKeyCode(AndroidKeyCode.HOME)
	driver.pressKeyCode(AndroidKeyCode.HOME);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	driver.pressKeyCode(36);
	driver.pressKeyCode(36, AndroidKeyMetastate.META_CAPS_LOCK_ON);
	
	
	driver.getKeyboard().sendKeys("1234");
	//or
	driver.pressKeyCode(AndroidKeyCode.KEYCODE_1);
	driver.pressKeyCode(AndroidKeyCode.KEYCODE_2);
	
	}

}
