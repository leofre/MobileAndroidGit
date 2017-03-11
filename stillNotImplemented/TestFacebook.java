import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumSetting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TestFacebook {
	
	
	
	@Test
	
	public void test() throws MalformedURLException, InterruptedException {
	
    
	File appDir = new File("src");
	File app = new File(appDir, "facebook.apk");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "900");
	cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	AndroidDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	
		
		/*
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.facebook.katana");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.facebook.browser.lite.BrowserLiteActivity");
		*/
		
	driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

	WebDriverWait _wait = new WebDriverWait(driver, 500);
	
	
	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.facebook.katana:id/login_username"))));	
	Set<String> s= driver.getContextHandles();
	for (String item: s)
	{
		System.out.println(item);

	}
	
	driver.findElement(By.id("com.facebook.katana:id/login_username")).sendKeys("leonidattractionmarketing@gmail.com");
	driver.findElement(By.id("com.facebook.katana:id/login_username")).click();

	Thread.sleep(3000);
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.facebook.katana:id/login_password"))));		
	driver.findElement(By.id("com.facebook.katana:id/login_password")).sendKeys("leon21061987167167");
	driver.findElement(By.id("com.facebook.katana:id/login_login")).click();

	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.facebook.katana:id/dbl_on"))));		
	driver.findElement(By.id("com.facebook.katana:id/dbl_on")).click();

	
	driver.findElement(By.id("com.facebook.katana:id/search_edit_text")).sendKeys("vitacost");

	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@content-desc='vitacost.com']"))));		
	driver.findElement(By.xpath("//*[@content-desc='vitacost.com']")).click();
	
	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@content-desc,'[badge] Health/Beauty')]"))));		
	driver.findElement(By.xpath("//*[contains(@content-desc,'[badge] Health/Beauty')]")).click();

	
	System.out.println("before1");

	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='Send a message to this Page.']"))));
	System.out.println("after1");

	driver.findElement(By.xpath("//*[@text='Send a message to this Page.']")).click();
	System.out.println("after2");
	
	
	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@content-desc,'ABOUT')]"))));		
	driver.findElement(By.xpath("//*[contains(@content-desc,'ABOUT')]")).click();
	

	
	_wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@text='http://www.vitacost.com/']"))));	
	driver.findElement(By.xpath("//*[@text='http://www.vitacost.com/']")).click();

System.out.println("before");
Thread.sleep(10000);
Set<String> l= driver.getContextHandles();
for (String item: l)
{
	System.out.println(item);

}


// maybe need first to click on blank page

driver.findElement(By.xpath("//*[contains(text(),'Reset & Restart')]")).click();

System.out.println("after");



	


	
	}

}
