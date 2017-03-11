import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ScreenShots {
	
	// https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3318232
	
	@Test
	
	public void test() throws InterruptedException, IOException {

	
		
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
		AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
		
		
		
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

	WebDriverWait _wait = new WebDriverWait(driver, 500);
	
	
	File path = new File(System.getProperty("user.dir")+ "\\screenshot\\error.png");
	System.out.println(path.getAbsolutePath());
	Thread.sleep(5000);
	driver.rotate(ScreenOrientation.LANDSCAPE);
	Thread.sleep(5000);
	File file = driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file, path);
	driver.rotate(ScreenOrientation.PORTRAIT);
	Thread.sleep(5000);
	
	}

}
