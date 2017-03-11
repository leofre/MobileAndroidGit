package other;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BuiltInCallingAppr {
	
	
	// https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3348186
	
	@Test // Start Appium
	
	public void test() throws MalformedURLException, InterruptedException {

	
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.contacts.activities.PeopleActivity");
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		
		
		
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	WebDriverWait _wait = new WebDriverWait(driver, 30);
	
   _wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='Keypad']"))));
	driver.findElement(By.xpath("//*[@text='Keypad']")).click();
	driver.getKeyboard().sendKeys("0525264883");

	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='0525264883']"))));
	driver.findElement(By.id("com.android.contacts:id/dialButton")).click();

	
	}
	
	

}
