import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InvokeAppWithoutInstallingIt {

	//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/3659532
	//https://www.udemy.com/mobile-automation-using-appiumselenium-3/learn/v4/t/lecture/3659536
	//good way: https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3349036   from 13:40
	//https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3073162
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	   

	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "net.one97.paytm");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "net.one97.paytm.landingpage.activity.AJRMainActivity");
	
	
	AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.findElement(By.id("com.bt.bms:id/btnLogin")).click();
	Thread.sleep(20000);
	
	}
	
	
}
